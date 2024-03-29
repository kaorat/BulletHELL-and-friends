package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

// ---- Suchas comment: Different from enemy's bullet, no?-----
public class BossBullet extends BaseBullet{

    public BossBullet(double damage, GameObject owner, Transform transform, double z) {
        super(damage, owner,transform,z);
    }

    @Override
    public void draw(GraphicsContext gc) {

    }

    @Override
    public void onUpdate() {

    }
}
