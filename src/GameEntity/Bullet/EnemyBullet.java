package GameEntity.Bullet;

import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.PlayerManager;
import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class EnemyBullet extends BaseBullet{
    public EnemyBullet(double speed, GameObject owner, Transform transform, double z,int graphic) {
        super(speed, owner,transform,z,Asset.Game.enemyBullet);

        //setImage(Asset.Game.enemyBullet);
    }

    @Override
    public void draw(GraphicsContext gc) {

        // ---- Suchas comment: Calibration? that's okay-----
        //gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 10, 10);
        Utility.DrawImage(gc,getImage(),transform);
        this.bounds = new BoundingBox(transform.getPosX(),transform.getPosY(),10,10); // manual offset calibration
        gc.setStroke(Color.YELLOW);
        gc.strokeRect(bounds.getMinX(),bounds.getMinY(),bounds.getWidth(),bounds.getHeight());
    }

    @Override
    public void onUpdate() {
//        transform.translate(3);
//        if( !(this.owner instanceof Cow) &&  Transform.calculateDistanceToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()) <= 400 && !isRotChanged) {
//            isRotChanged = true;
//        }
//        if(!(this.owner instanceof Cow) && Transform.calculateDistanceToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()) > 400 && !isRotChanged) {
//            transform.setRot(Transform.calculateAngleToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()));
        transform.translate(speed);
        Utility.isOutOfBounds(this);
        BulletManager.getInstance().removeDestroyed();
    }
}
