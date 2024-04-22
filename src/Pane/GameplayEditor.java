package Pane;

import GameEntity.UI.UISprite;
import Utils.Asset;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

//Bullet hell game here (game box)
public class GameplayEditor extends GraphicEditor {
    public GameplayEditor(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background

        create(new UISprite(Asset.UI.backgroundGameplay, new Transform(0, 0, 0.8, 0.7), -100));
    }

    @Override
    public void onUpdate() {

    }
}
