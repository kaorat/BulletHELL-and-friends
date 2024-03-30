package Utils;

import GameEntity.Bullet.EnemyBullet;
import GameEntity.Enemy.Chicken;
import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import Manager.BulletManager;

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

            EnemyBullet bullet = new EnemyBullet(10, chicken, new Transform(chicken.getTransform().getPosX() + 50, chicken.getTransform().getPosY() + 20, 90 , 2, 2), 0);

            BulletManager.getInstance().add(bullet);
//        }
    }

    public static void SheepShootPattern(Sheep sheep){
        for(int i = 0; i < 3; i++){
            //TODO
            EnemyBullet bullet = new EnemyBullet(10, sheep, new Transform(sheep.getTransform().getPosX() + 50, sheep.getTransform().getPosY() + 20, 85 + i * 5, 2, 2), 0);
            bullet.setImage(Asset.UI.upgradeButtonHover);
            BulletManager.getInstance().add(bullet);
        }

    }

    public static void CowShootPattern(Cow cow){
        for(int i = 0; i <= 10; i++){
            //TODO
            EnemyBullet bullet = new EnemyBullet(10, cow, new Transform(cow.getTransform().getPosX() + 50, cow.getTransform().getPosY() + 20, 0 + i * 18, 2, 2), 0);
            bullet.setImage(Asset.Game.cowBullet);
            BulletManager.getInstance().add(bullet);
        }

    }

}
