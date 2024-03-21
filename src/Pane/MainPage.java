package Pane;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainPage extends GameSideUIEditor {

    public MainPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        // Create the button
        UIButton buttonPlayer = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 130, 0.25, 0.27), 54);

// Create the text sprite after the button so that it appears below the button
        UISprite playerText = (UISprite) create(new UISprite(new Text("Player", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonPlayer.getTransform().getPosX() + 110,
                        buttonPlayer.getTransform().getPosY() + 35), 55));

// Add the button and text to the pane
        create(buttonPlayer);
    }


}
