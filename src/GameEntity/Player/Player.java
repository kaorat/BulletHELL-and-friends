package GameEntity.Player;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.PlayerManager;
import Manager.StatManager;
import Utils.*;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static input.InputUtility.*;
// ---- Suchas comment: Interface is unnecessary but okay-----
public class Player extends GameObject implements Shootable {


    private int hp;
    private double speed;
    private Bounds hitbox;
//    private double fireRate;
    private long lastFireTime = 0;

    public Player(Transform transform, double z) {
        super(transform, z);
        this.speed = Config.PLAYER_SPEED_BASE;
        setImage(Asset.Game.player);
    }

    public void checkOutOfBounds() {
        if (this.transform.getPosX() < 0) {
            this.transform.setPosX(0);
        }
        if (this.transform.getPosX() + transform.getSclX()*getImage().getWidth() > Utility.getGameScreenX()) {
            this.transform.setPosX(Utility.getGameScreenX() - transform.getSclX()*getImage().getWidth());
        }
        if (this.transform.getPosY() < 0) {
            this.transform.setPosY(0);
        }
        if (this.transform.getPosY() + transform.getSclY()*getImage().getHeight() > 700) {
            this.transform.setPosY(700 - transform.getSclY()*getImage().getHeight()); ;
        }
    }

    public void shoot() {
        PlayerUtils.normal(this);
        AudioClip bulletSound = Asset.Audio.bulletSound;
        bulletSound.setVolume(0.1);
        bulletSound.play();
//        System.out.println(BulletManager.getInstance().getBullets().size());
    }
    public void drawHitbox(double offsetX, double offsetY){
        hitbox = new BoundingBox(this.transform.getPosX() + offsetX, this.transform.getPosY() + offsetY, 10,10);
    }

    @Override
    public void draw(GraphicsContext gc) {
        drawHitbox((transform.getSclX()*getImage().getWidth())/4,(transform.getSclY()*getImage().getHeight())/4);
        drawBounds(0, 0);
        Utility.DrawImage(gc,getImage(),this.transform);
//        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 60, 60);
        if(isShiftPressed()){
            gc.setStroke(Color.GREENYELLOW);
            gc.strokeRect(bounds.getMinX(),bounds.getMinY(),bounds.getWidth(),bounds.getHeight());
            gc.setStroke(Color.YELLOW);
            gc.strokeRect(hitbox.getMinX(),hitbox.getMinY(),hitbox.getWidth(),hitbox.getHeight());
        }
        //Suchas Comment : will change to image graphic right?
//        drawBounds(Config.PLAYER_OFFSET_WIDTH, Config.PLAYER_OFFSET_HEIGHT, Config.PLAYER_WIDTH, Config.PLAYER_HEIGHT);
    }

    public void controlAggressiveShoot() {
        PlayerUtils.earthQuake(this);
    }

    @Override
    public void onUpdate() {
        double fireRate = PlayerManager.getInstance().getBioticRifleFireRate() * 1000;
        long currentTime = System.currentTimeMillis();
        if (isShiftPressed()) {
            speed = 8;
            if (currentTime - lastFireTime > fireRate) {
//                controlAggressiveShoot();
                PlayerUtils.autoAim(this);
                lastFireTime = currentTime;

            }
        } else if (isSlashPressed()) {
            speed = 4;

            if (currentTime - lastFireTime > fireRate) {
                PlayerUtils.earthQuake(this);
                lastFireTime = currentTime;
            }

        }else {
            speed = Config.PLAYER_SPEED_BASE;
            if (currentTime - lastFireTime > fireRate) {
                shoot();

                lastFireTime = currentTime;
            }
        }
        Utility.controlUtility(this.transform, speed);

        checkOutOfBounds();

        //Check hitbox with enemy bullet
        ArrayList<BaseBullet> bulletList = BulletManager.getInstance().getBullets();
        for (BaseBullet bullet : bulletList) {
                if(bullet instanceof EnemyBullet){
                    if(Transform.checkCollide(this.hitbox, bullet.getBounds())){
                    bullet.setDestroyed(true);
                    }
                    if(Transform.checkCollide(this.bounds, bullet.getBounds())){
                        StatManager.getInstance().addCoin(1);

                    }
            }
        }
        //Check bounds with enemy bullets


    }

//    public void setFireRate(double fireRate) {
//        this.fireRate = fireRate;
//    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
