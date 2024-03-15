package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

public class BaseBullet extends GameObject {

    protected float x,y;
    protected double damage;
    protected GameObject owner;

    public BaseBullet(double damage, GameObject owner, Transform transform, int z) {
        super(transform,z);
        this.damage = damage;
        this.owner = owner;
    }

    public boolean isOutOfBounds() {
        //idk
        return x < 0 || x > 640 || y < 0 || y > 720;
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
