package Utils;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import Manager.BulletManager;
import javafx.animation.AnimationTimer;


public class BulletUtils {
    //Enemy
    public static BaseBullet shoot(double x, double y, double speed, double angle){
        EnemyBullet bullet = new EnemyBullet(speed, new Transform(x, y, angle, 1, 1), Math.random()+35);
        BulletManager.getInstance().add(bullet);
        return bullet;
    }
    public static BaseBullet shoot(double x, double y, double speed, double angle,double accel,double maxSpeed){
        EnemyBullet bullet = new EnemyBullet(speed, new Transform(x, y, angle, 1, 1), Math.random()+35);
        bullet.getTransform().setMaxSpeed(maxSpeed);
        bullet.getTransform().setAccel(accel);
        BulletManager.getInstance().add(bullet);
        return bullet;
    }

    public static void changeTrajectoryNow(BaseBullet bullet, double speed, double angle, double accel, double maxSpeed) {
        bullet.getTransform().setSpeed(speed);
        bullet.getTransform().setRot(angle);
        bullet.getTransform().setMaxSpeed(maxSpeed);
        bullet.getTransform().setAccel(accel);
    }

    public static void changeTrajectoryOnFrame(BaseBullet bullet, double speed, double angle, double accel, double maxSpeed, double frame) {
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame > frame) {
                    bullet.getTransform().setSpeed(speed);
                    bullet.getTransform().setRot(angle);
                    bullet.getTransform().setMaxSpeed(maxSpeed);
                    bullet.getTransform().setAccel(accel);
                    this.stop();
                }
            }
        }.start();
    }
    public static void changeRotAndDestroyWithDuration(BaseBullet bullet, double angularRot, double phase1) {
        double startFrame = System.currentTimeMillis();

        new AnimationTimer() {
            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame <= phase1) {
//                    System.out.println("changing trajectory" + (System.currentTimeMillis() - startFrame));
                    bullet.getTransform().setRot(bullet.getTransform().getRot() + angularRot);

                    return;
                }
                this.stop();
            }
        }.start();

    }


}
