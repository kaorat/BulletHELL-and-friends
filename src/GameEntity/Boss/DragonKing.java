package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.GameObject;
import Manager.PlayerManager;
import Utils.*;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class DragonKing extends BaseBoss {
    public DragonKing() {
        super();
        maxHp = 1500000;
        hp = maxHp;
        ready = false;
        getTransform().setScl(0.75, 0.75);
        setImage(Asset.Game.toothless);
    }

    @Override
    public void action() {
        if (!ready) {
            if (frame > (int)(600 * fpsCal)) {
                ready = true;
            }
            return;
        }
        // Raise flame pillar now and then
        if (frame % (int)(1000 * fpsCal) == 0) {
            sendFlamePillar();
        }
        if (frame % (int)(1000 * fpsCal) == (500 * fpsCal) && hp < 750000) {
            sendFlamePillar();
        }

        // Phase 1
        if (hp >= 1000000) {
            if(frame % (int)(800 * fpsCal) == 0){
                choosingPattern(1, 3);
            }
        }
        // Phase 2
        else if (hp >= 500000) {
            if(frame % (int)(700 * fpsCal) == 0){
                choosingPattern(2, 2);
            }
        }
        // Phase 3
        else if (frame % (int)(600 * fpsCal) == 0) {
            choosingPattern(3, 3);
        }
    }

    private void choosingPattern(int phase, int option) {
        double x = getTransform().getPosX() + (getImage().getWidth() * getTransform().getSclX()) / 2;
        double y = getTransform().getPosY() + (getImage().getHeight() * getTransform().getSclY()) / 2 - 25;
        switch ((int) (Math.random() * option)) {
            case 0: {
                if (phase != 2) {
                    charge(this);
                } else {
                    breathFire(x, y, true);
                }
                break;
            }
            case 1: {
                sendDragon(x, y, false);
                break;
            }
            case 2: {
                if (phase == 1) {
                    breathFire(x, y, false);
                } else {
                    sendDragon(x, y, true);
                }
                break;
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawBounds(0, 0, 1, 1);
    }

    // Bullet barrage emerge from below
    private void sendFlamePillar() {
        double randX = (Math.random() * (Utility.getGameScreenX() - 100)) + 50;
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            int frame2 = 0;

            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame >= 4000) {
                    this.stop();
                }
                // Telegraph
                if (frame2 < (int)(284 * fpsCal) && frame2 % (int)(25 * fpsCal) == 0) {
                    BulletUtils.shoot(randX + Math.random() * 100 - 50, Utility.getScreenY() - Math.random() * 40 - 40, 1, 90);
                }
                // Fire
                if (frame2 > (int)(284 * fpsCal) && frame2 % (int)(5 * fpsCal) == 0) {
                    BulletUtils.shoot(randX + Math.random() * 100 - 50, Utility.getScreenY(), 3, 270);
                }
                frame2++;
            }
        }.start();
    }

    // Prepare to send dragons flying by shooting bullet upward.
    private void sendDragon(double x, double y, boolean vertical) {
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            int frame2 = 0;

            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame >= 6000) {
                    this.stop();
                }
                if (frame2 >= 0 && frame2 <= (int)(142 * fpsCal) && frame2 % (int)(15 * fpsCal) == 0) {
                    for (int i = 0; i < 5; i++) {
                        BulletUtils.shoot(x, y, 3, 270 + i * 20 - 40);
                    }
                }
                if (frame2 > (int)(143 * fpsCal) && frame2 % (int)(200 * fpsCal) == 0) {
                    if (!vertical) {
                        SpawnDragonHorizon();
                    } else {
                        SpawnDragonVertical();
                    }
                }
                frame2++;
            }
        }.start();
    }

    // Spawn dragon-shaped bullets flying across screen shooting bullet downward.
    private void SpawnDragonHorizon() {
        int randSide = (int) (Math.random() * 2);
        double randY = (Math.random() * 150) + 40;
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            int frame2 = 0;
            BaseBullet shooting;
            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame >= 5000 * Config.fpsCalibration) {
                    this.stop();
                }
                if (frame2 % (int)(30 * fpsCal) == 0 && frame2 < (int)(350 * fpsCal)) {
                    BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY, 1, (randSide * 180));
                    if (frame2 > 0 && frame2 <= (int)(200 * fpsCal)) {
                        BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY + (double) frame2 / 5, 1, (randSide * 180));
                        BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY - (double) frame2 / 5, 1, (randSide * 180));
                    }
                }
                if (frame2 == (int)(120 * fpsCal)) {
                    System.out.println("HA");
                    shooting = BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY, 1, (randSide * 180));
                }
                if (frame2 % (int)(15 * fpsCal) == 0 && (frame2 % (int)(70 * fpsCal)) - (int)(40 * fpsCal) < 0 && shooting != null) {
                    BulletUtils.shoot(shooting.getTransform().getPosX(), shooting.getTransform().getPosY(), 2, 90);
                }
                frame2++;
            }
        }.start();
    }

    // Spawn dragon-shaped bullets flying across screen downward.
    private void SpawnDragonVertical() {
        double randX = (Math.random() * (Utility.getGameScreenX() - 100)) + 50;
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            int frame2 = 0;

            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame >= 5000 * fpsCal) {
                    this.stop();
                }
                if (frame2 % (int)(20 * fpsCal) == 0 && frame2 < (int)(350 * fpsCal)) {
                    BulletUtils.shoot(randX, 0, 2, 90);
                    if (frame2 > 0 && frame2 <= (int)(200 * fpsCal)) {
                        BulletUtils.shoot(randX + (double) frame2 * fpsCal / 5, 0, 2, 90);
                        BulletUtils.shoot(randX - (double) frame2 * fpsCal / 5, 0, 2, 90);
                    }
                }
                frame2++;
            }
        }.start();
    }

    // Charge downward emitting bullet as followed
    private void charge(GameObject boss) {
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            int frame2 = 0;

            public void handle(long now) {
                if (frame2 == 0) {
                    transform.translateToPositionInMilliSecond(250, 50, 500);
                }
                if (frame2 == (int)(71 * fpsCal)) {
                    transform.translateToPositionInMilliSecond(250, Utility.getScreenY() + 30, 2000);
                }
                if (frame2 == (int)(426 * fpsCal)) {
                    transform.setPosY(-100);
                    transform.translateToPositionInMilliSecond(250, 100, 1500);
                }
                if (frame2 > (int)(71 * fpsCal) && frame2 < (int)(284 * fpsCal) && frame2 % (int)(40 * fpsCal) == 0) {
                    double randX = Math.random() * 10;
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 0; j < 15; j++) {
                            BulletUtils.shoot(j * 40 + i + randX + 25, boss.getTransform().getPosY() + i * 30 - (Math.abs(j - 7) * 12), 0, 90, 0.001, 1.5);
                        }
                    }
                }
                if (System.currentTimeMillis() - startFrame >= 3500) {
                    this.stop();
                }
                frame2++;
            }
        }.start();
    }

    private void breathFire(double x, double y, boolean targetPlayer) {

        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            int frame2 = 0;
            double angleToP = PlayerManager.getInstance().getPlayer() != null ? Transform.calculateAngleToTarget(getTransform(), PlayerManager.getInstance().getPlayer().getTransform()) : 90;

            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame >= (double) 3500) {
                    this.stop();
                }
                if (frame2 % (int)(5 * fpsCal) == 0) {
                    BulletUtils.shoot(x, y, 2.5, angleToP + Math.random() * 30 - 15);
                }
                if (frame2 % (int)(20 * fpsCal) == 0 && targetPlayer) {
                    angleToP += ((PlayerManager.getInstance().getPlayer() != null ? Transform.calculateAngleToTarget(getTransform(), PlayerManager.getInstance().getPlayer().getTransform()) : 90) - angleToP) / 4;
                }
                frame2++;
            }
        }.start();
    }
}
