package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Cow extends BaseEnemy {
    private long lastPatternTime;
    private int initRot;


    public Cow(Transform transform, double z) {
        super(transform, z);
        setImage(Asset.Game.WhiteCowIdleLeft);
        Perks = EnemyManager.getInstance().getCowPerks();
        ApplyStat(EnemyType.COW);
        lastPatternTime = 0;
        initRot = 0;
    }

    @Override
    public void firing() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPatternTime > 1000 * fireRate) { // 5 seconds
            EnemyUtils.CowShootPattern(this, initRot, bulletSpeed, bulletQuantity, bulletLength);
            initRot += 10;
            lastPatternTime = currentTime;
        }

    }

    @Override
    public void action() {

        double renderTime = 16d;
        if (state == States.DOWN) {
            downtime -= renderTime;
            setImage(Asset.Game.WhiteCowAimLeft);
            transform.setRot(90);
            transform.translate(0.7);
            if (downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            shootTime -= renderTime;
            setImage(Asset.Game.WhiteCowShootLeft);
            firing();
            if (shootTime <= 0) state = States.UP;
        }
        if (state == States.UP) {
            uptime -= renderTime;
            setImage(Asset.Game.WhiteCowIdleLeft);
            transform.setRot(270);
            transform.translate(0.7);

            if (uptime <= 0) destroyed = true;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc, getImage(), transform);
        drawHpBar(gc, EnemyType.COW);
        drawBounds(0, 0);
    }
}
