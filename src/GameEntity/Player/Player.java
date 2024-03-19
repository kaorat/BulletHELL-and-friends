package GameEntity.Player;

import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.Asset;
import Utils.Shootable;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static input.InputUtility.*;

public class Player extends GameObject implements Shootable {


    private int hp;
    private double speed;
    private long fireRate = 200;
    private long lastFireTime = 0;

    public Player(Transform transform, int z) {
        super(transform, z);
        this.speed = 1.7;
    }

    public void checkOutOfBounds() {
        if (this.transform.getPosX() < 0) {
            this.transform.setPosX(0);
        }
        if (this.transform.getPosX() > 800) {
            this.transform.setPosX(800);
        }
        if (this.transform.getPosY() < 0) {
            this.transform.setPosY(0);
        }
        if (this.transform.getPosY() > 760) {
            this.transform.setPosY(760);
        }
    }

    public void shoot() {
        PlayerBullet bullet = new PlayerBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY(), -90, 2, 2), 0);
        PlayerBullet bullet2 = new PlayerBullet(10, this, new Transform(this.transform.getPosX(), this.transform.getPosY(), -90, 2, 2), 0);
        BulletManager.getInstance().add(bullet);
        BulletManager.getInstance().add(bullet2);
//        System.out.println(BulletManager.getInstance().getBullets().size());
    }

    @Override
    public void draw(GraphicsContext gc) {
        Image playerImage = Asset.Game.player;
        gc.drawImage(playerImage, this.transform.getPosX(), this.transform.getPosY(), 60, 60);
    }

    public void controlAggressiveShoot() {
        PlayerBullet bulletR = new PlayerBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY() + 20, -70, 2, 2), 0);
        PlayerBullet bulletL = new PlayerBullet(10, this, new Transform(this.transform.getPosX(), this.transform.getPosY() + 20, -110, 2, 2), 0);
        // all direction
        PlayerBullet bulletRU = new PlayerBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY(), -50, 2, 2), 0);
        PlayerBullet bulletLU = new PlayerBullet(10, this, new Transform(this.transform.getPosX(), this.transform.getPosY(), -130, 2, 2), 0);

        BulletManager.getInstance().add(bulletR);
        BulletManager.getInstance().add(bulletL);
        BulletManager.getInstance().add(bulletRU);
        BulletManager.getInstance().add(bulletLU);
    }

    @Override
    public void onUpdate() {
//        System.out.println("Player Update : " + isAPressed());
        long currentTime = System.currentTimeMillis();
        if (isShiftPressed()) {
            fireRate = 80;
            speed = 3.5;
            if (currentTime - lastFireTime > fireRate) {
                shoot();
                controlAggressiveShoot();
                lastFireTime = currentTime;
            }
        }else{
            fireRate = 200;
            speed = 1.7;
            if (currentTime - lastFireTime > fireRate) {
                shoot();

                lastFireTime = currentTime;
            }
        }
        if (isWPressed() && isDPressed()) { // Move up-right
            transform.setRot(-45);
            transform.translate(speed);
        } else if (isWPressed() && isAPressed()) { // Move up-left
            transform.setRot(-135);
            transform.translate(speed);
        } else if (isSPressed() && isDPressed()) { // Move down-right
            transform.setRot(45);
            transform.translate(speed);
        } else if (isSPressed() && isAPressed()) { // Move down-left
            transform.setRot(135);
            transform.translate(speed);
        } else if (isSPressed()) { // Move down
            transform.setRot(90);
            transform.translate(speed);
        } else if (isWPressed()) { // Move up
            transform.setRot(-90);
            transform.translate(speed);
        } else if (isAPressed()) { // Move left
            transform.setRot(180);
            transform.translate(speed);
        } else if (isDPressed()) { // Move right
            transform.setRot(0);
            transform.translate(speed);
        }
        checkOutOfBounds();

    }
}
