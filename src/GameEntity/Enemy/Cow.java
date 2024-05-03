package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Cow extends BaseEnemy {
    private long lastPatternTime;
    private int initRot;


    public Cow(Transform transform, double z) {
        super(transform, z);
        sprites.add(Asset.Game.whiteCowAimLeft);
        sprites.add(Asset.Game.whiteCowShootLeft);
        sprites.add(Asset.Game.whiteCowIdleLeft);
        setImage(sprites.get(0));
        perks = EnemyManager.getInstance().getCowPerks();
        applyStat(EnemyType.COW);
        lastPatternTime = 0;
        initRot = 0;
    }

    @Override
    public void firing() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPatternTime > 1000 * fireRate) { // 5 seconds
            EnemyUtils.activateCowShootPattern(this, initRot, bulletSpeed, bulletQuantity, bulletLength);
            initRot += 10;
            lastPatternTime = currentTime;
        }

    }

    @Override
    public void action() {
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawHpBar(gc, EnemyType.COW);
        drawBounds(0, 0);
    }
}
