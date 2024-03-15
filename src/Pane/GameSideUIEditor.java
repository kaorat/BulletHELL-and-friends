package Pane;

import GameEntity.GameObject;
import GameEntity.UI.UISprite;
import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;

public class GameSideUIEditor extends GraphicEditor{

    public GameSideUIEditor(GraphicsContext graphicsContext) {//Init
        super(graphicsContext);
        create(new UISprite(Asset.UI.background,new Transform(Utility.getGameScreenX()-80,0,1.33,1),40));
    }

    @Override
    public void clear() {
        for(GameObject gameObject : Monitored_Object){
            gameObject.setDestroyed(true);
        }
        Monitored_Object.clear();
    }
}
