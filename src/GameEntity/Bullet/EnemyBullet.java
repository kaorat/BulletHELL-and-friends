package GameEntity.Bullet;

import GameEntity.Enemy.Sheep;
import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.PlayerManager;
import Utils.Asset;
import Utils.Transform;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class EnemyBullet extends BaseBullet{
    // ---- Suchas comment: Bosses may shoot out bullet of different sprite, insert Image argument-----
    public EnemyBullet(double damage, GameObject owner, Transform transform, double z) {
        super(damage, owner,transform,z);
        setImage(Asset.Game.enemyBullet);
    }

    @Override
    public void draw(GraphicsContext gc) {

        // ---- Suchas comment: Calibration? that's okay-----
        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 10, 10);
        this.bounds = new BoundingBox(transform.getPosX(),transform.getPosY(),10,10); // manual offset calibration
        gc.setStroke(Color.WHITE);
        gc.strokeRect(bounds.getMinX(),bounds.getMinY(),bounds.getWidth(),bounds.getHeight());
    }

    @Override
    public void onUpdate() {
        transform.translate(3);
        if(this.owner instanceof Sheep &&  Transform.calculateDistanceToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()) <= 400 && !isRotChanged) {
            isRotChanged = true;
        }
        if(this.owner instanceof Sheep && Transform.calculateDistanceToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()) > 400 && !isRotChanged) {
            transform.setRot(Transform.calculateAngleToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()));
//            isRotChanged = true;
        }
        removeOutOfBounds();
        BulletManager.getInstance().removeDestroyed();
    }
}
