package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import Manager.BulletManager;
import Manager.PlayerManager;
import Utils.Asset;
import Utils.BulletUtils;
import Utils.Transform;
import Utils.Utility;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MichaelJackson extends BaseBoss{
    private boolean ready;
    private boolean startRotate;
    private boolean startChaos;
    private boolean clearPhase;
    private int leftRight=1;
    private int angle1;
    private int angle2;

    public MichaelJackson() {
        super();
        maxHp=8001;
        hp=maxHp;
        ready=false;
        startRotate=false;
        angle1=90;
        angle2=90;
        getTransform().setScl(0.15,0.15);
        setImage(Asset.Game.michealJackson);
    }

    @Override
    public void action() {
        double x = getTransform().getPosX() + (getImage().getWidth() * getTransform().getSclX()) / 2;
        double y = getTransform().getPosY() + (getImage().getHeight() * getTransform().getSclY()) / 2;
        if(angle1>=720||angle1<=-720){
            angle1=0;
        }
        if(angle2>=720||angle2<=-720){
            angle2=0;
        }
        if(!ready) {
            if(frame>600){
                ready=true;
            }
            return;
        }
        if(!clearPhase&&hp<=8000){
            BulletManager.getInstance().clearBullets();
            clearPhase=true;
        }
        if(!startRotate && frame>800) {
            startRotate=true;
        }
        if(!startChaos && frame>1600) {
            startChaos=true;
        }
        //phase1
        if(frame%10==0){
            BulletUtils.Shoot(x, y,2,angle1);
            BaseBullet pattern1 = BulletUtils.Shoot(x, y,2,angle2);
            BulletUtils.ChangeTrajectoryNow(pattern1,2,angle2,-0.01,0);
            BulletUtils.ChangeTrajectoryOnFrame(pattern1,0,angle2,0.02,3,2000);
            if(startChaos){
                BulletUtils.Shoot(x, y,2,angle1+90);
                BaseBullet pattern2 = BulletUtils.Shoot(x, y,2,angle2-90);
                BulletUtils.ChangeTrajectoryNow(pattern2,2,angle2-90,-0.01,0);
                BulletUtils.ChangeTrajectoryOnFrame(pattern2,0,angle2-90,0.02,3,2000);
            }
            if(startRotate){
                angle1-=10;
                angle2+=10;
            }
        }
        //frame2
        if(hp<=16000){
            if(frame%10==0){
                BulletUtils.Shoot(x, y,3,Math.random()*90+225);
            }
            if(frame%40==0){
                BaseBullet rain = BulletUtils.Shoot(Math.random()*Utility.getGameScreenX()-5, 0,0,90);
                BulletUtils.ChangeTrajectoryNow(rain,0,90,0.01,3);
            }

        }
        if(hp<=8000){
            if(frame%568==200){
                ArrayList<BaseBullet> pattern3 = new ArrayList<>();

                for(double i=1;i<=5;i++){
                    for(double j=0;j<i*3;j++){
                        if(leftRight==1){
                            pattern3.add(BulletUtils.Shoot(x,y,1+3*(j/(i*3)),360-j-(i*3),-0.02,0));
                        }
                        else{
                            pattern3.add(BulletUtils.Shoot(x,y,1+3*(j/(i*3)),180+j+(i*3),-0.02,0));
                        }
                    }
                }
                for(BaseBullet bullet : pattern3){
                    BulletUtils.ChangeTrajectoryOnFrame(bullet,0,true,0.04,Math.random()*3+1,1500);
                }
                leftRight=leftRight==1?-1:1;
            }
        }
        if(frame%2130==700) {Dancing();}
    }
    private void Dancing(){
        //142 = 1 second
        double startFrame = System.currentTimeMillis();
        new AnimationTimer(){
            int frame2=0;
            public void handle(long now) {
                if(frame2==0){
                    transform.translateToPositionInMilliSecond(50,75,2500);
                }
                else if(frame2==355){
                    transform.translateToPositionInMilliSecond(150,120,1000);
                }
                else if(frame2==497){
                    transform.translateToPositionInMilliSecond(230,150,1000);
                }
                else if(frame2==639){
                    transform.translateToPositionInMilliSecond(450,70,3000);
                }
                else if(frame2==1065){
                    transform.translateToPositionInMilliSecond(350,80,1000);
                }
                else if(frame2==1207){
                    transform.translateToPositionInMilliSecond(400,134,2000);
                }
                else if(frame2==1491){
                    transform.translateToPositionInMilliSecond(420,90,1000);
                }
                else if(frame2==1633){
                    transform.translateToPositionInMilliSecond(250,100,2500);
                    this.stop();
                }
                frame2++;
            }
        }.start();
    }
    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0.3, 0.3
                , 0.3, 0.3);
    }
}
