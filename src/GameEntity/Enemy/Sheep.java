package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import input.MouseUtil;
import javafx.scene.canvas.GraphicsContext;

public class Sheep extends BaseEnemy{
    private int clicktime;
    private long lastPatternTime = 0;

    public Sheep(Transform transform,double z) {
        super(transform,z);
        setImage(Asset.UI.sheepiconUI);
        Perks = EnemyManager.getInstance().getSheepPerks();
        ApplyStat(EnemyType.SHEEP);
        clicktime=0;
    }

    @Override
    public void firing() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastPatternTime > 1000*fireRate){
            EnemyUtils.SheepShootPattern(this,bulletSpeed,bulletQuantity,bulletLength);
            lastPatternTime = currentTime;
        }
    }

    @Override
    public void action() {

        double renderTime = 10d ;
        if(state == States.DOWN) {
            downtime -= renderTime;
            transform.setRot(90);
            transform.translate(0.7);
            if(downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            shootTime -= renderTime;
            firing();
            if(shootTime <= 0) state = States.UP;
        }
        if(state == States.UP) {
            uptime -= renderTime;
            transform.setRot(270);
            transform.translate(0.7);

            if(uptime <= 0) destroyed = true;
        }
        boolean click= Utility.checkHover(getTransform(),getImage()) && MouseUtil.isActivated();
        if(click){
            clicktime++;
        }
        if(clicktime>=10){
            hp=0;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        //gc.drawImage(getImage(),this.transform.getPosX(),this.transform.getPosY(), 60,60);
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0,0);

    }
}
