package GameEntity.Boss;

import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

public class MichaelJackson extends BaseBoss{
    public MichaelJackson(int hp, int fireRate, int bulletSpeed, int bulletLength, Transform transform, double z) {
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
