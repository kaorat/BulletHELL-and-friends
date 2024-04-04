package GameEntity.Boss;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.EnemyBullet;
import Manager.BulletManager;
import Utils.Asset;
import Utils.BulletUtils;
import Utils.Transform;
import Utils.Utility;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MichaelJackson extends BaseBoss{
    private boolean ready;
    private boolean startRotate;
    private boolean startChaos;
    private int angle1;
    private int angle2;
    private double x;
    private double y;
    public MichaelJackson() {
        super();
        maxHp=1000;
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
        x=getTransform().getPosX()+(getImage().getWidth()*getTransform().getSclX())/2;
        y=getTransform().getPosY()+(getImage().getHeight()*getTransform().getSclY())/2;
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
        if(!startRotate && frame>800) {
            startRotate=true;
        }
        if(!startChaos && frame>1600) {
            startChaos=true;
        }
        if(frame%20==0){
            BulletUtils.Shoot(x,y,2,angle1);
            BaseBullet pattern1 = BulletUtils.Shoot(x,y,2,angle2);
            BulletUtils.ChangeTrajectoryNow(pattern1,2,angle2,-0.01,0);
            BulletUtils.ChangeTrajectoryOnFrame(pattern1,0,angle2,0.02,3,2000);
            if(startChaos){
                BulletUtils.Shoot(x,y,2,angle1+90);
                BaseBullet pattern2 = BulletUtils.Shoot(x,y,2,angle2-90);
                BulletUtils.ChangeTrajectoryNow(pattern2,2,angle2-90,-0.01,0);
                BulletUtils.ChangeTrajectoryOnFrame(pattern2,0,angle2-90,0.02,3,2000);
            }
            if(startRotate){
                angle1-=10;
                angle2+=10;
            }
        }
        if(frame%1000==0){
            transform.translateToPositionInMilliSecond((Math.random()*(Utility.getGameScreenX()-150))+50,(Math.random()*60)+50,4000);
        }
    }
    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0, 0);
    }
}
