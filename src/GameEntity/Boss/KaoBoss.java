package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import Utils.Asset;
import Utils.BulletUtils;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class KaoBoss extends BaseBoss{

    private boolean ready;
    private boolean startRotate;
    private boolean startChaos;
    private List<Boolean> phase;
    private List<EnemyBullet> bulletsBox;
    private List<Boolean> circleRank;
    private List<Integer> circleAngle;
    private int angle1;
    private int angle2;

    public KaoBoss() {
        super();
        maxHp=1000;
        hp=maxHp;
        ready=false;
        startRotate=false;
        bulletsBox = new ArrayList<EnemyBullet>();
        circleRank = Arrays.asList(false, false, false, false, false);
        phase = Arrays.asList(false, false, false, false, false);
        circleAngle = Arrays.asList(90, 92, 94, 96, 98);
        getTransform().setScl(0.25,0.25);
        setImage(Asset.Game.player);

    }


    @Override
    public void action() {
    double x = Transform.centerPos(this).getX();
    double y = Transform.centerPos(this).getY();

    for(int i = 0; i < circleAngle.size(); i++){
        if(circleAngle.get(i)>=450||circleAngle.get(i)<=-450){
            circleAngle.set(i,90);
            circleRank.set(i, true);
        }
    }

//        if(angle2>=720||angle2<=-720){
//            angle2=0;
//        }

        if(!ready) {
            if(frame>600){
                ready=true;
            }
            return;
        }

        if(frame % 600 == 0) {
            circleRank = Arrays.asList(false, false, false, false, false);
            phase = Arrays.asList(false, false, false, false, false);
            circleAngle = Arrays.asList(90, 92, 94, 96, 98);
        }

        if(frame % 4 == 0) {
            for(int i = 0; i < circleRank.size(); i++) {
                if(i == 0 || circleRank.get(i - 1)) {
                    if(!circleRank.get(i)) {
                        EnemyBullet pattern1 = (EnemyBullet) BulletUtils.Shoot(x, y, 4, circleAngle.get(i));
                        bulletsBox.add(pattern1);
                        BulletUtils.ChangeTrajectoryNow(pattern1, 1.5 + (i * 0.1), circleAngle.get(i), -0.01, 0);
                        circleAngle.set(i, circleAngle.get(i) + 20);
                    }
                }
            }
        }

        if(circleRank.getLast() && !phase.get(0)) {
            phase.set(0, true);
            for(EnemyBullet bullet : bulletsBox) {
                BulletUtils.ChangeTrajectoryOnFrame(bullet, 0, bullet.getTransform().getRot(), 0.02, 2, 2000);
            }
        }



        if(frame%3000==0){ // move randomly every 1 sec
            transform.translateToPositionInMilliSecond((Math.random()*(Utility.getGameScreenX()-150))+50,(Math.random()*60)+50,4000);
        }
        //rotate
    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0, 0
                , 1, 1);
        gc.setStroke(Color.YELLOW);
        gc.strokeRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
    }
}
