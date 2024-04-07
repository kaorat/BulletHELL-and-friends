package Utils;

import GameEntity.Bullet.EnemyBullet;
import GameEntity.Enemy.Chicken;
import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import GameEntity.Item.Coin;
import Manager.BulletManager;
import Manager.ItemManager;
import Manager.PlayerManager;

public class EnemyUtils {

    public static double calculateStat(EnemyType type,int index,int level) {
        double stat;
        if(index == 4){
            if(type==EnemyType.COW){
                stat = (Config.COW_BULLET_QUANTITY_BASE + (Config.enemy_upgradeValues.get(index)*level*4));
            }
            else if(type==EnemyType.CHICKEN){
                stat = (Config.CHICKEN_BULLET_QUANTITY_BASE + (Config.enemy_upgradeValues.get(index)*level));
            }
            else {
                stat = (Config.SHEEP_BULLET_QUANTITY_BASE + (Config.enemy_upgradeValues.get(index)*level));
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
        return 1000*(Config.SPAWN_TIME_BASE + (Config.REPRODUCTION_SPAWN_TIME_UPGRADE*level));
    }
    public static void ChickenShootPattern(Chicken chicken,double speed){
            EnemyBullet bullet = new EnemyBullet(speed, new Transform(chicken.getTransform().getPosX() + 25, chicken.getTransform().getPosY() + 20, (Math.random()*360), 1, 1), 35);
            BulletManager.getInstance().add(bullet);
    }

    public static void SheepShootPattern(Sheep sheep,double speed,int quantity,int length){
        if(PlayerManager.getInstance().getPlayer()==null) { return; }
        double angleToP=Transform.calculateAngleToTarget(sheep.getTransform(), PlayerManager.getInstance().getPlayer().getTransform());
        int maxAngle = 10 * (quantity-1);
        if(quantity%2  == 0){
            for(int i=0;i<quantity;i++){
                for(int j=1;j<=length;j++){
                    EnemyBullet bullet = new EnemyBullet(speed-(speed*(j-1)/length), new Transform(sheep.getTransform().getPosX() + 25, sheep.getTransform().getPosY() + 20, angleToP - (double) (maxAngle / 2) + ((double) (i * maxAngle) /quantity), 1, 1), 35);
                    BulletManager.getInstance().add(bullet);
                }

            }
        }else{
            for(int i=0;i<quantity;i++){
                for(int j=1;j<=length;j++){
                    EnemyBullet bullet = new EnemyBullet(speed-(speed*(j-1)/length), new Transform(sheep.getTransform().getPosX() + 25, sheep.getTransform().getPosY() + 20, angleToP - (double) (maxAngle / quantity ) + ((double) (i * maxAngle) /quantity), 1, 1), 35);
                    BulletManager.getInstance().add(bullet);
                }

            }
        }

    }


    public static void CowShootPattern(Cow cow,int initRot,double speed,int quantity,int length){
        // circular direction
        for(int i = 0; i <= quantity; i++){
            for(int j=1;j<=length;j++){
                EnemyBullet bullet = new EnemyBullet(speed-(speed*(j-1)/length), new Transform(cow.getTransform().getPosX() + 25, cow.getTransform().getPosY() + 20, (initRot + ( (double) (i * 360) /quantity ))%360, 1, 1), 0);
                BulletManager.getInstance().add(bullet);
            }
            //TODO

        }

    }
    public static void DropParts(double ox,double oy,long parts){
        double x;
        double y;
        while(parts>=10000){
            x=(80*(Math.random()-0.25))+ox;
            y=(30*(Math.random()-0.25))+oy;
            ItemManager.getInstance().add(new Coin(x, y,0.08,10000));
            parts-=10000;
        }
        while(parts>=1000){
            x=(80*(Math.random()-0.25))+ox;
            y=(30*(Math.random()-0.25))+oy;
            ItemManager.getInstance().add(new Coin(x, y,0.07,1000));
            parts-=1000;
        }
        while(parts>=100){
            x=(80*(Math.random()-0.25))+ox;
            y=(30*(Math.random()-0.25))+oy;
            ItemManager.getInstance().add(new Coin(x, y,0.06,100));
            parts-=100;
        }
        while(parts>=10){
            x=(80*(Math.random()-0.25))+ox;
            y=(30*(Math.random()-0.25))+oy;
            ItemManager.getInstance().add(new Coin(x, y,0.05,10));
            parts-=10;
        }
        while(parts>0){
            x=(80*(Math.random()-0.25))+ox;
            y=(30*(Math.random()-0.25))+oy;
            ItemManager.getInstance().add(new Coin(x, y,0.04,1));
            parts-=1;
        }
    }
}
