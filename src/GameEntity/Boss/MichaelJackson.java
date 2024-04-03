package GameEntity.Boss;

import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MichaelJackson extends BaseBoss{

    public MichaelJackson() {
        super();
        maxHp=1000;
        hp=maxHp;
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

    }

    @Override
    public void draw(GraphicsContext gc) {
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0, 0);
    }
}
