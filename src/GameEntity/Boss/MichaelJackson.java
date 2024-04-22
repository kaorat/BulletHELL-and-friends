package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import Manager.BulletManager;
import Utils.Asset;
import Utils.BulletUtils;
import Utils.Utility;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class MichaelJackson extends BaseBoss {
    private boolean ready;
    private boolean startRotate;
    private boolean startChaos;
    private boolean clearPhase;
    private int leftRight = 1;
    private int angle1;
    private int angle2;

    public MichaelJackson() {
        super();
        maxHp = 240000;
        hp = maxHp;
        ready = false;
        startRotate = false;
        angle1 = 90;
        angle2 = 90;
        getTransform().setScl(0.15, 0.15);
        setImage(Asset.Game.michealJackson);
    }

    @Override
    public void action() {
        double x = getTransform().getPosX() + (getImage().getWidth() * getTransform().getSclX()) / 2;
        double y = getTransform().getPosY() + (getImage().getHeight() * getTransform().getSclY()) / 2 - 25;
        if (!ready) {
            if (frame > 600) {
                ready = true;
            }
            return;
        }
        preAction();
        // phase1
        if (frame % 10 == 0) {
            sendDisco(x,y);
        }// phase2
        if (hp <= 160000) {
            if (frame % 10 == 0) {
                BulletUtils.shoot(x, y, 3, Math.random() * 90 + 225);
            }
            if (frame % 40 == 0) {
                BaseBullet rain = BulletUtils.shoot(Math.random() * Utility.getGameScreenX() - 5, 0, 0, 90);
                BulletUtils.changeTrajectoryNow(rain, 0, 90, 0.01, 3);
            }
        }//phase3
        if (hp <= 80000) {
            if (frame % 568 == 200) {
                sendWing(x,y);
                leftRight = leftRight == 1 ? -1 : 1;
            }
        }
        if (frame % 2130 == 700) {
            dancing();
        }
    }
    //
    private void preAction(){
        if (angle1 >= 720 || angle1 <= -720) {
            angle1 = 0;
        }
        if (angle2 >= 720 || angle2 <= -720) {
            angle2 = 0;
        }
        if (!clearPhase && hp <= 80000) {
            BulletManager.getInstance().clearBullets();
            clearPhase = true;
        }
        if (!startRotate && frame > 800) {
            startRotate = true;
        }
        if (!startChaos && frame > 1600) {
            startChaos = true;
        }
    }
    //continuously send circle pattern
    private void sendDisco(double x, double y){
        BulletUtils.shoot(x, y, 2, angle1);
        BaseBullet pattern1 = BulletUtils.shoot(x, y, 2, angle2);
        BulletUtils.changeTrajectoryNow(pattern1, 2, angle2, -0.01, 0);
        BulletUtils.changeTrajectoryOnFrame(pattern1, 0, angle2, 0.02, 3, 2000);
        if (startChaos) {
            BulletUtils.shoot(x, y, 2, angle1 + 90);
            BaseBullet pattern2 = BulletUtils.shoot(x, y, 2, angle2 - 90);
            BulletUtils.changeTrajectoryNow(pattern2, 2, angle2 - 90, -0.01, 0);
            BulletUtils.changeTrajectoryOnFrame(pattern2, 0, angle2 - 90, 0.02, 3, 2000);
        }
        if (startRotate) {
            angle1 -= 10;
            angle2 += 10;
        }
    }
    //send wing bullet
    private void sendWing(double x, double y){
        ArrayList<BaseBullet> pattern3 = new ArrayList<>();
        for (double i = 1; i <= 5; i++) {
            for (double j = 0; j < i * 3; j++) {
                if (leftRight == 1) {
                    pattern3.add(BulletUtils.shoot(x, y, 1 + 3 * (j / (i * 3)), 360 - j - (i * 3), -0.02, 0));
                } else {
                    pattern3.add(BulletUtils.shoot(x, y, 1 + 3 * (j / (i * 3)), 180 + j + (i * 3), -0.02, 0));
                }
            }
        }
        for (BaseBullet bullet : pattern3) {
            BulletUtils.changeTrajectoryOnFrame(bullet, 0, (leftRight) * (30) + Math.random() * 60 + 60, 0.04, Math.random() * 3 + 1, 1500);
        }
    }
    //movement
    private void dancing() {
        new AnimationTimer() {
            int frame2 = 0;
            public void handle(long now) {
                if (frame2 == 0) {
                    transform.translateToPositionInMilliSecond(50, 75, 2500);
                } else if (frame2 == 355) {
                    transform.translateToPositionInMilliSecond(150, 120, 1000);
                } else if (frame2 == 497) {
                    transform.translateToPositionInMilliSecond(230, 150, 1000);
                } else if (frame2 == 639) {
                    transform.translateToPositionInMilliSecond(450, 70, 3000);
                } else if (frame2 == 1065) {
                    transform.translateToPositionInMilliSecond(350, 80, 1000);
                } else if (frame2 == 1207) {
                    transform.translateToPositionInMilliSecond(400, 134, 2000);
                } else if (frame2 == 1491) {
                    transform.translateToPositionInMilliSecond(420, 90, 1000);
                } else if (frame2 == 1633) {
                    transform.translateToPositionInMilliSecond(250, 100, 2500);
                    this.stop();
                }
                frame2++;
            }
        }.start();
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawBounds(0.3, 0.3, 0.3, 0.3);
    }
}
