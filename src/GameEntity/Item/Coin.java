package GameEntity.Item;

import Manager.StatManager;
import Utils.Asset;
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
        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 20, 20);

    }

    @Override
    public void onUpdate() {
        transform.translate(2);
        Utility.isOutOfBounds(this);
    }

    @Override
    public void onPickup() {
        StatManager.getInstance().addCoin(amount);
        this.destroyed = true;
    }
}
