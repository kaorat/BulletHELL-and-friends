package GameEntity.Bullet;

import GameEntity.GameObject;
import Manager.BulletManager;
import Utils.Asset;
import Utils.Config;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerBullet extends BaseBullet {
    public PlayerBullet(double damage, GameObject owner, Transform transform, double z) {
        super(damage, owner, transform, z);
        setImage(Asset.Game.bullet);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 10, 10);
        drawBounds(Config.PLAYER_BULLET_OFFSET_WIDTH, Config.PLAYER_BULLET_OFFSET_HEIGHT, Config.PLAYER_BULLET_WIDTH, Config.PLAYER_BULLET_HEIGHT);
    }

    @Override
    public void onUpdate() {
//        transform.setRot(-90);
        transform.translate(5);

        removeOutOfBounds();

        BulletManager.getInstance().removeDestroyed();
    }
}
