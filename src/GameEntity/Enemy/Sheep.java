package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;

public class Sheep extends BaseEnemy{

    private long lastPatternTime = 0;

    public Sheep(Transform transform,double z) {
        super(transform,z);
        setImage(Asset.Game.WhiteSheepIdleLeft);
        Perks = EnemyManager.getInstance().getSheepPerks();
        ApplyStat(EnemyType.SHEEP);

    }

    @Override
    public void firing() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastPatternTime > 1000){
            EnemyUtils.SheepShootPattern(this,bulletSpeed,bulletQuantity,bulletLength);
            lastPatternTime = currentTime;
        }
    }

    @Override
    public void action() {

        double renderTime = 10d ;
        if(state == States.DOWN) {
            downtime -= renderTime;
            setImage(Asset.Game.WhiteSheepAimLeft);
            transform.setRot(90);
            transform.translate(0.7);
            if(downtime <= 0) state = States.SHOOT;
        }
        if (state == States.SHOOT) {
            shootTime -= renderTime;
            setImage(Asset.Game.WhiteSheepShootLeft);
            firing();
            if(shootTime <= 0) state = States.UP;
        }
        if(state == States.UP) {
            uptime -= renderTime;
            setImage(Asset.Game.WhiteSheepIdleLeft);
            transform.setRot(270);
            transform.translate(0.7);

            if(uptime <= 0) destroyed = true;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        //gc.drawImage(getImage(),this.transform.getPosX(),this.transform.getPosY(), 60,60);
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0,0);

    }
}
