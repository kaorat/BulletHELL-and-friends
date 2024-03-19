package Pane;

import GameEntity.GameObject;
import GameEntity.UI.UISprite;
import Manager.StatManager;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.TextAlignment;

public class GameSideUIEditor extends GraphicEditor{
    private double x;
    private UISprite part;
    private UISprite soul;
    private UISprite honey;
    public GameSideUIEditor(GraphicsContext graphicsContext) {//Init
        super(graphicsContext);
        //set field
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

        //Will change text
        part=(UISprite) create(new UISprite(new Text("0",Utility.getGameFont(20), TextAlignment.RIGHT),new Transform(x+155,65),52));
        soul=(UISprite) create(new UISprite(new Text("0",Utility.getGameFont(20), TextAlignment.RIGHT),new Transform(x+285,65),52));
        honey=(UISprite) create(new UISprite(new Text("0",Utility.getGameFont(20), TextAlignment.RIGHT),new Transform(x+390,65),52));
    }

    @Override
    public void clear() {
        for(GameObject gameObject : Monitored_Object){
            gameObject.setDestroyed(true);
        }
        Monitored_Object.clear();
    }

    @Override
    public void onUpdate() {
        part.getText().setText(Utility.NumberToString(StatManager.getInstance().getCoin()));
        soul.getText().setText(Utility.NumberToString(StatManager.getInstance().getSoul()));
        honey.getText().setText(Utility.NumberToString(StatManager.getInstance().getAmber()));
    }
}
