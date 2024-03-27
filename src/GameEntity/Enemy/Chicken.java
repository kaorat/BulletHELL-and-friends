package GameEntity.Enemy;

import GameEntity.Bullet.EnemyBullet;
import Manager.BulletManager;
import Manager.EnemyManager;
import Utils.Asset;
import Utils.EnemyType;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Chicken extends BaseEnemy{


    public Chicken(Transform transform,int z) {
        super(EnemyType.CHICKEN,transform, z);
        setImage(Asset.UI.soulUI);
        // ---- Suchas comment: come with parameter instead -----
        Perks = EnemyManager.getInstance().getChickenPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {
        // circular direction
        // ---- Suchas comment: for loop?? and please make this a util-----
        EnemyBullet bullet1 = new EnemyBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY() + 20, 90, 2, 2), 0);
        EnemyBullet bullet2 = new EnemyBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY() + 20, 85, 2, 2), 0);
        EnemyBullet bullet3 = new EnemyBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY() + 20, 80, 2, 2), 0);
        EnemyBullet bullet4 = new EnemyBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY() + 20, 95, 2, 2), 0);
        EnemyBullet bullet5 = new EnemyBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY() + 20, 100, 2, 2), 0);
        BulletManager.getInstance().add(bullet1);
        BulletManager.getInstance().add(bullet2);
        BulletManager.getInstance().add(bullet3);
        BulletManager.getInstance().add(bullet4);
        BulletManager.getInstance().add(bullet5);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(),this.transform.getPosX(),this.transform.getPosY(), 60,60);
    }

}


