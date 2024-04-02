package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Asset;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class BaseBullet extends GameObject {

    protected double speed; //--Suchas comment : I fixed it
    protected GameObject owner;
    // ---- Suchas comment: Fixed, How to use -> last parameter is int, determining sprite No.-----
    public BaseBullet(double speed, GameObject owner, Transform transform, double z,Image graphic) {
        super(transform,z);
        this.speed = speed;
        this.owner = owner;
        setImage(graphic);//Use this
    }


    public GameObject getOwner() {
        return owner;
    }

    public void setOwner(GameObject owner) {
        this.owner = owner;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
