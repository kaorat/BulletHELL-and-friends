package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Asset;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class BaseBullet extends GameObject {
    // ---- Suchas comment: Fixed, How to use -> last parameter is int, determining sprite No.-----
    public BaseBullet(double speed, Transform transform, double z,Image graphic) {
        super(transform,z);
        transform.setSpeed(speed);
        setImage(graphic);//Use this
    }

}
