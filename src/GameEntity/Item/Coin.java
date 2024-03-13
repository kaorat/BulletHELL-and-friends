package GameEntity.Item;

import javafx.scene.canvas.GraphicsContext;

public class Coin extends BaseItem{ // this is 'parts drop', I just want to change the name.


    public Coin(double posX, double posY) {
        super(posX, posY);
    }

    @Override
    public void draw(GraphicsContext gc) {

    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onPickup() {

    }
}
