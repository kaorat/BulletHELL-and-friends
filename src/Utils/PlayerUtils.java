package Utils;

import GameEntity.Bullet.PlayerBullet;
import GameEntity.Player.Player;
import Manager.BulletManager;

public class PlayerUtils {
    public static void normal(Player player){
        // player shooting pattern
        PlayerBullet bullet = new PlayerBullet(10, player, new Transform(player.getTransform().getPosX() + 50, player.getTransform().getPosY() + 20, -90, 2, 2), 0);
        PlayerBullet bullet2 = new PlayerBullet(10, player, new Transform(player.getTransform().getPosX(), player.getTransform().getPosY() + 20, -90, 2, 2), 0);
        BulletManager.getInstance().add(bullet);
        BulletManager.getInstance().add(bullet2);
    }

    public static void twin(Player player){
        // player shooting pattern
        for(int i = 0; i < 4; i++){
            PlayerBullet bullet = new PlayerBullet(10, player, new Transform(player.getTransform().getPosX() + 25 * i, player.getTransform().getPosY() + 20, -90, 2, 2), 0);
            BulletManager.getInstance().add(bullet);
        }
    }
    public static void earthQuake(Player player){
        // player shooting pattern

//        PlayerBullet bulletR = new PlayerBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY() + 20, -70, 2, 2), 0);
//        PlayerBullet bulletL = new PlayerBullet(10, this, new Transform(this.transform.getPosX(), this.transform.getPosY() + 20, -110, 2, 2), 0);
//        // all direction
//        PlayerBullet bulletRU = new PlayerBullet(10, this, new Transform(this.transform.getPosX() + 50, this.transform.getPosY(), -50, 2, 2), 0);
//        PlayerBullet bulletLU = new PlayerBullet(10, this, new Transform(this.transform.getPosX(), this.transform.getPosY(), -130, 2, 2), 0);
//
//        BulletManager.getInstance().add(bulletR);
//        BulletManager.getInstance().add(bulletL);
//        BulletManager.getInstance().add(bulletRU);
//        BulletManager.getInstance().add(bulletLU);
        for(int i = 0; i < 10; i++){
            //TODO
            PlayerBullet bullet = new PlayerBullet(10, player, new Transform(player.getTransform().getPosX() + 50, player.getTransform().getPosY() + 20, -180 + i * 20, 2, 2), 0);
            bullet.setImage(Asset.UI.upgradeButtonHover);
            BulletManager.getInstance().add(bullet);
        }
    }
}
