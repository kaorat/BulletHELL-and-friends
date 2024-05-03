package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.SceneManager;
import Manager.StatManager;
import Utils.Config;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class BaseBoss extends GameObject {
    protected double hp;
    protected double maxHp;
    protected int frame;
    //Start pattern
    protected boolean ready;
    protected double fpsCal;

    public BaseBoss() {
        super(new Transform(250, -200), 30);
        //Move boss to center screen
        transform.translateToPositionInMilliSecond(250, 100, 3000);
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }
    public abstract void action();//Update on child node

    @Override
    public void onUpdate() {
        //Update on child node
        action();
        frame++;
        frame = (frame > 142000) ? 0 : frame;
        fpsCal = 1.0 / Config.fpsCalibration;
        //// check collision with player bullet
        ArrayList<BaseBullet> bulletList = BulletManager.getInstance().getBullets();
        for (BaseBullet bullet : bulletList) {
            if (Transform.checkCollide(this.getBounds(), bullet.getBounds()) && bullet instanceof PlayerBullet) {
                this.hp -= ((PlayerBullet) bullet).getDamage();
                bullet.setDestroyed(true);
            }
        }

        if (hp <= 0) {
            StatManager.getInstance().BossDefeated();
            StatManager.getInstance().setDna(StatManager.getInstance().getDna() + 1);
            SceneManager.DeActivatedBossPage();
        }
    }

    @Override
    public void draw(GraphicsContext gc) {

    }
}
