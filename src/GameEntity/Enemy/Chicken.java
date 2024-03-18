package GameEntity.Enemy;

import Manager.EnemyManager;
import Utils.Asset;
import Utils.EnemyType;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Chicken extends BaseEnemy{


    public Chicken(Transform transform,int z) {
        super(EnemyType.CHICKEN,transform, z);
        Perks = EnemyManager.getInstance().getChickenPerks();
    }

    @Override
    public void startFiring() {

    }

    @Override
    public void firing() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        Image chickenImage = Asset.UI.skull;
        gc.drawImage(chickenImage,this.transform.getPosX(),this.transform.getPosY(), 60,60);
    }
}


