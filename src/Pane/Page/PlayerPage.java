package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.PlayerManager;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.GraphicEditor;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PlayerPage extends GraphicEditor {
    private final ArrayList<UIButton> allButtons = new ArrayList<>(); //0-4 upgrade button 5 go back button
    private final ArrayList<UISprite> allPrice = new ArrayList<>();
    private final ArrayList<UISprite> allLvL = new ArrayList<>();
    private final ArrayList<UISprite> allDescription = new ArrayList<>();
    private final ArrayList<UISprite> allIncrease = new ArrayList<>();
    private final ArrayList<String> descTemplate = new ArrayList<>();
    private final ArrayList<String> increaseTemplate = new ArrayList<>();

    public PlayerPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundPlayerPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(Asset.UI.playerHeader, new Transform(Utility.getGameScreenX() + 86, 70, 0.24, 0.22), 52));


        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 310, 170, 0.28, 0.27), 54, ButtonType.UPGRADEMEAT)));

        // Create RifleDamage
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 32,
                        allButtons.get(0).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.BLACK), new Transform(Utility.getGameScreenX() + 200, 192, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Damage : 2.4", Utility.getGameFont(11), Color.BLACK), new Transform(Utility.getGameScreenX() + 58, 210, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Damage", Utility.getGameFont(10), Color.WHITE), new Transform(Utility.getGameScreenX() + 310, 213, 0.25, 0.25), 55)));

        // Create RifleFire rate
        int moveYButton = 70;
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton, 0.28, 0.27), 54, ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 32,
                        allButtons.get(1).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.BLACK), new Transform(Utility.getGameScreenX() + 200, 192 + moveYButton, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Fire rate : 2", Utility.getGameFont(11), Color.BLACK), new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Fire rate", Utility.getGameFont(10), Color.WHITE), new Transform(Utility.getGameScreenX() + 304, 213 + moveYButton, 0.25, 0.25), 55)));

        // Create Minimize
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton * 2, 0.28, 0.27), 54, ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(2).getTransform().getPosX() + 32,
                        allButtons.get(2).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.BLACK), new Transform(Utility.getGameScreenX() + 160, 190 + moveYButton * 2, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Hitbox size : 8", Utility.getGameFont(11), Color.BLACK), new Transform(Utility.getGameScreenX() + 60, 210 + moveYButton * 2, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Minimize", Utility.getGameFont(10), Color.WHITE), new Transform(Utility.getGameScreenX() + 340, 210 + moveYButton * 2, 0.25, 0.25), 55)));

        // Create Dexterity
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton * 3, 0.28, 0.27), 54, ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(3).getTransform().getPosX() + 32,
                        allButtons.get(3).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.BLACK), new Transform(Utility.getGameScreenX() + 160, 190 + moveYButton * 3, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Dexterity : 2", Utility.getGameFont(11), Color.BLACK), new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton * 3, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Dexterity", Utility.getGameFont(10), Color.WHITE), new Transform(Utility.getGameScreenX() + 340, 210 + moveYButton * 3, 0.25, 0.25), 55)));

        // Create Proficiency
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton * 4, 0.28, 0.27), 54, ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(4).getTransform().getPosX() + 32,
                        allButtons.get(4).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.BLACK), new Transform(Utility.getGameScreenX() + 180, 190 + moveYButton * 4, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Parts per graze : 2", Utility.getGameFont(11), Color.BLACK), new Transform(Utility.getGameScreenX() + 58, 206 + moveYButton * 4, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+1 part", Utility.getGameFont(10), Color.WHITE), new Transform(Utility.getGameScreenX() + 325, 210 + moveYButton * 4, 0.25, 0.25), 55)));


        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.backButtonNormal, new Transform(Utility.getGameScreenX() + 33, 660, 0.38, 0.38), 54, ButtonType.BACK)));
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChoosePlayerPage, new Transform(Utility.getGameScreenX() + 10, 145, 0.25, 0.25), 53));

        //Init Template
        descTemplate.add("Damage : ");
        descTemplate.add("Fire rate : ");
        descTemplate.add("Hitbox size : ");
        descTemplate.add("Graze hitbox size : ");
        descTemplate.add("Part per graze : ");
        increaseTemplate.add("damage");
        increaseTemplate.add("shot/s");
        increaseTemplate.add("m");
        increaseTemplate.add("m");
        increaseTemplate.add("parts");
    }

    @Override
    public void onUpdate() {
        int coin = StatManager.getInstance().getCoin();
        if (allButtons.get(5).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
        for (int i = 0; i < 5; i++) {
            //Variable
            int level = PlayerManager.getInstance().getPlayerPerks().get(i);
            int basePrice = Config.player_basePrices.get(i).intValue();
            int cost = (int) (basePrice * Math.pow(Config.player_priceIncrements.get(i), level));
            //Max level
            if (level >= Config.player_maxLevels.get(i)) {
                allPrice.get(i).getText().setText("MAX");
                allButtons.get(i).setEnable(false);
                continue;
            }
            //Price
            UISprite price = allPrice.get(i);
            price.getText().setText(Utility.NumberToString(cost));
            //Button
            UIButton button = allButtons.get(i);

            if (coin >= cost) {
                button.setEnable(true);
                if (button.isPressed()) {
                    StatManager.getInstance().setCoin(coin - cost);
//                    PlayerManager.getInstance().getPlayerPerks().set(i+1,level+1);
                    PlayerManager.getInstance().upgradeStat(i);
                }
            } else {
                button.setEnable(false);
            }
            //Level
            allLvL.get(i).getText().setText("LV." + Utility.NumberToString(level));
            //Desc
            allDescription.get(i).getText().setText(descTemplate.get(i) + Utility.NumberToString(Config.player_baseValues.get(i) + ((Config.player_upgradeValues.get(i)) * level)) + " " + increaseTemplate.get(i));
            //Desc
            allIncrease.get(i).getText().setText(Utility.NumberToString(Config.player_upgradeValues.get(i)) + " " + increaseTemplate.get(i));
        }
    }
}
