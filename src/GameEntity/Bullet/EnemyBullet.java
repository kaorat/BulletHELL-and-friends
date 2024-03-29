package GameEntity.Bullet;

import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.Asset;
import Utils.Transform;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class EnemyBullet extends BaseBullet{
    // ---- Suchas comment: Bosses may shoot out bullet of different sprite, insert Image argument-----
    public EnemyBullet(double damage, GameObject owner, Transform transform, double z) {
        super(damage, owner,transform,z);
        setImage(Asset.Game.enemyBullet);
    }

    @Override
    public void draw(GraphicsContext gc) {

        // ---- Suchas comment: Calibration? that's okay-----
        gc.drawImage(getImage(), this.transform.getPosX() - 25, this.transform.getPosY(), 10, 10);
        this.bounds = new BoundingBox(transform.getPosX(),transform.getPosY(),1,1);
    }

    @Override
    public void onUpdate() {
        transform.translate(2);
        removeOutOfBounds();
        BulletManager.getInstance().removeDestroyed();
    }
}
