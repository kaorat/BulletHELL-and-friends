package GameEntity.Enemy;

import GameEntity.Bullet.EnemyBullet;
import Manager.BulletManager;
import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Chicken extends BaseEnemy{

    private long lastPatternTime = 0;

    public Chicken(Transform transform,double z) {
        super(transform, z);
        setImage(Asset.UI.soulUI);
        Perks = EnemyManager.getInstance().getChickenPerks();
        ApplyStat(EnemyType.CHICKEN);

    }

    @Override
    public void firing() {
        // circular direction
        // utils got it
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastPatternTime > 120*fireRate*bulletQuantity){ // 5 seconds
            EnemyUtils.ChickenShootPattern(this,bulletSpeed);
            lastPatternTime = currentTime;
        }

    }

    @Override
    public void action() {
        double renderTime = 8d ;
        if(state == States.DOWN) {
            downtime -= renderTime;
            transform.setRot(90);
            transform.translate(0.7);
            if(downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            shootTime -= renderTime;
            firing();
            if(shootTime <= 0) state = States.UP;
        }
        if(state == States.UP) {
            uptime -= renderTime;
            transform.setRot(270);
            transform.translate(0.7);

            if(uptime <= 0) destroyed = true;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        //gc.drawImage(getImage(),this.transform.getPosX(),this.transform.getPosY(), 60,60);
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0, 0);
    }

}


