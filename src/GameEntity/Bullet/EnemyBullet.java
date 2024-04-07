package GameEntity.Bullet;

import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;


public class EnemyBullet extends BaseBullet{
    private boolean isGrazed;
    public EnemyBullet(double speed, Transform transform, double z) {
        super(speed, transform,z,Asset.Game.enemyBullet);
        isGrazed=false;
    }

    @Override
    public void draw(GraphicsContext gc) {

        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0.25,0.25, 0.5, 0.5);
    }

    @Override
    public void onUpdate() {
        transform.translate();
        Utility.isOutOfBounds(this);
    }

    public boolean isGrazed() {
        return isGrazed;
    }

    public void setGrazed(boolean grazed) {
        isGrazed = grazed;
    }
}
