package GameEntity.Enemy;

import Manager.EnemyManager;

public class Chicken extends BaseEnemy{


    public Chicken(int hp, int fireRate, int bulletSpeed, int bulletQuantity, int bulletLength, double soulChance) {
        super(hp, fireRate, bulletSpeed, bulletQuantity, bulletLength, soulChance);
        Perks = EnemyManager.getInstance().getChickenPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }
}


