package GameEntity.Item;

import Manager.PlayerManager;
import Manager.StatManager;
import Utils.Asset;
import Utils.Config;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;

public class Coin extends BaseItem{ // this is 'parts drop', I just want to change the name.
    private long amount;
    public Coin(double posX, double posY,double scl,long amount) {
        super(posX, posY);
        this.transform.setSclX(scl);
        this.transform.setSclY(scl);
        this.amount = amount;
        setImage(Asset.UI.partUI);
    }

    @Override
    public void draw(GraphicsContext gc) {
        //gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 20, 20);
        Utility.DrawImage(gc,getImage(),transform);
        drawBounds(0,0);
        gc.setStroke(javafx.scene.paint.Color.GREENYELLOW);
        gc.strokeRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());

    }

    @Override
    public void onUpdate() {
        transform.translate(3);
        Utility.isOutOfBounds(this);

        if(Transform.checkCollide(this.getBounds(), PlayerManager.getInstance().getPlayer().getBounds())){
            onPickup();
        }

    }

    @Override
    public void onPickup() {
        StatManager.getInstance().addCoin(amount);
//        System.out.println(amount);
        System.out.println(StatManager.getInstance().getCoin());
        this.destroyed = true;
    }
}
