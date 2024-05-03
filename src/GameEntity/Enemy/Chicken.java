package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Chicken extends BaseEnemy {

    private long lastPatternTime;

    public Chicken(Transform transform, double z) {
        super(transform, z);
        sprites.add(Asset.Game.whiteChickenAimRight);
        sprites.add(Asset.Game.whiteChickenShootRight);
        sprites.add(Asset.Game.whiteChickenIdleRight);
        setImage(sprites.get(0));
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

    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawHpBar(gc, EnemyType.CHICKEN);
        drawBounds(0, 0);
    }

}


