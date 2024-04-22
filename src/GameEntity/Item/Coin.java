package GameEntity.Item;

import Manager.PlayerManager;
import Manager.StatManager;
import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class Coin extends BaseItem { // this is 'parts drop', I just want to change the name.
    private final long amount;
    private final boolean canObtain;

    public Coin(double posX, double posY, double scl, long amount) {
        super(posX, posY);
        this.transform.setSclX(scl);
        this.transform.setSclY(scl);
        this.amount = amount;
        setImage(Asset.UI.partUI);
        canObtain = true;
    }

    public Coin(double posX, double posY, double scl, long amount, boolean canObtain) {
        super(posX, posY);
        this.transform.setSclX(scl);
        this.transform.setSclY(scl);
        this.amount = amount;
        setImage(Asset.UI.partUI);
        this.canObtain = canObtain;
        if (!canObtain) {
            grazePoint();
        }
    }

    private void grazePoint() {
        transform.setRot(270);
        transform.setSpeed(1.5);
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame > 300) {
                    onPickup();
                    this.stop();
                }
            }
        }.start();
    }

    @Override
    public void draw(GraphicsContext gc) {
        //gc.drawImage(getImage(), this.transform.getPosX(), this.transform.getPosY(), 20, 20);
        Utility.DrawImage(gc, getImage(), transform);
        drawBounds(0, 0);
    }

    @Override
    public void onUpdate() {
        transform.translate();
        Utility.isOutOfBounds(this);
        if(!canObtain) { return; }
        if(PlayerManager.getInstance().getPlayer()==null) {
            autoCollected = false;
            return;
        }
        if(autoCollected) {
            transform.setRot(Transform.calculateAngleToTarget(getTransform(), PlayerManager.getInstance().getPlayer().getTransform()));
        }
        if (Transform.checkCollide(this.getBounds(), PlayerManager.getInstance().getPlayer().getBounds())) {
            onPickup();
        }

    }

    @Override
    public void onPickup() {
        StatManager.getInstance().addCoin(amount);
//        System.out.println(amount);
//        System.out.println(StatManager.getInstance().getCoin());
        this.destroyed = true;
    }
}
