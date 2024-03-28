package Pane;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GobletPage extends GameSideUIEditor {

    public GobletPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        // Create the button


    }
}

