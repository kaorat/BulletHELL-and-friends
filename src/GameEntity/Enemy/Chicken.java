package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Chicken extends BaseEnemy {

    private long lastPatternTime;

    public Chicken(Transform transform, double z) {
        super(transform, z);
        setImage(Asset.Game.WhiteChickenShootRight);
        Perks = EnemyManager.getInstance().getChickenPerks();
        ApplyStat(EnemyType.CHICKEN);
        lastPatternTime = 0;
    }

    @Override
    public void firing() {
        // circular direction
        // utils got it
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPatternTime > 1000 * fireRate * bulletQuantity) { // 5 seconds
            EnemyUtils.ChickenShootPattern(this, bulletSpeed);
            lastPatternTime = currentTime;
        }

    }

    @Override
    public void action() {
        double renderTime = 8d;
        if (state == States.DOWN) {
            downtime -= renderTime;
            setImage(Asset.Game.WhiteChickenAimRight);
            transform.setRot(90);
            transform.translate(0.7);
            if (downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            setImage(Asset.Game.WhiteChickenShootRight);
            shootTime -= renderTime;
            firing();

            if (shootTime <= 0) state = States.UP;
        }
        if (state == States.UP) {
            uptime -= renderTime;
            setImage(Asset.Game.WhiteChickenIdleRight);
            transform.setRot(270);
            transform.translate(0.7);

            if (uptime <= 0) destroyed = true;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc, getImage(), transform);
        drawHpBar(gc, EnemyType.CHICKEN);
        drawBounds(0, 0);
    }

}


