package Utils;

import GameEntity.Bullet.PlayerBullet;
import GameEntity.Enemy.BaseEnemy;
import GameEntity.Player.Player;
import Manager.BulletManager;
import Manager.EnemyManager;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

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

        for(int i = 0; i < 10; i++){
            //TODO
            PlayerBullet bullet = new PlayerBullet(10, player, new Transform(player.getTransform().getPosX() + 50, player.getTransform().getPosY() + 20, -180 + i * 20, 2, 2), 0);
            bullet.setImage(Asset.UI.upgradeButtonHover);
            BulletManager.getInstance().add(bullet);
        }
    }

    public static void autoAim(Player player){
        ArrayList<BaseEnemy> enemies = EnemyManager.getInstance().getEnemies();
        if(enemies.isEmpty()){
            return;
        }
        BaseEnemy enemy = enemies.getFirst();
        Transform tf = enemy.getTransform();
        double rot = Transform.calculateAngleToTarget(player.getTransform(), tf);
        PlayerBullet bullet = new PlayerBullet(10, player, new Transform(player.getTransform().getPosX() + 25, player.getTransform().getPosY() + 20, rot, 2, 2), 0);
        BulletManager.getInstance().add(bullet);

        AudioClip bulletSound = Asset.Audio.bulletSound;
        bulletSound.setVolume(0.1);
        bulletSound.play();
        }

}
