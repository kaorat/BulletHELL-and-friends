package GameEntity.Enemy;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.EnemyType;
import Utils.EnemyUtils;
import Utils.Transform;

import java.util.ArrayList;

public abstract class BaseEnemy extends GameObject {

    protected long partDrop;
    protected double hp;
    protected double fireRate;
    protected double bulletSpeed;
    protected int bulletQuantity;
    protected int bulletLength;
    protected double soulChance;
    protected ArrayList<Integer> Perks; // stores level of each perk

    protected double uptime;
    protected double downtime;
    protected double shootTime;
    protected long lastFireTime;
    protected enum States{
        UP,
        DOWN,
        SHOOT
    }

    protected States state;

    public BaseEnemy(Transform transform,double z){
        super(transform, z);

        this.fireRate = 700;// --Suchas Comment : PlaceHolder?
        this.partDrop = 11;
        state = States.DOWN;
        downtime= Math.random() * 1000 + 1400;
        uptime = downtime;
        shootTime = Math.random() * 3000 + 5000;

    }

    public abstract void firing();
    public abstract void action();
    public void ApplyStat(EnemyType type){
        this.partDrop = 10;
        this.hp = EnemyUtils.calculateStat(type,1,Perks.get(1));
        this.fireRate = EnemyUtils.calculateStat(type,2,Perks.get(2));
        this.bulletSpeed = EnemyUtils.calculateStat(type,3,Perks.get(3));
        this.bulletQuantity = (int)EnemyUtils.calculateStat(type,4,Perks.get(4));
        this.bulletLength = (int)EnemyUtils.calculateStat(type,5,Perks.get(5));
        this.soulChance = EnemyUtils.calculateStat(type,6,Perks.get(6)) ;
    }
    @Override
    public void onUpdate() { //from animationTimer

        action();

        //bullet collision
        BulletManager bm = BulletManager.getInstance();
        ArrayList<BaseBullet> bulletList = bm.getBullets();
        for (BaseBullet bullet : bulletList) {
            if (Transform.checkCollide(this.getBounds(), bullet.getBounds()) && bullet instanceof PlayerBullet) {
                this.hp -= ((PlayerBullet)bullet).getDamage();
                bullet.setDestroyed(true);
                EnemyUtils.DropParts(transform.getPosX(),transform.getPosY(),partDrop);
                this.setDestroyed(true);
            }
        }

    }

    public ArrayList<Integer> getPerks() {
        return Perks;
    }
}
