package Pane;

import GameEntity.GameObject;
import GameEntity.UI.UISprite;
import Util.Asset;
import Util.Transform;
import javafx.scene.canvas.GraphicsContext;

public class GameSideUIEditor extends GraphicEditor{

    public GameSideUIEditor(GraphicsContext graphicsContext) {//Init
        super(graphicsContext);
        create(new UISprite(Asset.UI.background,new Transform(800,0,0.5,0.5),40));
    }

    @Override
    public void clear() {
        for(GameObject gameObject : Monitored_Object){
            gameObject.setDestroyed(true);
        }
        Monitored_Object.clear();
    }
}
