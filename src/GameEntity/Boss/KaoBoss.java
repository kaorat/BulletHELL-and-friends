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

    }


    @Override
    public void action() {
        double x = Transform.centerPos(this).getX();
        double y = Transform.centerPos(this).getY();

//    for(int i = 0; i < circleAngle.size(); i++){
//        if(circleAngle.get(i)>=450||circleAngle.get(i)<=-450){
//            circleAngle.set(i,90);
//            circleRank.set(i, true);
//        }
//    }

//        if(angle2>=720||angle2<=-720){
//            angle2=0;
//        }

        if (!ready) {
            if (frame > 200) {
                ready = true;
            }
            return;
        }
        //TODO: define phases;
        if (frame % 1500 == 0) {

            for (int i = 0; i < Math.floor(Math.random() * 10) + 30; i++) {

                List<BaseBullet> bullets = BossUtils.circular(this, 90 + (20 * i), 1.5 + (i * 0.08), 10, -0.05, 0);

                bulletsBox.add(bullets);
            }
            for (int i = 0; i < bulletsBox.size(); i++) {
                for (int j = 0; j < bulletsBox.get(i).size(); j++) {
                    BulletUtils.ChangeTrajectoryOnFrame(bulletsBox.get(i).get(j), 0 + (0.005 * i), bulletsBox.get(i).get(j).getTransform().getRot(), 0.01 + (i * 0.005), 1, 6000 - (i * 120));
                    BulletUtils.ChangeRotAndDestroyWithDuration(bulletsBox.get(i).get(j), 0.1, 0.002, 4,7000 - (i * 120), 10000);
                }
            }

//            for (int i = 0; i < bulletsBox.size(); i++) {
//                for (int j = bulletsBox.get(i).size() - 1; j >= 0; j--) {
//                    BulletUtils.ChangeRotAndDestroyWithDuration(bulletsBox.get(i).get(j), 0.1, 0.01, 2,3000, 10000);
//                }
//            }
            bulletsBox.clear();
        }

//        if(frame % 2 == 0) {
//            for(int i = 0; i < circleRank.size(); i++) {
//                if(i == 0 || circleRank.get(i - 1)) {
//                    if(!circleRank.get(i)) {
//                        EnemyBullet pattern1 = (EnemyBullet) BulletUtils.Shoot(x, y, 10, circleAngle.get(i));
//                        bulletsBox.add(pattern1);
//                        BulletUtils.ChangeTrajectoryNow(pattern1, 1.5 + (i * 0.1), circleAngle.get(i), -0.01, 0);
//                        circleAngle.set(i, circleAngle.get(i) + 20);
//                    }
//                }
//            }
//        }
//            if(frame % 1001 == 0){
//
//            }


//        if(frame%600==0){ // move randomly every 1 sec
////            t.interrupt(); //forbidden moves;
//            transform.translateToPositionInMilliSecond((Math.random()*(Utility.getGameScreenX()-150))+50,(Math.random()*60)+50,4000);
//        }
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
