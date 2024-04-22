package GameEntity.Player;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import GameEntity.GameObject;
import GameEntity.Item.Coin;
import Manager.*;
import Utils.*;
import javafx.animation.AnimationTimer;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

import static Input.InputUtility.isShiftPressed;
import static Input.InputUtility.isSlashPressed;

public class Player extends GameObject implements Shootable {
    public Bounds warpBox;
    private double speed;
    private Bounds hitbox;
    //    private double fireRate;
    private final ArrayList<Long> lastFireTime;
    private boolean isDying;
    private double iFrametime;
    private Image activeImage;

    public Player(Transform transform, double z) {
        super(transform, z);
        this.speed = Config.PLAYER_SPEED_BASE;
        setImage(Asset.UI.idle1);
        activeImage = Asset.UI.idle1;
        iFrametime = 355;
        isDying = false;
        lastFireTime = new ArrayList<>(Arrays.asList(0L,0L,0L));
        iFrame();
    }

    private void iFrame() {
        new AnimationTimer() {
            public void handle(long now) {
                if (iFrametime < 0) {
                    this.stop();
                }
                visible = !(iFrametime % 36 >= 0) || !(iFrametime % 36 <= 18);
                iFrametime--;
            }
        }.start();
    }

    public void checkOutOfBounds() {
        if (this.transform.getPosX() < 0) {
            this.transform.setPosX(0);
        }
        if (this.transform.getPosX() + transform.getSclX() * getImage().getWidth() > Utility.getGameScreenX()) {
            this.transform.setPosX(Utility.getGameScreenX() - transform.getSclX() * getImage().getWidth());
        }
        if (this.transform.getPosY() < 0) {
            this.transform.setPosY(0);
        }
        if (this.transform.getPosY() + transform.getSclY() * getImage().getHeight() > 700) {
            this.transform.setPosY(700 - transform.getSclY() * getImage().getHeight());
        }
    }

    public void shoot() {
        double fireRate = PlayerManager.getInstance().getBioticRifleFireRate() * 1000;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastFireTime.get(0) > fireRate) {
            PlayerUtils.normal(this);
            lastFireTime.set(0, currentTime);
        }
        if (StatManager.getInstance().getDnaLevels().get(0) > 0 && currentTime - lastFireTime.get(1) > fireRate*5) {
            PlayerUtils.autoAim(this);
            lastFireTime.set(1, currentTime);
        }
        if(StatManager.getInstance().getDnaLevels().get(1) > 0 && currentTime - lastFireTime.get(2) > 30){
            PlayerUtils.Laser(this);
            lastFireTime.set(2, currentTime);
        }
    }

    public void drawHitbox() {
        double offset = (0.25 + 0.05 * (5 - PlayerManager.getInstance().getMinimize()));
        double scale = PlayerManager.getInstance().getMinimize() / 10;
        this.hitbox = new BoundingBox(transform.getPosX() + (offset * image.getWidth() * transform.getSclX()), transform.getPosY() + (offset * image.getHeight() * transform.getSclY()), image.getWidth() * transform.getSclX() * scale, image.getHeight() * transform.getSclY() * scale);
    }

    public void drawGrazebox() {
        double offset = -PlayerManager.getInstance().getDexterity() * 5 + (image.getWidth() * transform.getSclX()) / 2 - 1;
        double scale = PlayerManager.getInstance().getDexterity() / 5;
        this.bounds = new BoundingBox(transform.getPosX() + offset, transform.getPosY() + offset, image.getWidth() * transform.getSclX() * scale, image.getHeight() * transform.getSclY() * scale);
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (!visible) {
            return;
        }
        drawHitbox();
        drawGrazebox();
        activeImage = Asset.UI.idle1;
        if(isSlashPressed() && warpBox != null){
            activeImage = Asset.UI.idle2;
            gc.setStroke(Color.LIGHTYELLOW);
            gc.strokeRect(warpBox.getMinX(), warpBox.getMinY(), warpBox.getWidth(), warpBox.getHeight());
        }
        if (isDying) activeImage = Asset.UI.attacked;
        Utility.drawImage(gc, activeImage, this.transform);

        if (isShiftPressed()) {
            gc.setStroke(Color.RED);
            gc.strokeRect(hitbox.getMinX(), hitbox.getMinY(), hitbox.getWidth(), hitbox.getHeight());
        }
    }

    private void Death() {
        isDying = true;
        StatManager.getInstance().addDeath();
        double startFrame = System.currentTimeMillis();
        Track.PLAYERDEAD.setVolume(0.5);
        Track.PLAYERDEAD.play();
        new AnimationTimer() {
            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame > 3000) {
                    setDestroyed(true);
                    this.stop();
                }
                transform.setScl(Math.max(transform.getSclX() - 0.0008, 0), Math.max(transform.getSclY() - 0.0008, 0));
            }
        }.start();
    }

    @Override
    public void onUpdate() {
        if (isDying) {
            return;
        }
        if (isShiftPressed()) {
            speed = Config.PLAYER_SPEED_SHIFT;
        } else {
            speed = Config.PLAYER_SPEED_BASE;
        }
        shoot();
        PlayerUtils.teleport(this);
        Utility.controlUtility(this.transform, speed);
        checkOutOfBounds();
        autoCollect();
        //Check collision with enemy bullet
        ArrayList<BaseBullet> bulletList = BulletManager.getInstance().getBullets();
        if (iFrametime > 0) {
            return;
        }
        for (BaseBullet bullet : bulletList) {
            if (bullet instanceof EnemyBullet) {
                if (Transform.checkCollide(this.hitbox, bullet.getBounds())) {
                    bullet.setDestroyed(true);
                    Death();
                }
                if (Transform.checkCollide(this.bounds, bullet.getBounds()) && !((EnemyBullet) bullet).isGrazed()) {
                    ItemManager.getInstance().add(new Coin(bullet.getTransform().getPosX(), bullet.getTransform().getPosY(), 0.04, (long) PlayerManager.getInstance().getProficiency(), false));
                    ((EnemyBullet) bullet).setGrazed(true);
                }
            }
        }
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    private void autoCollect() {
        if (this.transform.getPosY() <= 175) {
            ItemManager.getInstance().activateAutoCollect();
        }
    }

}
