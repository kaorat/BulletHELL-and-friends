package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Chicken extends BaseEnemy {

    private long lastPatternTime;

    public Chicken(Transform transform, double z) {
        super(transform, z);
        setImage(Asset.Game.whiteChickenShootRight);
        perks = EnemyManager.getInstance().getChickenPerks();
        applyStat(EnemyType.CHICKEN);
        lastPatternTime = 0;
    }

    @Override
    public void firing() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPatternTime > 1000 * fireRate * bulletQuantity) { // 5 seconds
            EnemyUtils.activateChickenShootPattern(this, bulletSpeed);
            lastPatternTime = currentTime;
        }

    }

    @Override
    public void action() {
        double renderTime = 8d;
        if (state == States.DOWN) {
            downtime -= renderTime;
            setImage(Asset.Game.whiteChickenAimRight);
            transform.setRot(90);
            transform.translate(0.7);
            if (downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            setImage(Asset.Game.whiteChickenShootRight);
            shootTime -= renderTime;
            firing();

            if (shootTime <= 0) state = States.UP;
        }
        if (state == States.UP) {
            uptime -= renderTime;
            setImage(Asset.Game.whiteChickenIdleRight);
            transform.setRot(270);
            transform.translate(0.7);

            if (uptime <= 0) destroyed = true;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawHpBar(gc, EnemyType.CHICKEN);
        drawBounds(0, 0);
    }

}


