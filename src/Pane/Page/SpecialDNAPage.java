package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.PlayerManager;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.GameSideUIEditor;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SpecialDNAPage extends GameSideUIEditor {
    private ArrayList<UIButton> allButtons = new ArrayList<>(); //0-4 upgrade button 5 go back button
    private ArrayList<UISprite> allPrice = new ArrayList<>();

    private int moveYButton = 70;
    public SpecialDNAPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundSpecialDNAPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(new Text("Special DNA",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+130,120),52));

        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonDNA, new Transform(Utility.getGameScreenX() + 310, 180 , 0.28, 0.27), 54 , ButtonType.UPGRADEDNA)));

        // Create RifleDamage
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 32,
                        allButtons.get(0).getTransform().getPosY() + 23), 55)));

        // Create RifleFirerate
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonDNA, new Transform(Utility.getGameScreenX() + 310, 185 + moveYButton, 0.28, 0.27), 54 , ButtonType.UPGRADEDNA)));
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 32,
                        allButtons.get(1).getTransform().getPosY() + 23), 55)));

        // Create the button
        allButtons.add ((UIButton) create(new UIButton(Asset.UI.backButtonNormal, new Transform(Utility.getGameScreenX() + 33, 660, 0.38, 0.38), 54 , ButtonType.BACK)));
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChooseDNAPage, new Transform(Utility.getGameScreenX() +10, 145, 0.25, 0.25), 53));


    }
    @Override
    public void onUpdate() {
        int coin = StatManager.getInstance().getCoin();
        if(allButtons.get(2).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));

    }
}

