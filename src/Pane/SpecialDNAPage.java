package Pane;

import GameEntity.UI.UISprite;
import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;

public class SpecialDNAPage extends GameSideUIEditor {

    public SpecialDNAPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        // Create the button


    }
}

