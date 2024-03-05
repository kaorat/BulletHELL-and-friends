package GameEntity.Enemy;

import Manager.EnemyManager;

public class Sheep extends BaseEnemy{
    public Sheep(int hp, int fireRate, int bulletSpeed, int bulletQuantity, int bulletLength, double soulChance) {
        super(hp, fireRate, bulletSpeed, bulletQuantity, bulletLength, soulChance);
        Perks = EnemyManager.getInstance().getSheepPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }
}
