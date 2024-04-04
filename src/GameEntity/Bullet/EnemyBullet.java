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
    private boolean isGrazed;
    public EnemyBullet(double speed, Transform transform, double z,int graphic) {
        super(speed, transform,z,Asset.Game.enemyBullet);
        isGrazed=false;
        //setImage(Asset.Game.enemyBullet);
    }

    @Override
    public void draw(GraphicsContext gc) {

        // ---- Suchas comment: Calibration? that's okay-----
        //gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 10, 10);
        Utility.DrawImage(gc,getImage(),transform);
//        this.bounds = new BoundingBox(transform.getPosX(),transform.getPosY(),10,10); // manual offset calibration
        drawBounds(0.25,0.25, 0.5, 0.5);
//        gc.setStroke(Color.BLACK);
//        gc.strokeRect(bounds.getMinX(),bounds.getMinY(),bounds.getWidth(),bounds.getHeight());
    }

    @Override
    public void onUpdate() {
//        transform.translate(3);
//        if( !(this.owner instanceof Cow) &&  Transform.calculateDistanceToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()) <= 400 && !isRotChanged) {
//            isRotChanged = true;
//        }
//        if(!(this.owner instanceof Cow) && Transform.calculateDistanceToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()) > 400 && !isRotChanged) {
//            transform.setRot(Transform.calculateAngleToTarget(this.transform, PlayerManager.getInstance().getPlayer().getTransform()));
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
