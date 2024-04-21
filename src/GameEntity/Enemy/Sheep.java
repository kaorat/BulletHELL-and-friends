package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import input.MouseUtil;
import javafx.scene.canvas.GraphicsContext;

public class Sheep extends BaseEnemy {
    private final long maxHp;
    private long lastPatternTime;

    public Sheep(Transform transform, double z) {
        super(transform, z);
        setImage(Asset.Game.WhiteSheepIdleLeft);
        Perks = EnemyManager.getInstance().getSheepPerks();
        ApplyStat(EnemyType.SHEEP);
        lastPatternTime = 0;
        maxHp = (long) hp;
    }

    @Override
    public void firing() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPatternTime > 1000 * fireRate) {
            Track.TECHNOSHOOT1.setVolume(0.1);
            if (bulletQuantity > 0) Track.TECHNOSHOOT1.play();
            EnemyUtils.SheepShootPattern(this, bulletSpeed, bulletQuantity, bulletLength);
            lastPatternTime = currentTime;
        }
    }

    @Override
    public void action() {

        double renderTime = 10d;
        if (state == States.DOWN) {
            downtime -= renderTime;
            setImage(Asset.Game.WhiteSheepAimLeft);
            transform.setRot(90);
            transform.translate(0.7);
            if (downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            shootTime -= renderTime;
            setImage(Asset.Game.WhiteSheepShootLeft);
            firing();
            if (shootTime <= 0) state = States.UP;
        }
        if (state == States.UP) {
            uptime -= renderTime;
            setImage(Asset.Game.WhiteSheepIdleLeft);
            transform.setRot(270);
            transform.translate(0.7);

            if (uptime <= 0) destroyed = true;
        }
        boolean click = Utility.checkHover(getTransform(), getImage()) && MouseUtil.isActivated();
        if (click) {
            hp -= (double) maxHp / 10;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc, getImage(), transform);
        drawHpBar(gc, EnemyType.SHEEP);
        drawBounds(0, 0);

    }
}
