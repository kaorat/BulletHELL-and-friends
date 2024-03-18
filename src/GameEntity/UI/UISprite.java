package GameEntity.UI;

import GameEntity.GameObject;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class UISprite extends GameObject {
    private final Image sprite;

    public UISprite(Image sprite,Transform transform, int z) {
        super(transform, z);
        this.sprite=sprite;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(sprite, transform.getPosX(), transform.getPosY(), sprite.getWidth() * transform.getSclX(), sprite.getHeight() * transform.getSclY());
    }

    @Override
    public void onUpdate() {

    }
}
