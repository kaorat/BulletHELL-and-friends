package GameEntity.Item;

import GameEntity.GameObject;
import Utils.Transform;

public abstract class BaseItem extends GameObject {
    protected boolean autoCollected;

    public BaseItem(double posX, double posY) {

        super(new Transform(posX, posY), 30 + Math.random());
        this.transform.setRot(90); //downwards direction
        this.transform.setSpeed(2.5);
        autoCollected = false;
        this.destroyed = false;

    }

    public void autoCollect() {
        autoCollected = true;
        transform.setSpeed(4);
    }

    public abstract void onPickup();


}
