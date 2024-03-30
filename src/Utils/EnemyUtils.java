package Utils;

import GameEntity.Bullet.EnemyBullet;
import GameEntity.Enemy.Chicken;
import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import Manager.BulletManager;
import Manager.PlayerManager;

public class EnemyUtils {

    public static double calculateHp(EnemyType type) {
        switch (type) {
            case CHICKEN:

                break;
            case SHEEP:
                //TODO

                break;
            case COW:
                //TODO

                break;
        }
        return 0d;
    }

    public static double calculateFireRate(EnemyType type) {
        switch (type) {
            case CHICKEN:
                //TODO

                break;
            case SHEEP:
                //TODO

                break;
            case COW:
                //TODO

                break;
        }
        return 0d;
    }
    public static double calculateBulletSpeed(EnemyType type) {
        switch (type) {
            case CHICKEN:
                //TODO

                break;
            case SHEEP:
                //TODO

                break;
            case COW:
                //TODO

                break;
        }
        return 0d;
    }

    public static double calculateBulletQuantity(EnemyType type) {
        switch (type) {
            case CHICKEN:
                //TODO

                break;
            case SHEEP:
                //TODO

                break;
            case COW:
                //TODO

                break;
        }
        return 0d;
    }

    public static double calculateBulletLength(EnemyType type) {
        switch (type) {
            case CHICKEN:
                //TODO

                break;
            case SHEEP:
                //TODO

                break;
            case COW:
                //TODO

                break;
        }
        return 0d;
    }

    public static double calculateSoulChance(EnemyType type) {
        switch (type) {
            case CHICKEN:
                //TODO

                break;
            case SHEEP:
                //TODO

                break;
            case COW:
                //TODO


                break;
        }
        return 0d;
    }

    public static void ChickenShootPattern(Chicken chicken){
//        for(int i = 0; i < 3; i++){

            EnemyBullet bullet = new EnemyBullet(10, chicken, new Transform(chicken.getTransform().getPosX() + 25, chicken.getTransform().getPosY() + 20, 90 , 2, 2), 0);
            BulletManager.getInstance().add(bullet);
//        }
    }

    public static void SheepShootPattern(Sheep sheep){


        EnemyBullet bullet = new EnemyBullet(10, sheep, new Transform(sheep.getTransform().getPosX() -25, sheep.getTransform().getPosY() + 20, 0 , 2, 2), 0);
        EnemyBullet bullet2 = new EnemyBullet(10, sheep, new Transform(sheep.getTransform().getPosX() + 25, sheep.getTransform().getPosY() + 60, 0, 2, 2), 0);
        EnemyBullet bullet3 = new EnemyBullet(10, sheep, new Transform(sheep.getTransform().getPosX() +75, sheep.getTransform().getPosY() + 20,  0, 2, 2), 0);
//        bullet.getTransform().setRot(Transform.calculateAngleToTarget(sheep.getTransform(), PlayerManager.getInstance().getPlayer().getTransform()));
//        bullet2.getTransform().setRot(Transform.calculateAngleToTarget(sheep.getTransform(), PlayerManager.getInstance().getPlayer().getTransform()));
//        bullet3.getTransform().setRot(Transform.calculateAngleToTarget(sheep.getTransform(), PlayerManager.getInstance().getPlayer().getTransform()));
        BulletManager.getInstance().add(bullet);
        BulletManager.getInstance().add(bullet2);
        BulletManager.getInstance().add(bullet3);

    }

    public static void CowShootPattern(Cow cow, int pattern){
        // semicircular direction
        for(int i = 0; i <= 10; i++){

            //TODO
            EnemyBullet bullet = new EnemyBullet(10, cow, new Transform(cow.getTransform().getPosX() + 25, cow.getTransform().getPosY() + 20, 0 + ( i * 18 ), 2, 2), 0);
            BulletManager.getInstance().add(bullet);
        }

    }

}
