package GameEntity.Bullet;

import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.Asset;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerBullet extends BaseBullet {
    public PlayerBullet(double damage, GameObject owner, Transform transform, int z) {
        super(damage, owner, transform, z);
    }

    @Override
    public void draw(GraphicsContext gc) {
        Image bulletImage = Asset.Game.bullet;
        gc.drawImage(bulletImage, this.transform.getPosX(), this.transform.getPosY(), 10, 10);
    }

    @Override
    public void onUpdate() {
//        transform.setRot(-90);
        transform.translate(5);
        removeOutOfBounds();
        BulletManager.getInstance().removeDestroyed();
    }
}
