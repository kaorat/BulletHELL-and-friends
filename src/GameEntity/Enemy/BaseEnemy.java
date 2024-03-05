package GameEntity.Enemy;

import GameEntity.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class BaseEnemy extends GameObject {

    protected int hp;
    protected int fireRate;
    protected int bulletSpeed;
    protected int bulletQuantity;
    protected int bulletLength;
    protected double soulChance;
    protected ArrayList<Integer> Perks;

    public BaseEnemy(){ // just for demonstration
        this.hp = 100;
        this.fireRate = 1;
        this.bulletSpeed = 1;
        this.bulletQuantity = 1;
        this.bulletLength = 1;
        this.soulChance = 0.1;
    }

    public BaseEnemy(int hp, int fireRate, int bulletSpeed, int bulletQuantity, int bulletLength, double soulChance){
        this.hp = hp;
        this.fireRate = fireRate;
        this.bulletSpeed = bulletSpeed;
        this.bulletQuantity = bulletQuantity;
        this.bulletLength = bulletLength;
        this.soulChance = soulChance;
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
