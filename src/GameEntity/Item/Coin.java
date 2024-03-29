package GameEntity.Item;

import Utils.Asset;
import javafx.scene.canvas.GraphicsContext;

public class Coin extends BaseItem{ // this is 'parts drop', I just want to change the name.


    public Coin(double posX, double posY) {
        super(posX, posY);
        setImage(Asset.UI.partUI);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 20, 20);

    }

    @Override
    public void onUpdate() {
        transform.translate(2);
        isOutOfBounds();
    }

    @Override
    public void onPickup() {
        this.destroyed = true;
    }
}
