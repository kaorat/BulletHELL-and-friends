package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import Manager.BulletManager;
import Manager.PlayerManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class KaoBoss extends BaseBoss {
    private boolean ready;
    private int leftRight = 1; // Shuffle pattern side
    private boolean clearPhase; // Clear bullet as the next phase begins

    public KaoBoss() {
        super();
        maxHp = 10000;
        hp = maxHp;
        ready = false;
        getTransform().setScl(0.25, 0.25);
        setImage(Asset.Game.player);
        clearPhase = false;
    }

    @Override
    public void action() {
        int angleToP = (int) ((PlayerManager.getInstance().getPlayer() != null) ? Transform.calculateAngleToTarget(getTransform(), PlayerManager.getInstance().getPlayer().getTransform()) : 90);
        if (!ready) {
            if (frame > 200) {
                ready = true;
            }
            return;
        }
        if (!clearPhase && hp <= 5000) {
            BulletManager.getInstance().clearBullets();
            clearPhase = true;
        }
        //phase 1
        if (hp > 5000) {
            if (frame % 1000 == 0) {
                sendSlowTwister(angleToP, 1);
            }
            if (frame % 1000 == 500) {
                sendFastTwister(angleToP);
                leftRight = leftRight == 1 ? -1 : 1;
            }
        }
        // Phase 2
        else {
            if (frame % 500 == 0) {
                sendSlowTwister(angleToP,2);
            }
            if (frame % 800 == 0) {
                sendFastTwister(angleToP);
                leftRight = leftRight == 1 ? -1 : 1;
            }
        }
    }
    //Create slow circle pattern
    private void sendSlowTwister(int angleToP, int phase) {
        List<List<BaseBullet>> bulletsBox = new ArrayList<>();
        int angle = phase == 1 ? angleToP : (int) (Math.random() * 90);
        for (int i = 0; i < Math.floor(Math.random() * 10) + 30; i++) {
            List<BaseBullet> bullets = BossUtils.circular(this, angle + (10 * i), 1.5 + (i * 0.08), 6, -0.05, 0);
            bulletsBox.add(bullets);
        }
        for (int i = 0; i < bulletsBox.size(); i++) {
            for (int j = 0; j < bulletsBox.get(i).size(); j++) {
                BulletUtils.changeTrajectoryOnFrame(bulletsBox.get(i).get(j), 0 + (0.005 * i), bulletsBox.get(i).get(j).getTransform().getRot(), 0.01 + (i * 0.005), 1, 6000 - (i * 120));
                BulletUtils.changeRotAndDestroyWithDuration(bulletsBox.get(i).get(j), 0.1, 7000 - (i * 120));
            }
        }
    }
    //Create fast circle pattern
    private void sendFastTwister(int angleToP) {
        List<List<BaseBullet>> bulletsBox = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            List<BaseBullet> bullets = BossUtils.circular(this, leftRight * (angleToP - 20 + (i * 10)), 0.3 + (i * 0.01), 10, 0.005, 3);
            bulletsBox.add(bullets);
        }
        for (int i = 0; i < bulletsBox.size(); i++) {
            for (int j = 0; j < bulletsBox.get(i).size(); j++) {
                BulletUtils.changeRotAndDestroyWithDuration(bulletsBox.get(i).get(j), (leftRight) * 0.7, 4000 - (i * 120));
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawBounds(0, 0, 1, 1);
        gc.setStroke(Color.YELLOW);
        gc.strokeRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
    }
}

