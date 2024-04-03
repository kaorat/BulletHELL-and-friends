package GameEntity.Boss;

import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MichaelJackson extends BaseBoss{
    private boolean ready;

    public MichaelJackson() {
        super();
        maxHp=1000;
        hp=maxHp;
        ready=false;
        getTransform().setScl(0.15,0.15);
        setImage(Asset.Game.michealJackson);
    }

    @Override
    public void StartFiring() {

    }

    @Override
    public void firing() {

    }

    @Override
    public void action() {
        if(!ready) {
            if(frame>600){
                ready=true;
            }
            return;
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
