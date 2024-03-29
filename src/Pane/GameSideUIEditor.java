package Pane;

import GameEntity.GameObject;
import GameEntity.UI.UISprite;
import Manager.StatManager;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class GameSideUIEditor extends GraphicEditor{
    protected double x;
    private UISprite part;
    private UISprite soul;
    private UISprite honey;
    public GameSideUIEditor(GraphicsContext graphicsContext ) {//Init
        super(graphicsContext);
        //set field
        x=Utility.getGameScreenX();

        //Currency background
        for(int i=0;i<2;i++){
            create(new UISprite(Asset.UI.currencyBG,new Transform(x+(40+(i*132)),40,0.32,0.29),51));
        }
        create(new UISprite(Asset.UI.currencyBG,new Transform(x+304,40,0.25,0.29),51));

        //Currency
        create(new UISprite(Asset.UI.partUI,new Transform(x+55,45,0.05,0.05),52));
        create(new UISprite(Asset.UI.soulUI,new Transform(x+180,45,0.05,0.05),52));
        create(new UISprite(Asset.UI.honeyUI,new Transform(x+310,45,0.05,0.05),52));

        //Will change text
        part=(UISprite) create(new UISprite(new Text("0",Utility.getGameFont(18 ), Color.WHITE,TextAlignment.RIGHT),new Transform(x+152,67),52));
        soul=(UISprite) create(new UISprite(new Text("0",Utility.getGameFont(18), Color.WHITE),new Transform(x+267,67),52));
        honey=(UISprite) create(new UISprite(new Text("0",Utility.getGameFont(18), Color.WHITE),new Transform(x+372,67),52));

//        create(new UISprite(Asset.UI.currencyBG,new Transform(100,100,0.4,0.12),51));

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
