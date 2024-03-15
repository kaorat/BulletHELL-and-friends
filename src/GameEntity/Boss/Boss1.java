package GameEntity.Boss;

import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

public class Boss1 extends BaseBoss{
    public Boss1(int hp, int fireRate, int bulletSpeed, int bulletLength, Transform transform,int z) {
        super(hp, fireRate, bulletSpeed, bulletLength,transform,z);
    }

    @Override
    public void StartFiring() {

    }

    @Override
    public void firing() {

    }

    @Override
    public void draw(GraphicsContext gc) {

    }
}
