package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.GameObject;
import Manager.PlayerManager;
import Utils.Asset;
import Utils.BulletUtils;
import Utils.Transform;
import Utils.Utility;
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
            if (frame > 600) {
                ready = true;
            }
            return;
        }
        // Raise flame pillar now and then
        if (frame % 1000 == 0) {
            sendFlamePillar();
        }
        if (frame % 1000 == 500 && hp < 750000) {
            sendFlamePillar();
        }

        // Phase 1
        if (hp >= 1000000) {
            if(frame % 800 == 0){
                choosingPattern(1, 3);
            }
        }
        // Phase 2
        else if (hp >= 500000) {
            if(frame % 700 == 0){
                choosingPattern(2, 2);
            }
        }
        // Phase 3
        else if (frame % 600 == 0) {
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
                if (frame2 < 284 && frame2 % 25 == 0) {
                    BulletUtils.shoot(randX + Math.random() * 100 - 50, Utility.getScreenY() - Math.random() * 40 - 40, 1, 90);
                }
                // Fire
                if (frame2 > 284 && frame2 % 5 == 0) {
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
                if (frame2 >= 0 && frame2 <= 142 && frame2 % 15 == 0) {
                    for (int i = 0; i < 5; i++) {
                        BulletUtils.shoot(x, y, 3, 270 + i * 20 - 40);
                    }
                }
                if (frame2 > 143 && frame2 % 200 == 0) {
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
                if (System.currentTimeMillis() - startFrame >= 5000) {
                    this.stop();
                }
                if (frame2 % 30 == 0 && frame2 < 350) {
                    BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY, 1, (randSide * 180));
                    if (frame2 > 0 && frame2 <= 200) {
                        BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY + (double) frame2 / 5, 1, (randSide * 180));
                        BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY - (double) frame2 / 5, 1, (randSide * 180));
                    }
                    if (frame2 == 120) {
                        shooting = BulletUtils.shoot(randSide * Utility.getGameScreenX(), randY, 1, (randSide * 180));
                    }
                }
                if (frame2 % 15 == 0 && (frame2 % 70) - 40 < 0 && shooting != null) {
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
                if (System.currentTimeMillis() - startFrame >= 5000) {
                    this.stop();
                }
                if (frame2 % 20 == 0 && frame2 < 350) {
                    BulletUtils.shoot(randX, 0, 2, 90);
                    if (frame2 > 0 && frame2 <= 200) {
                        BulletUtils.shoot(randX + (double) frame2 / 5, 0, 2, 90);
                        BulletUtils.shoot(randX - (double) frame2 / 5, 0, 2, 90);
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
                if (frame2 == 71) {
                    transform.translateToPositionInMilliSecond(250, Utility.getScreenY() + 30, 2000);
                }
                if (frame2 == 426) {
                    transform.setPosY(-100);
                    transform.translateToPositionInMilliSecond(250, 100, 1500);
                }
                if (frame2 > 71 && frame2 < 284 && frame2 % 40 == 0) {
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
                if (frame2 % 5 == 0) {
                    BulletUtils.shoot(x, y, 2.5, angleToP + Math.random() * 30 - 15);
                }
                if (frame2 % 20 == 0 && targetPlayer) {
                    angleToP += ((PlayerManager.getInstance().getPlayer() != null ? Transform.calculateAngleToTarget(getTransform(), PlayerManager.getInstance().getPlayer().getTransform()) : 90) - angleToP) / 4;
                }
                frame2++;
            }
        }.start();
    }
}
