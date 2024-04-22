package GameEntity.Bullet;

import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerBullet extends BaseBullet {
    private final double damage;

    public PlayerBullet(double speed, Transform transform, double z, double damage, Image graphic) {
        super(speed, transform, z, graphic);
        this.damage = damage;
        //setImage(Asset.Game.bullet);
    }

    @Override
    public void draw(GraphicsContext gc) {

        //gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 10, 10);
        Utility.drawImage(gc, getImage(), transform);
        drawBounds(0, 0);

    }

    public double getDamage() {
        return damage;
    }

    @Override
    public void onUpdate() {
        transform.translate();

        Utility.isOutOfBounds(this);

    }
}
