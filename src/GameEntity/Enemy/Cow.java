package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Cow extends BaseEnemy{
    public Cow(Transform transform,double z) {
        super(EnemyType.COW,transform,z);
        setImage(Asset.UI.guniconUI);
        Perks = EnemyManager.getInstance().getCowPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {
        EnemyUtils.CowShootPattern(this);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(),this.transform.getPosX(),this.transform.getPosY(), 60,60);
        drawBounds(Config.COW_OFFSET_WIDTH,Config.COW_OFFSET_HEIGHT,Config.COW_WIDTH,Config.COW_HEIGHT);
    }
}
