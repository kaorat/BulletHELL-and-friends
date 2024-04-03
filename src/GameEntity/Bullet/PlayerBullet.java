package GameEntity.Bullet;

import GameEntity.GameObject;
import Manager.BulletManager;
import Manager.EnemyManager;
import Manager.PlayerManager;
import Utils.Asset;
import Utils.Config;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerBullet extends BaseBullet {
    private double damage;
    public PlayerBullet(double speed, GameObject owner, Transform transform, double z,double damage,int graphic) {
        super(speed, owner, transform, z,Asset.Game.rifleBullet);
        this.damage = PlayerManager.getInstance().getBioticRifleDamage();
        //setImage(Asset.Game.bullet);
    }

    @Override
    public void draw(GraphicsContext gc) {

        //gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 10, 10);
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0, 0);

    }
    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
    @Override
    public void onUpdate() {
//        transform.setRot(-90);

        transform.translate(speed);

        Utility.isOutOfBounds(this);

    }
}
