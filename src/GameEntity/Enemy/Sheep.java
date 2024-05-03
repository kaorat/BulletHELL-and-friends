package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import Input.MouseUtil;
import javafx.scene.canvas.GraphicsContext;

public class Sheep extends BaseEnemy {
    private final long maxHp;
    private long lastPatternTime;

    public Sheep(Transform transform, double z) {
        super(transform, z);
        perks = EnemyManager.getInstance().getSheepPerks();
        sprites.add(perks.get(4) > 0 ? Asset.Game.whiteSheepAimLeft:Asset.Game.whiteSheepIdleLeft);
        sprites.add(perks.get(4) > 0 ? Asset.Game.whiteSheepShootLeft:Asset.Game.whiteSheepIdleLeft);
        sprites.add(Asset.Game.whiteSheepIdleLeft);
        setImage(sprites.get(0));
        applyStat(EnemyType.SHEEP);
        lastPatternTime = 0;
        maxHp = (long) hp;
    }

    @Override
    public void firing() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPatternTime > 1000 * fireRate) {
            Track.TECHNOSHOOT1.setVolume(0.1);
            if (bulletQuantity > 0) Track.TECHNOSHOOT1.play();
            EnemyUtils.activateSheepShootPattern(this, bulletSpeed, bulletQuantity, bulletLength);
            lastPatternTime = currentTime;
        }
    }

    @Override
    public void action() {
        boolean click = Utility.checkHover(getTransform(), getImage()) && MouseUtil.isActivated();
        if (click) {
            hp -= (double) maxHp / 10;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawHpBar(gc, EnemyType.SHEEP);
        drawBounds(0, 0);

    }
}
