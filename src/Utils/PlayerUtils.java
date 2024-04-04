package Utils;

import GameEntity.Boss.BaseBoss;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.Enemy.BaseEnemy;
import GameEntity.Player.Player;
import Manager.*;
import input.InputUtility;
import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

public class PlayerUtils {

    private static long lastTRTime = 0;
    private static long lastTLTime = 0;
    private static long lastBRTime = 0;
    private static long lastBLTime = 0;
    private static boolean slashPressed = false;
    private static double factor = 0;

    public static void normal(Player player){
        // player shooting pattern
        PlayerBullet bullet = new PlayerBullet(10, new Transform(player.getTransform().getPosX() + 50, player.getTransform().getPosY() + 20, -90, 1, 1), 0, PlayerManager.getInstance().getBioticRifleDamage(),1);
        PlayerBullet bullet2 = new PlayerBullet(10, new Transform(player.getTransform().getPosX(), player.getTransform().getPosY() + 20, -90, 1, 1), 0, PlayerManager.getInstance().getBioticRifleDamage(),1);
        BulletManager.getInstance().add(bullet);
        BulletManager.getInstance().add(bullet2);
    }

    public static void twin(Player player){
        // player shooting pattern
        for(int i = 0; i < 4; i++){
            PlayerBullet bullet = new PlayerBullet(10, new Transform(player.getTransform().getPosX() + 25 * i, player.getTransform().getPosY() + 20, -90, 1, 1), 0, PlayerManager.getInstance().getBioticRifleDamage(),1);
            BulletManager.getInstance().add(bullet);
        }
    }
    public static void earthQuake(Player player){
        // player shooting pattern

        for(int i = 0; i < 10; i++){
            //TODO
            PlayerBullet bullet = new PlayerBullet(10,new Transform(player.getTransform().getPosX() + 50, player.getTransform().getPosY() + 20, -180 + i * 20, 1, 1), 0, PlayerManager.getInstance().getBioticRifleDamage(),1);
            BulletManager.getInstance().add(bullet);
        }
    }

    public static void autoAim(Player player){
        Transform tf = new Transform(0,0);
        if(SceneManager.currentState== SceneManager.GameState.normal){
            ArrayList<BaseEnemy> enemies = EnemyManager.getInstance().getEnemies();
            if(enemies.isEmpty()){
                return;
            }
            BaseEnemy enemy = enemies.get(0);
            tf = enemy.getTransform();
        }
        else{
            BaseBoss boss = BossManager.getInstance().getBoss();
            if(boss==null){
                return;
            }
            tf = boss.getTransform();
        }


        double rot = Transform.calculateAngleToTarget(player.getTransform(), tf);
        PlayerBullet bullet = new PlayerBullet(10,new Transform(player.getTransform().getPosX() + 25, player.getTransform().getPosY() + 20, rot, 1, 1), 0, PlayerManager.getInstance().getBioticRifleDamage(),1);
        BulletManager.getInstance().add(bullet);

        AudioClip bulletSound = Asset.Audio.bulletSound;
        bulletSound.setVolume(0.1);
        bulletSound.play();
    }
    public static void teleport(Player player){

        long currentTime = System.currentTimeMillis();
        Transform t = player.getTransform();
        Point2D p = t.calculateTranslation(factor);
        player.warpBox = new BoundingBox(t.getPosX() + p.getX() ,t.getPosY() + p.getY(),player.getImage().getWidth() * t.getSclX() ,player.getImage().getHeight() * t.getSclY());
        if(InputUtility.isSlashPressed())
        {
            slashPressed = true;
            factor += 5;
            if(factor > 200) factor = 200;
        }
            if(slashPressed && !InputUtility.isSlashPressed()){
                t.setPosX(t.getPosX() + p.getX());
                t.setPosY(t.getPosY() + p.getY());
                lastTRTime = currentTime;
                Track teleportSound = new Track(Asset.Audio.bulletSound);
                teleportSound.setVolume(0.1);
                teleportSound.play();
                factor = 0;
                slashPressed = false;
            }

    }



}
