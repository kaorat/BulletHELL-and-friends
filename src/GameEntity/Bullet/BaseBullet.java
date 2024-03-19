package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Asset;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BaseBullet extends GameObject {

    protected float x,y;
    protected double damage;
    protected GameObject owner;

    public BaseBullet(double damage, GameObject owner, Transform transform, int z) {
        super(transform,z);
        this.damage = damage;
        this.owner = owner;
    }

    public void removeOutOfBounds() {
        //idk
        if(this.transform.getPosY() < 0 || this.transform.getPosY() > 760 || this.transform.getPosX() < 0 || this.transform.getPosX() > 800) {
            destroyed = true;
        }
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
