package GameEntity.Item;

import Manager.PlayerManager;
import Manager.StatManager;
import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;

public class Soul extends BaseItem {

    public Soul(double posX, double posY) {
        super(posX, posY);
        this.transform.setSclX(0.08);
        this.transform.setSclY(0.08);
        this.transform.setSpeed(2);
        setImage(Asset.UI.soulUI);
    }
    @Override
    public void draw(GraphicsContext gc) {
        Utility.drawImage(gc, getImage(), transform);
        drawBounds(0, 0);
    }

    @Override
    public void onUpdate() {
        transform.translate();
        Utility.isOutOfBounds(this);
        if (Transform.checkCollide(this.getBounds(), PlayerManager.getInstance().getPlayer().getBounds())) {
            onPickup();
        }
    }

    @Override
    public void onPickup() {
        StatManager.getInstance().addSoul();
        this.destroyed = true;
    }
}
