package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Sheep extends BaseEnemy{
    public Sheep(Transform transform,double z) {
        super(EnemyType.SHEEP,transform,z);
        setImage(Asset.UI.sheepiconUI);
        Perks = EnemyManager.getInstance().getSheepPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {
        EnemyUtils.SheepShootPattern(this);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(),this.transform.getPosX(),this.transform.getPosY(), 60,60);
        drawBounds(Config.SHEEP_OFFSET_WIDTH,Config.SHEEP_OFFSET_HEIGHT,Config.SHEEP_WIDTH,Config.SHEEP_HEIGHT);

    }
}
