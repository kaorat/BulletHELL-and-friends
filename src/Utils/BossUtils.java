package Utils;

import GameEntity.Boss.BaseBoss;
import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import GameEntity.Enemy.Cow;
import Manager.BulletManager;

import java.util.ArrayList;
import java.util.List;

public class BossUtils {

    public static List<BaseBullet> circular(BaseBoss boss, int initRot, double speed, int quantity, double accel, double maxSpeed) {
        // circular direction
        double x = Transform.centerPos(boss).getX();
        double y = Transform.centerPos(boss).getY();
        List<BaseBullet> bullets = new ArrayList<BaseBullet>();
        for (int i = 0; i <= quantity; i++) {
            EnemyBullet bullet = new EnemyBullet(speed, new Transform(x, y, (initRot + ((double) (i * 360) / quantity)) % 360, 1, 1), 27, 0);
            BulletUtils.ChangeTrajectoryNow(bullet, speed, (initRot + ((double) (i * 360) / quantity)) % 360, accel, maxSpeed);
            BulletManager.getInstance().add(bullet);
            bullets.add(bullet);

        }
        return bullets;
    }


}
