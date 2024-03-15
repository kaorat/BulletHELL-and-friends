package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.EnemyType;
import Utils.Transform;

public class Chicken extends BaseEnemy{


    public Chicken(Transform transform,int z) {
        super(EnemyType.CHICKEN,transform, z);
        Perks = EnemyManager.getInstance().getChickenPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }
}


