package Pane;

import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.Page.MainPage;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class GameSideUIEditor extends GraphicEditor {
    private final UISprite part;
    private final UISprite soul;
    private final UISprite honey;
    protected double x;

    public GameSideUIEditor(GraphicsContext graphicsContext) {//Init
        super(graphicsContext);
        //set field
        x = Utility.getGameScreenX();

        //Currency background
        for (int i = 0; i < 2; i++) {
            create(new UISprite(Asset.UI.currencyBG, new Transform(x + (40 + (i * 132)), 40, 0.32, 0.29), 51));
        }
        create(new UISprite(Asset.UI.currencyBG, new Transform(x + 304, 40, 0.25, 0.29), 51));

        //Currency
        create(new UISprite(Asset.UI.partUI, new Transform(x + 55, 50, 0.035, 0.035), 52));
        create(new UISprite(Asset.UI.soulUI, new Transform(x + 185, 50, 0.035, 0.035), 52));
        create(new UISprite(Asset.UI.honeyUI, new Transform(x + 315, 50, 0.035, 0.035), 52));

        //Will change text
        part = (UISprite) create(new UISprite(new Text("0", Utility.getGameFont(12), Color.WHITE, TextAlignment.RIGHT), new Transform(x + 152, 67), 52));
        soul = (UISprite) create(new UISprite(new Text("0", Utility.getGameFont(12), Color.WHITE, TextAlignment.RIGHT), new Transform(x + 284, 67), 52));
        honey = (UISprite) create(new UISprite(new Text("0", Utility.getGameFont(12), Color.WHITE, TextAlignment.RIGHT), new Transform(x + 390, 67), 52));

//        create(new UISprite(Asset.UI.currencyBG,new Transform(100,100,0.4,0.12),51));
        SceneManager.setCurrentPage(new MainPage(graphicsContext));

    }

    @Override
    public void onUpdate() {
        part.getText().setText(Utility.NumberToString(StatManager.getInstance().getCoin()));
        soul.getText().setText(Utility.NumberToString(StatManager.getInstance().getSoul()));
        honey.getText().setText(Utility.NumberToString(StatManager.getInstance().getAmber()));
    }


}
