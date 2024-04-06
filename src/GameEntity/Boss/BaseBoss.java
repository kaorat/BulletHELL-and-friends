package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.SceneManager;
import Manager.StatManager;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class BaseBoss extends GameObject {
    protected double hp;
    protected double maxHp;
    //142 = 1 sec (WTF)
    protected int frame;
    public BaseBoss(){
        //Pattern here
        super(new Transform(250,-200),30);
        frame=0;
        transform.translateToPositionInMilliSecond(250,100,3000);
    }
//    to set firing pattern for each boss

    public double getHp() {
        return hp;
    }

    public double getMaxHp() { return maxHp; }
    public abstract void action();

    @Override
    public void onUpdate() {
        //bullet collision
        action();
        BulletManager bm = BulletManager.getInstance();
        ArrayList<BaseBullet> bulletList = bm.getBullets();
        if(hp<=0){
            //TODO:Tell StatManager that I'm defeated
            StatManager.getInstance().setDna(StatManager.getInstance().getDna()+1);
            SceneManager.DeActivatedBossPage();
        }
        // check collision with player bullet
        for (BaseBullet bullet : bulletList) {
            if (Transform.checkCollide(this.getBounds(), bullet.getBounds()) && bullet instanceof PlayerBullet) {
                this.hp -= ((PlayerBullet)bullet).getDamage();
                bullet.setDestroyed(true);
            }
        }

        frame++;
        System.out.println(frame);
        if(frame>1200000){
            frame=0;
        }

    }

    @Override
    public void draw(GraphicsContext gc) {

    }
}
