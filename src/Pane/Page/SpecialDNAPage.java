package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.GraphicEditor;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SpecialDNAPage extends GraphicEditor {
    private final ArrayList<UIButton> allButtons = new ArrayList<>(); //0-4 upgrade button 5 go back button
    private final ArrayList<UISprite> allPrice = new ArrayList<>();

    public SpecialDNAPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundSpecialDNAPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(Asset.UI.DNAHeader, new Transform(Utility.getGameScreenX() + 86, 70, 0.24, 0.22), 52));


        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonDNA, new Transform(Utility.getGameScreenX() + 310, 180, 0.28, 0.27), 54, ButtonType.UPGRADEDNA)));

        // Create RifleDamage
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 32,
                        allButtons.get(0).getTransform().getPosY() + 23), 55)));

        // Create RifleFire rate
        int moveYButton = 70;
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonDNA, new Transform(Utility.getGameScreenX() + 310, 185 + moveYButton, 0.28, 0.27), 54, ButtonType.UPGRADEDNA)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 32,
                        allButtons.get(1).getTransform().getPosY() + 23), 55)));

        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.backButtonNormal, new Transform(Utility.getGameScreenX() + 33, 660, 0.38, 0.38), 54, ButtonType.BACK)));
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChooseDNAPage, new Transform(Utility.getGameScreenX() + 10, 145, 0.25, 0.25), 53));


    }

    @Override
    public void onUpdate() {
        int dna = StatManager.getInstance().getDna();
        if (allButtons.get(2).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
        for (int i = 0; i < 2; i++) {
            //Variable
            int level = StatManager.getInstance().getGobletLevels().get(i);
            UISprite price = allPrice.get(i);
            if (level > 0) {
                price.getText().setText("OBTAINED");
                continue;
            }
            int cost = level + 1;
            //Price

            price.getText().setText(Utility.NumberToString(cost));
            //Button
            UIButton button = allButtons.get(i);

            if (dna >= cost) {
                button.setEnable(true);
                if (button.isPressed()) {
                    StatManager.getInstance().setAmber(dna - cost);
                    StatManager.getInstance().getGobletLevels().set(i, level + 1);
                }
            } else {
                button.setEnable(false);
            }

        }
    }
}

