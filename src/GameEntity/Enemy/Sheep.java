package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.EnemyType;
import Utils.Transform;

public class Sheep extends BaseEnemy{
    public Sheep(Transform transform,int z) {
        super(EnemyType.SHEEP,transform,z);
        Perks = EnemyManager.getInstance().getSheepPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }
}
