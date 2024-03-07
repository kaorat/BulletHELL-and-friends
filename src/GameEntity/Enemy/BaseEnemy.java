package GameEntity.Enemy;

import GameEntity.GameObject;
import Manager.EnemyManager;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class BaseEnemy extends GameObject {

    protected int hp;
    protected int fireRate;
    protected int bulletSpeed;
    protected int bulletQuantity;
    protected int bulletLength;
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

    public BaseEnemy(int hp, int fireRate, int bulletSpeed, int bulletQuantity, int bulletLength, double soulChance){
        this.hp = hp;
        this.fireRate = fireRate;
        this.bulletSpeed = bulletSpeed;
        this.bulletQuantity = bulletQuantity;
        this.bulletLength = bulletLength;
        this.soulChance = soulChance;

        //perk will be initialized in the child class
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
