package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class BaseBoss extends GameObject {
    protected double hp;
    protected double maxHp;
    protected int frame;
    protected double lastframetime;
    public BaseBoss(){
        //Pattern here
        super(new Transform(100,50),20);
        frame=0;
        lastframetime=System.currentTimeMillis();
    }
//    to set firing pattern for each boss

    public double getHp() {
        return hp;
    }

    public double getMaxHp() { return maxHp; }

    public abstract void StartFiring();
    public abstract void firing();
    public abstract void action();

    @Override
    public void onUpdate() {
        //bullet collision
        action();
        BulletManager bm = BulletManager.getInstance();
        ArrayList<BaseBullet> bulletList = bm.getBullets();
        for (BaseBullet bullet : bulletList) {
            if (Transform.checkCollide(this.getBounds(), bullet.getBounds()) && bullet instanceof PlayerBullet) {
                this.hp -= ((PlayerBullet)bullet).getDamage();
                bullet.setDestroyed(true);
            }
        }
        frame=(int)(System.currentTimeMillis()-lastframetime);
        if(frame>1200000){
            frame%=120000;
            lastframetime=System.currentTimeMillis();
        }
        System.out.println(frame);
    }

    @Override
    public void draw(GraphicsContext gc) {

    }
}
