package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.EnemyType;
import Utils.Transform;

public class Cow extends BaseEnemy{
    public Cow(Transform transform,int z) {
        super(EnemyType.COW,transform,z);
        Perks = EnemyManager.getInstance().getCowPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }
}
