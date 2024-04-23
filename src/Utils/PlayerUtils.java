package Utils;

import GameEntity.Boss.BaseBoss;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.Enemy.BaseEnemy;
import GameEntity.Player.Player;
import Manager.*;
import Input.InputUtility;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

public class PlayerUtils {
    private static boolean slashPressed = false;
    private static double factor = 0;

    public static void normal(Player player){
        double damage = PlayerManager.getInstance().getBioticRifleDamage()*StatManager.getInstance().getGobletLevels().get(2);
        // player shooting pattern
        PlayerBullet bullet = new PlayerBullet(10, new Transform(player.getTransform().getPosX() + 50, player.getTransform().getPosY() + 20, -90, 1, 1), 0, damage,Asset.Game.rifleBullet);
        PlayerBullet bullet2 = new PlayerBullet(10, new Transform(player.getTransform().getPosX(), player.getTransform().getPosY() + 20, -90, 1, 1), 0, damage,Asset.Game.rifleBullet);
        BulletManager.getInstance().add(bullet);
        BulletManager.getInstance().add(bullet2);
        AudioClip bulletSound = Asset.Audio.rifleShoot;
        bulletSound.setVolume(0.1);
        bulletSound.play();
    }
    public static void Laser(Player player) {
        // player shooting pattern
        double damage = PlayerManager.getInstance().getBioticRifleDamage()*StatManager.getInstance().getGobletLevels().get(2)/4;
        PlayerBullet bullet = new PlayerBullet(20,new Transform(player.getTransform().getPosX()+20, player.getTransform().getPosY() + 20, -90, 1.5, 2.6), 0, damage,Asset.Game.laserBullet);
        BulletManager.getInstance().add(bullet);
    }

    public static void autoAim(Player player){
        double damage = PlayerManager.getInstance().getBioticRifleDamage()*StatManager.getInstance().getGobletLevels().get(2)*2;
        Bounds bounds;
        if (SceneManager.currentState == SceneManager.GameState.normal) {
            ArrayList<BaseEnemy> enemies = EnemyManager.getInstance().getEnemies();
            if (enemies.isEmpty()) {
                return;
            }
            BaseEnemy enemy = enemies.get(0);
            bounds = enemy.getBounds();
        } else {
            BaseBoss boss = BossManager.getInstance().getBoss();
            if (boss == null) {
                return;
            }
            bounds = boss.getBounds();
        }
        for(int i=0;i<2;i++){
            PlayerBullet bullet = new PlayerBullet(5,new Transform(player.getTransform().getPosX() + 75 - i*100, player.getTransform().getPosY() + 20, 0, 1, 1), 0, damage,Asset.Game.missileBullet);
            bullet.getTransform().setRot(Transform.calculateAngleToTarget(bullet.getTransform(), bounds));
            BulletManager.getInstance().add(bullet);
        }
        AudioClip bulletSound = Asset.Audio.missileShoot;
        bulletSound.setVolume(0.1);
        bulletSound.play();
    }

    public static void teleport(Player player) {
        Transform t = player.getTransform();
        Point2D p = t.calculateTranslation(factor);
        player.warpBox = new BoundingBox(t.getPosX() + p.getX(), t.getPosY() + p.getY(), player.getImage().getWidth() * t.getSclX(), player.getImage().getHeight() * t.getSclY());
        if (InputUtility.isSlashPressed()) {
            slashPressed = true;
            factor += 5;
            if (factor > 200) factor = 200;
        }
        if (slashPressed && !InputUtility.isSlashPressed()) {
            t.setPosX(t.getPosX() + p.getX());
            t.setPosY(t.getPosY() + p.getY());
            Track teleportSound = new Track(Asset.Audio.warp);
            teleportSound.setVolume(1);
            teleportSound.play();
            factor = 0;
            slashPressed = false;
        }
    }


}
