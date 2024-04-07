package GameEntity.Player;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.PlayerManager;
import Manager.StatManager;
import Utils.*;
import javafx.animation.AnimationTimer;
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
    public Bounds warpBox;
//    private double fireRate;
    private long lastFireTime = 0;
    private boolean isDying;
    private double iFrametime;
    private Image activeImage;

    public Player(Transform transform, double z) {
        super(transform, z);
        this.speed = Config.PLAYER_SPEED_BASE;
        setImage(Asset.UI.idle1);
        activeImage = Asset.UI.idle1;
        iFrametime=355;
        isDying=false;
        IFrame();
    }
    private void IFrame(){
        new AnimationTimer() {
            public void handle(long now) {
                if(iFrametime<0){
                    this.stop();
                }
                if(iFrametime%36>=0&&iFrametime%36<=18){
                    visible=false;
                }
                else {
                    visible=true;
                }
                iFrametime--;
            }
        }.start();
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
        //getMinimize is max 5, from 0
//        double offset = (8 - PlayerManager.getInstance().getMinimize())/(10 + PlayerManager.getInstance().getMinimize());
//        System.out.println(offset);
        double offset = (0.25 + 0.05*(5 - PlayerManager.getInstance().getMinimize()));
//        System.out.println(image.getWidth());
        double scale = PlayerManager.getInstance().getMinimize() /10;
//        double offsetH = 0.25;
        this.hitbox = new BoundingBox(transform.getPosX() + (offset * image.getWidth() * transform.getSclX()),transform.getPosY() + ( offset * image.getHeight() * transform.getSclY()), image.getWidth()* transform.getSclX() * scale, image.getHeight()* transform.getSclY() * scale);
    }
    public void drawGrazebox(){
        double offset = -PlayerManager.getInstance().getDexterity() * 5 + (image.getWidth() * transform.getSclX())/2 -1;
        double scale = PlayerManager.getInstance().getDexterity() /5;
//        double offsetH = 0.25;
        this.bounds = new BoundingBox(transform.getPosX() + offset,transform.getPosY() + offset, image.getWidth()* transform.getSclX() * scale, image.getHeight()* transform.getSclY() * scale);
    }

    @Override
    public void draw(GraphicsContext gc) {
        if(!visible) { return; }
        drawHitbox();
        drawGrazebox();
        activeImage = Asset.UI.idle1;
//        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 60, 60);

        if(isSlashPressed()){
            activeImage = Asset.UI.idle2;
            gc.setStroke(Color.LIGHTYELLOW);
            gc.strokeRect(warpBox.getMinX(),warpBox.getMinY(),warpBox.getWidth(),warpBox.getHeight());
        }
        if(isDying) activeImage=Asset.UI.attacked;
        Utility.DrawImage(gc,activeImage,this.transform);

        if(isShiftPressed()){

            gc.setStroke(Color.GREENYELLOW);
            gc.strokeRect(bounds.getMinX(),bounds.getMinY(),bounds.getWidth(),bounds.getHeight());
            gc.setStroke(Color.RED);
            gc.strokeRect(hitbox.getMinX(),hitbox.getMinY(),hitbox.getWidth(),hitbox.getHeight());
        }
    }

    public void controlAggressiveShoot() {
        PlayerUtils.earthQuake(this);
    }
    private void Death(){
        isDying=true;
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            public void handle(long now) {
                if(System.currentTimeMillis()-startFrame>3000){
                    setDestroyed(true);
                    this.stop();
                }
                transform.setScl(Math.max(transform.getSclX()-0.0008,0),Math.max(transform.getSclY()-0.0008,0));
            }
        }.start();
    }
    @Override
    public void onUpdate() {
        if(isDying) {return;}
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
        //
        ArrayList<BaseBullet> bulletList = BulletManager.getInstance().getBullets();
        if(iFrametime>0) { return; }
        for (BaseBullet bullet : bulletList) {
                if(bullet instanceof EnemyBullet){
                    if(Transform.checkCollide(this.hitbox, bullet.getBounds())){
                        bullet.setDestroyed(true);
                        Death();
                    }
                    if(Transform.checkCollide(this.bounds, bullet.getBounds())&&!((EnemyBullet) bullet).isGrazed()){
                        StatManager.getInstance().addCoin((long) PlayerManager.getInstance().getProficiency());
                        ((EnemyBullet) bullet).setGrazed(true);
                    }
            }
        }
        //Check bounds with enemy bullets


    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public Bounds getHitbox() {
        return hitbox;
    }
    public void setActiveImage(Image activeImage) {
       this.activeImage = activeImage;
    }

}
