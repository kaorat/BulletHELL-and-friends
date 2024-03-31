package Utils;

import GameEntity.Bullet.EnemyBullet;
import GameEntity.Enemy.Chicken;
import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import GameEntity.Item.Coin;
import Manager.BulletManager;
import Manager.ItemManager;
import Manager.PlayerManager;

import java.util.Random;

public class EnemyUtils {

    public static double calculateStat(EnemyType type,int index,int level) {
        double stat;
        if(index==6){
            if(type==EnemyType.COW){
                stat = (Config.COW_BULLET_QUANTITY_BASE+(Config.enemy_upgradeValues.get(index)*level));
            }
            else if(type==EnemyType.CHICKEN){
                stat = (Config.CHICKEN_QUANTITY_BASE+(Config.enemy_upgradeValues.get(index)*level));
            }
            else {
                stat = (Config.enemy_baseValues.get(index)+(Config.enemy_upgradeValues.get(index)*level));
            }
        }
        else{
            stat = (Config.enemy_baseValues.get(index)+(Config.enemy_upgradeValues.get(index)*level));
            if(index==1){
                stat*= (type == EnemyType.COW ? Config.COW_MULTIPLIER : 1) * (type == EnemyType.CHICKEN ? Config.CHICKEN_MULTIPLIER : 1);
            }
        }


        return stat;
    }
    public static double calculateSpawnRate(int level) {
        return 1000*(Config.SPAWN_TIME_BASE+(Config.REPRODUCTION_SPAWN_TIME_UPGRADE*level));
    }

    public static void ChickenShootPattern(Chicken chicken,double speed){
            EnemyBullet bullet = new EnemyBullet(speed, chicken, new Transform(chicken.getTransform().getPosX() + 25, chicken.getTransform().getPosY() + 20, (Math.random()*360), 2, 2), 0,0);
            BulletManager.getInstance().add(bullet);
    }

    public static void SheepShootPattern(Sheep sheep,double speed,int quantity,int length){

        double angleToP=Transform.calculateAngleToTarget(sheep.getTransform(), PlayerManager.getInstance().getPlayer().getTransform());
        int maxAngle = 10*quantity;
        for(int i=0;i<quantity;i++){
            for(int j=1;j<=length;j++){
                EnemyBullet bullet = new EnemyBullet(speed/j, sheep, new Transform(sheep.getTransform().getPosX(), sheep.getTransform().getPosY(), angleToP- (double) maxAngle /2 + ((double) (i * maxAngle) /quantity), 2, 2), 0,0);
                BulletManager.getInstance().add(bullet);
            }

        }

    }

    public static void CowShootPattern(Cow cow,int initRot,double speed,int quantity,int length){
        // semicircular direction
        for(int i = 0; i <= quantity; i++){
            for(int j=1;j<=length;j++){
                EnemyBullet bullet = new EnemyBullet(speed/j, cow, new Transform(cow.getTransform().getPosX() + 25, cow.getTransform().getPosY() + 20, (initRot + ( (double) (i * 360) /quantity ))%360, 2, 2), 0,0);
                BulletManager.getInstance().add(bullet);
            }
            //TODO

        }

    }
    public static void DropParts(double x,double y,long parts){
        while(parts>=10000){
            ItemManager.getInstance().add(new Coin(x, y,3,10000));
            parts-=10000;
        }
        while(parts>=1000){
            ItemManager.getInstance().add(new Coin(x, y,2.5,1000));
            parts-=1000;
        }
        while(parts>=100){
            ItemManager.getInstance().add(new Coin(x, y,2,100));
            parts-=100;
        }
        while(parts>=10){
            ItemManager.getInstance().add(new Coin(x, y,1.5,10));
            parts-=10;
        }
        while(parts>0){
            ItemManager.getInstance().add(new Coin(x, y,1,1));
            parts-=1;
        }
    }
}
