package GameEntity.Enemy;

import Manager.EnemyManager;

public class Cow extends BaseEnemy{
    public Cow(int hp, int fireRate, int bulletSpeed, int bulletQuantity, int bulletLength, double soulChance) {
        super(hp, fireRate, bulletSpeed, bulletQuantity, bulletLength, soulChance);
        Perks = EnemyManager.getInstance().getCowPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }
}
