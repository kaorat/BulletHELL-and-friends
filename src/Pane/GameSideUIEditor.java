package Pane;

import GameEntity.GameObject;
import GameEntity.UI.UISprite;
import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;

public class GameSideUIEditor extends GraphicEditor{
    private double x;
    public GameSideUIEditor(GraphicsContext graphicsContext) {//Init
        super(graphicsContext);
        x=Utility.getGameScreenX();
        //Background
        create(new UISprite(Asset.UI.background,new Transform(Utility.getGameScreenX(),0,1.85,1),50));
        //Currency background
        for(int i=0;i<2;i++){
            create(new UISprite(Asset.UI.currencyBG,new Transform(x+(40+(i*132)),40,0.25,0.12),51));
        }
        create(new UISprite(Asset.UI.currencyBG,new Transform(x+304,40,0.2,0.12),51));
        //Currency
        create(new UISprite(Asset.UI.partUI,new Transform(x+43,42,0.055,0.055),52));
        create(new UISprite(Asset.UI.soulUI,new Transform(x+175,42,0.055,0.055),52));
        create(new UISprite(Asset.UI.honeyUI,new Transform(x+304,42,0.055,0.055),52));
    }

    @Override
    public void clear() {
        for(GameObject gameObject : Monitored_Object){
            gameObject.setDestroyed(true);
        }
        Monitored_Object.clear();
    }
}
