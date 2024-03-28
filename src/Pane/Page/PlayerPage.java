package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Pane.GameSideUIEditor;
import Pane.GraphicEditor;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PlayerPage extends GraphicEditor {

    private UIButton buttonGoBack;
    private UISprite textHeader;
    private int moveYButton = 65;

    private double x = Utility.getGameScreenX();

    public PlayerPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundPlayerPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(Asset.UI.headerMain, new Transform(Utility.getGameScreenX() +135, 92, 0.60, 0.65), 53));
        textHeader=(UISprite) create(new UISprite(new Text("Player",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+165,120),52));

        // Create the button
        buttonGoBack = new UIButton(Asset.UI.backButton, new Transform(Utility.getGameScreenX() + 33, 660, 0.7, 1), 54);

        create(new UISprite(Asset.UI.upgradeFrame, new Transform(Utility.getGameScreenX() +60, 120, 0.3, 0.3), 53));

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
