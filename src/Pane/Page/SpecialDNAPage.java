package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Pane.GameSideUIEditor;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import Utils.ButtonType;

public class SpecialDNAPage extends GameSideUIEditor {
    private UIButton buttonGoBack;
    private UISprite textHeader;
    private int moveYButton = 65;
    private double x = Utility.getGameScreenX();
    public SpecialDNAPage(GraphicsContext graphicsContext) {

        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(Asset.UI.headerMain, new Transform(Utility.getGameScreenX() +90, 92, 0.93, 0.65), 53));
        textHeader=(UISprite) create(new UISprite(new Text("Special DNA",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+132,120),52));

        // Create the button
        buttonGoBack = new UIButton(Asset.UI.backButton, new Transform(Utility.getGameScreenX() + 33, 660, 0.7, 1), 54 , ButtonType.BACK);


        create(buttonGoBack);



    }
    @Override
    public void onUpdate() {
        if(buttonGoBack.isPressed()){
            SceneManager.setCurrentPage(new MainPage(graphicsContext));
            System.out.println("Now is MainPage");
        }

    }
}

