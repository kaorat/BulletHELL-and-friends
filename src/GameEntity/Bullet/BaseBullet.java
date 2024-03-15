package GameEntity.Bullet;

import GameEntity.GameObject;
import javafx.scene.canvas.GraphicsContext;

public class BaseBullet extends GameObject {

    protected float x,y;
    protected double damage;
    protected GameObject owner;

    public BaseBullet(double damage, GameObject owner) {
        this.damage = damage;
        this.owner = owner;
    }

    public boolean isOutOfBounds() {
        if(x < 0 || x > 1290 || y < 0 || y > 760) //idk
            return true;
        else
            return false;
    }

    @Override
    public void draw(GraphicsContext gc) {

    }

    @Override
    public void onUpdate() {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public GameObject getOwner() {
        return owner;
    }

    public void setOwner(GameObject owner) {
        this.owner = owner;
    }
}
