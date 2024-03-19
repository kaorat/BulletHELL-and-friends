package GameEntity.Bullet;

import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.Asset;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class EnemyBullet extends BaseBullet{
    // ---- Suchas comment: Bosses may shoot out bullet of different sprite, insert Image argument-----
    public EnemyBullet(double damage, GameObject owner, Transform transform, int z) {
        super(damage, owner,transform,z);
    }

    @Override
    public void draw(GraphicsContext gc) {

        Image bulletImage = Asset.Game.enemyBullet;
        // ---- Suchas comment: Calibration? that's okay-----
        gc.drawImage(bulletImage, this.transform.getPosX() - 25, this.transform.getPosY(), 10, 10);
    }

    @Override
    public void onUpdate() {
        transform.translate(3);
        removeOutOfBounds();
        BulletManager.getInstance().removeDestroyed();
    }


}
