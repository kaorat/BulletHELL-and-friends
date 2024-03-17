package GameEntity.Enemy;

import GameEntity.GameObject;
import Manager.EnemyManager;
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

    public static final Object[][] PERKS = {
            // Index, Perk Name, Base Value, Upgrade Value
            {0, "Parts Drop", 25, null},
            {1, "Calcium Gene - Enemy HP", 100, 15},
            {2, "Agility Gene - Enemy Fire Rate", 2.4, 0.7},
            {3, "Lethal Mutation - Bullet Speed", 1.2, 0.25},
            {4, "Fuzzy Mutation - Bullet Quantity", 8, 1},
            {5, "Elongation - Bullet Length", 2, 1},
            {6, "Genetic Drift - Chance to Obtain Soul", 10, 5},
            {7, "Fast Reproduction - Spawn Time", 2.0, -0.05}
    };

    public BaseEnemy(EnemyType type, Transform transform,int z){
        super(transform, z);

        this.hp = EnemyUtils.calculateHp(type);
        this.fireRate = EnemyUtils.calculateFireRate(type);
        this.bulletSpeed = EnemyUtils.calculateBulletSpeed(type);
        this.bulletQuantity = EnemyUtils.calculateBulletQuantity(type);
        this.bulletLength = EnemyUtils.calculateBulletLength(type);
        this.soulChance = EnemyUtils.calculateSoulChance(type) ;


    }

    public abstract void startFiring(); //start thread?
    public abstract void firing();


    @Override
    public void draw(GraphicsContext gc) {

    }

    @Override
    public void onUpdate() {

    }

    public ArrayList<Integer> getPerks() {
        return Perks;
    }
}
