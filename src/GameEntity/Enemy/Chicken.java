package GameEntity.Enemy;

import GameEntity.Bullet.EnemyBullet;
import Manager.BulletManager;
import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Chicken extends BaseEnemy{


    public Chicken(Transform transform,double z) {
        super(EnemyType.CHICKEN,transform, z);
        setImage(Asset.UI.soulUI);
        Perks = EnemyManager.getInstance().getChickenPerks();

    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {
        // circular direction
        // utils got it
        EnemyUtils.ChickenShootPattern(this);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(),this.transform.getPosX(),this.transform.getPosY(), 60,60);
        drawBounds(Config.CHICKEN_OFFSET_WIDTH, Config.CHICKEN_OFFSET_HEIGHT, Config.CHICKEN_WIDTH, Config.CHICKEN_HEIGHT);
    }

}


