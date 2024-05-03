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
    private final ArrayList<UISprite> dnaUI = new ArrayList<>();

    public SpecialDNAPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundSpecialDNAPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(Asset.UI.dnaHeader, new Transform(Utility.getGameScreenX() + 86, 70, 0.24, 0.22), 52));


        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonDNA, new Transform(Utility.getGameScreenX() + 310, 180, 0.28, 0.27), 54, ButtonType.UPGRADEDNA)));

        // Create Missile
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 32,
                        allButtons.get(0).getTransform().getPosY() + 23), 55)));

        // Create Laser
        int moveYButton = 70;
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonDNA, new Transform(Utility.getGameScreenX() + 310, 185 + moveYButton, 0.28, 0.27), 54, ButtonType.UPGRADEDNA)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 32,
                        allButtons.get(1).getTransform().getPosY() + 23), 55)));
        //Create DNA obtained UI
        dnaUI.add((UISprite) create(new UISprite(Asset.UI.dnaUI,new Transform(Utility.getGameScreenX() + 60, 500, 0.2, 0.2), 54)));
        dnaUI.add((UISprite) create(new UISprite(Asset.UI.dnaUI,new Transform(Utility.getGameScreenX() + 160, 500, 0.2, 0.2), 54)));
        dnaUI.add((UISprite) create(new UISprite(Asset.UI.dnaUI,new Transform(Utility.getGameScreenX() + 260, 500, 0.2, 0.2), 54)));
        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.backButtonNormal, new Transform(Utility.getGameScreenX() + 33, 660, 0.38, 0.38), 54, ButtonType.BACK)));
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChooseDNAPage, new Transform(Utility.getGameScreenX() + 10, 145, 0.25, 0.25), 53));


    }

    @Override
    public void onUpdate() {
        long dna = StatManager.getInstance().getDna();
        if (allButtons.get(2).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
        for (int i = 0; i < 3; i++){
            UISprite dna1 = dnaUI.get(i);
            int bossDefeated = StatManager.getInstance().getBossDefeated();
            dna1.setSprite(i < bossDefeated ? Asset.UI.dnaUI : Asset.UI.dnablackUI);
        }
        for (int i = 0; i < 2; i++) {
            //Variable
            int level = StatManager.getInstance().getDnaLevels().get(i);
            UISprite price = allPrice.get(i);
            if (level > 0) {
                price.getText().setText("Ok !");
                continue;
            }
            //Price

            price.getText().setText("1");
            //Button
            UIButton button = allButtons.get(i);

            if (dna >= 1) {
                button.setEnable(true);
                if (button.isPressed()) {
                    StatManager.getInstance().setDna(dna - 1);
                    StatManager.getInstance().getDnaLevels().set(i, level + 1);
                }
            } else {
                button.setEnable(false);
            }

        }
    }
}

