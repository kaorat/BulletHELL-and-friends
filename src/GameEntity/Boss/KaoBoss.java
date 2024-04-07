package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class KaoBoss extends BaseBoss {

    private boolean ready;
    private boolean startRotate;
    private boolean startChaos;
    private List<Boolean> phase;
    private List<List<BaseBullet>> bulletsBox;
    private List<Boolean> circleRank;
    private List<Integer> circleAngle;
    private int angle1;
    private int angle2;

    public KaoBoss() {
        super();
        maxHp = 1000;
        hp = maxHp;
        ready = false;
        startRotate = false;
        bulletsBox = new ArrayList<>();
        circleRank = Arrays.asList(false, false, false, false, false);
        phase = Arrays.asList(false, false, false, false, false);
        circleAngle = Arrays.asList(90, 92, 94, 96, 98);
        getTransform().setScl(0.25, 0.25);
        setImage(Asset.Game.player);

//        frame = 6001;
    }


    @Override
    public void action() {
        double x = Transform.centerPos(this).getX();
        double y = Transform.centerPos(this).getY();

        if (!ready) {
            if (frame > 200) {
                ready = true;
            }
            return;
        }
        //TODO: phase 1 (i don't like it);
        if(frame > 200  && frame <= 6000){
            if (frame % 1500 == 0) {

                for (int i = 0; i < Math.floor(Math.random() * 10) + 30; i++) {

                    List<BaseBullet> bullets = BossUtils.circular(this, 90 + (10 * i), 1.5 + (i * 0.08), 6, -0.05, 0);

                    bulletsBox.add(bullets);
                }
                for (int i = 0; i < bulletsBox.size(); i++) {
                    for (int j = 0; j < bulletsBox.get(i).size(); j++) {
                        BulletUtils.ChangeTrajectoryOnFrame(bulletsBox.get(i).get(j), 0 + (0.005 * i), bulletsBox.get(i).get(j).getTransform().getRot(), 0.01 + (i * 0.005), 1, 6000 - (i * 120));
                        BulletUtils.ChangeRotAndDestroyWithDuration(bulletsBox.get(i).get(j), 0.1, 0.002, 4,7000 - (i * 120), 10000);
                    }
                }

                bulletsBox.clear();
            }
//
//            if(frame%1501==0){ // move randomly every 1 sec
////            t.interrupt(); //forbidden moves;
//                transform.translateToPositionInMilliSecond((Math.random()*(Utility.getGameScreenX()-150))+50,0,4000);
//            }
        }
        //TODO: Phase 2
        if(frame > 6000 && frame < 30000){
            if (frame % 1000 == 0) {
                for(int i = 0; i < 30; i++){
                    List<BaseBullet> bullets = BossUtils.circular(this, 90 + (i*10) , 0.3 + (i * 0.01), 10, 0.005, 3);
                    bulletsBox.add(bullets);
                }
                for (int i = 0; i < bulletsBox.size(); i++) {
                    for (int j = 0; j < bulletsBox.get(i).size(); j++) {
//                        BulletUtils.ChangeTrajectoryOnFrame(bulletsBox.get(i).get(j), 0 + (0.005 * i), bulletsBox.get(i).get(j).getTransform().getRot(), 0.01 + (i * 0.005), 1, 3000 - (i * 100));
                        BulletUtils.ChangeRotAndDestroyWithDuration(bulletsBox.get(i).get(j), 0.7, 0.002, 4,4000 - (i * 120), 10000);
                    }
                }


                bulletsBox.clear();
            }

//            if(frame%1501==0){ // move randomly every 1 sec
////            t.interrupt(); //forbidden moves;
//                transform.translateToPositionInMilliSecond((Math.random()*(Utility.getGameScreenX()-150))+50,50,4000);
//            }
        }
        //rotate
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc, getImage(), transform);
        drawBounds(0, 0
                , 1, 1);
        gc.setStroke(Color.YELLOW);
        gc.strokeRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
    }
}
