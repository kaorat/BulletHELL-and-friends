package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.EnemyType;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

public class Cow extends BaseEnemy{
    public Cow(Transform transform,double z) {
        super(EnemyType.COW,transform,z);
        Perks = EnemyManager.getInstance().getCowPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }

    @Override
    public void draw(GraphicsContext gc) {

    }
}
