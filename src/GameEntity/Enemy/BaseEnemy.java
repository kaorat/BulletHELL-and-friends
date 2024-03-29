package GameEntity.Enemy;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import GameEntity.Item.BaseItem;
import GameEntity.Item.Coin;
import Manager.BulletManager;
import Manager.EnemyManager;
import Manager.ItemManager;
import Utils.EnemyType;
import Utils.EnemyUtils;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class BaseEnemy extends GameObject {

    protected double hp;
    protected double fireRate;
    protected double bulletSpeed;
    protected double bulletQuantity;
    protected double bulletLength;
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

    // ---- Suchas comment: I got headache from this-----
//    public static final Object[][] PERKS = {
//            // Index, Perk Name, Base Value, Upgrade Value
//            {0, "Parts Drop", 25, null},
//            {1, "Calcium Gene - Enemy HP", 100, 15},
//            {2, "Agility Gene - Enemy Fire Rate", 2.4, 0.7},
//            {3, "Lethal Mutation - Bullet Speed", 1.2, 0.25},
//            {4, "Fuzzy Mutation - Bullet Quantity", 8, 1},
//            {5, "Elongation - Bullet Length", 2, 1},
//            {6, "Genetic Drift - Chance to Obtain Soul", 10, 5},
//            {7, "Fast Reproduction - Spawn Time", 2.0, -0.05}
//    };

    public BaseEnemy(EnemyType type, Transform transform,double z){
        super(transform, z);
        // ---- Suchas comment: ALL of this should be constructed on children classes, because it calculates level too, doesn't it-----
        // ---- or create one more argument (levels[]) -----
        this.hp = EnemyUtils.calculateHp(type);
        this.fireRate = EnemyUtils.calculateFireRate(type);
        this.bulletSpeed = EnemyUtils.calculateBulletSpeed(type);
        this.bulletQuantity = EnemyUtils.calculateBulletQuantity(type);
        this.bulletLength = EnemyUtils.calculateBulletLength(type);
        this.soulChance = EnemyUtils.calculateSoulChance(type) ;

        this.fireRate = 700;


        state = States.DOWN;
        downtime= Math.random() * 1000 + 1400;
        uptime = downtime;
        shootTime = Math.random() * 3000 + 5000;




    }

    public abstract void startFiring(); //start thread?
    public abstract void firing();

    //Transform is not meant to be added directly , I believe.
    // ---- Suchas comment: correct, add when instantiating only but can be edited though setter-----
    @Override
    public void onUpdate() { //from animationTimer
        // ---- Suchas comment: implement in manager please-----
//        EnemyManager.getInstance().removeDestroyed();
//        if(EnemyManager.getInstance().checkEnemyLeft()){ //less than 5
//            EnemyManager.getInstance().spawnEnemy(EnemyType.CHICKEN);
//        };

        double renderTime = 8d ; // idk  // Suchas comment: idk
        if(state == States.DOWN) {
            downtime -= renderTime;
            transform.setRot(90);
            transform.translate(0.7);
            if(downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            shootTime -= renderTime;
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastFireTime > fireRate) {
                firing();
                lastFireTime = currentTime;
            }

            if(shootTime <= 0) state = States.UP;
        }
        if(state == States.UP) {
            uptime -= renderTime;
            transform.setRot(270);
            transform.translate(0.7);

            if(uptime <= 0) destroyed = true;
        }

        //bullet collision
        BulletManager bm = BulletManager.getInstance();
        ArrayList<BaseBullet> bulletList = bm.getBullets();
        for (BaseBullet bullet : bulletList) {
            if (this.transform.checkCollide(this, bullet) && bullet instanceof PlayerBullet) {
//                this.hp -= bullet.getDamage();
                bullet.setDestroyed(true);
                Coin coin = new Coin(transform.getPosX(), transform.getPosY());
                ItemManager.getInstance().add(coin);
                this.setDestroyed(true);
            }
        }

//        System.out.println("Enemy state : " + state.toString());
    }

    public ArrayList<Integer> getPerks() {
        return Perks;
    }
}
