package GameEntity.Player;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.*;
import javafx.geometry.BoundingBox;
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
    private long fireRate = 200;
    private long lastFireTime = 0;

    public Player(Transform transform, double z) {
        super(transform, z);
        this.speed = 3.5;
        setImage(Asset.Game.player);
    }

    public void checkOutOfBounds() {
        if (this.transform.getPosX() < 0) {
            this.transform.setPosX(0);
        }
        if (this.transform.getPosX() + Config.PLAYER_WIDTH > Utility.getGameScreenX()) {
            this.transform.setPosX(Utility.getGameScreenX() - Config.PLAYER_WIDTH);
        }
        if (this.transform.getPosY() < 0) {
            this.transform.setPosY(0);
        }
        if (this.transform.getPosY() + Config.PLAYER_HEIGHT > 700) {
            this.transform.setPosY(700 - Config.PLAYER_HEIGHT); ;
            System.out.println(this.transform.getPosY());
        }
    }

    public void shoot() {
        PlayerUtils.normal(this);
        AudioClip bulletSound = Asset.Audio.bulletSound;
        bulletSound.setVolume(0.1);
        bulletSound.play();
//        System.out.println(BulletManager.getInstance().getBullets().size());
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 60, 60);
        if(isShiftPressed()){
            gc.setStroke(Color.GREENYELLOW);
          gc.strokeRect(bounds.getMinX(),bounds.getMinY(),bounds.getWidth(),bounds.getHeight());
        }
//        drawBounds(Config.PLAYER_OFFSET_WIDTH, Config.PLAYER_OFFSET_HEIGHT, Config.PLAYER_WIDTH, Config.PLAYER_HEIGHT);
        drawBounds(15,15,25,25);
    }

    public void controlAggressiveShoot() {
        PlayerUtils.earthQuake(this);

    }

    @Override
    public void onUpdate() {
//        System.out.println("Player Update : " + isAPressed());
        long currentTime = System.currentTimeMillis();
        // ---- !Suchas comment: Left Shift?? Gonna be pretty hard to balance na (Use only for slow and hitbox show)-----
        if (isShiftPressed()) {
            fireRate = 80;
            speed = 3;
            if (currentTime - lastFireTime > fireRate) {
                shoot();
//                controlAggressiveShoot();
                PlayerUtils.twin(this);
                lastFireTime = currentTime;

            }
        } else if (isSlashPressed()) {
            fireRate =  10;
            speed = 4;

            if (currentTime - lastFireTime > fireRate) {
                PlayerUtils.earthQuake(this);
                lastFireTime = currentTime;
            }

        }else {
        fireRate = 200;
            speed = 4;
            if (currentTime - lastFireTime > fireRate) {
                shoot();

                lastFireTime = currentTime;
            }
        }
        Utility.controlUtility(this.transform, speed);
        // ---- !Suchas comment: Could this be shorter? Lemme think-----
        checkOutOfBounds();
        ArrayList<BaseBullet> bulletList = BulletManager.getInstance().getBullets();
        for (BaseBullet bullet : bulletList) {
                if(bullet instanceof EnemyBullet){
                    if(Transform.checkCollide(this, bullet)){
                    bullet.setDestroyed(true);
                }
            }
        }


    }
}
