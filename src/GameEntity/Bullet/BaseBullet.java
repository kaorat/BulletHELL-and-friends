package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Transform;
import javafx.scene.image.Image;

public abstract class BaseBullet extends GameObject {
    public BaseBullet(double speed, Transform transform, double z,Image graphic) {
        super(transform,z);
        transform.setSpeed(speed);
        setImage(graphic);//Use this
    }

}
