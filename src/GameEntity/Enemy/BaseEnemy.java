package GameEntity.Enemy;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.StatManager;
import Utils.EnemyType;
import Utils.EnemyUtils;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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

    protected enum States{
        UP,
        DOWN,
        SHOOT
    }

    protected States state;

    public BaseEnemy(Transform transform,double z){
        super(transform, z);

        this.fireRate = 700;
        this.partDrop = 11;
        state = States.DOWN;
        downtime= Math.random() * 1000 + 1400;
        uptime = downtime;
        shootTime = Math.random() * 3000 + 5000;

    }

    public abstract void firing();
    public abstract void action();
    public void ApplyStat(EnemyType type){
        this.partDrop = Perks.get(0);
        this.hp = EnemyUtils.calculateStat(type,1,Perks.get(1));
        this.fireRate = EnemyUtils.calculateStat(type,2,Perks.get(2));
        this.bulletSpeed = EnemyUtils.calculateStat(type,3,Perks.get(3));
        this.bulletQuantity = (int)EnemyUtils.calculateStat(type,4,Perks.get(4));
        this.bulletLength = (int)EnemyUtils.calculateStat(type,5,Perks.get(5));
        this.soulChance = EnemyUtils.calculateStat(type,6,Perks.get(6)) ;
    }
    public void drawHpBar(GraphicsContext gc, EnemyType type){
        //TODO
//        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);
        gc.fillRect(transform.getPosX(),transform.getPosY()-7,(this.hp/EnemyUtils.calculateStat(type, 1 ,Perks.get(1))) * 80,5); // hard coded (image width varies)


    }
    @Override
    public void onUpdate() { //from animationTimer

        action();

        //bullet collision
        BulletManager bm = BulletManager.getInstance();
        ArrayList<BaseBullet> bulletList = bm.getBullets();
        if(this.hp<=0){
            EnemyUtils.DropParts(transform.getPosX(),transform.getPosY(),partDrop);
            this.setDestroyed(true);
            StatManager.getInstance().addKilled();
        }
        for (BaseBullet bullet : bulletList) {
            if (Transform.checkCollide(this.getBounds(), bullet.getBounds()) && bullet instanceof PlayerBullet) {
                this.hp -= ((PlayerBullet)bullet).getDamage();
                bullet.setDestroyed(true);
            }
        }

    }

}
