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
//        System.out.println(BulletManager.getInstance().getBullets().size());
    }
    public void drawHitbox(){
        double offset = (5 - PlayerManager.getInstance().getMinimize())/10;
        double scale = PlayerManager.getInstance().getMinimize() /5;
//        double offsetH = 0.25;
        this.hitbox = new BoundingBox(transform.getPosX() + (offset * image.getWidth() * transform.getSclX()),transform.getPosY() + ( offset * image.getHeight() * transform.getSclY()), image.getWidth()* transform.getSclX() * scale, image.getHeight()* transform.getSclY() * scale);
    }

    @Override
    public void draw(GraphicsContext gc) {
        drawHitbox();
        drawBounds(0, 0);
        Utility.DrawImage(gc,getImage(),this.transform);
//        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 60, 60);
        if(isShiftPressed()){
            gc.setStroke(Color.GREENYELLOW);
            gc.strokeRect(bounds.getMinX(),bounds.getMinY(),bounds.getWidth(),bounds.getHeight());
            gc.setStroke(Color.YELLOW);
            gc.strokeRect(hitbox.getMinX(),hitbox.getMinY(),hitbox.getWidth(),hitbox.getHeight());
        }
    }

    public void controlAggressiveShoot() {
        PlayerUtils.earthQuake(this);
    }

    @Override
    public void onUpdate() {
        double fireRate = PlayerManager.getInstance().getBioticRifleFireRate() * 1000;
        long currentTime = System.currentTimeMillis();
        if (isShiftPressed()) {
            speed = Config.PLAYER_SPEED_SHIFT;
            if (currentTime - lastFireTime > fireRate) {
//                controlAggressiveShoot();
                PlayerUtils.autoAim(this);
                lastFireTime = currentTime;

            } }

        else {
                speed = Config.PLAYER_SPEED_BASE;
                if (currentTime - lastFireTime > fireRate) {
                    shoot();

                    lastFireTime = currentTime;
                }
            }
            PlayerUtils.teleport(this);
        Utility.controlUtility(this.transform, speed);


        checkOutOfBounds();
        //Check collision with enemy bullet
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

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
