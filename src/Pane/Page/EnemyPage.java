package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.PlayerManager;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.GameSideUIEditor;
import Pane.GraphicEditor;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class EnemyPage extends GraphicEditor {
    private ArrayList<UIButton> allButtons = new ArrayList<>(); //0-6 upgrade button 7 go back button
    private ArrayList<UISprite> allPrice = new ArrayList<>();
    private ArrayList<UISprite> allLvL = new ArrayList<>();
    private ArrayList<UISprite> allDescription = new ArrayList<>();
    private ArrayList<UISprite> allIncrease = new ArrayList<>();
    private final ArrayList<String> descTemplete = new ArrayList<>();
    private final ArrayList<String> increaseTemplete = new ArrayList<>();
    private int moveYButton = 70;

    private double x = Utility.getGameScreenX();

    public EnemyPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundEnemyPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(new Text("Enemy",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+180,110),52));

        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 313, 192 , 0.25, 0.24), 54 , ButtonType.UPGRADE)));
        // Create CalciumGene
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 28,
                        allButtons.get(0).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 200, 215, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Enemy’s HP : 100", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 62, 234, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Damage", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 237, 0.25, 0.25), 55)));

        // Create AgilityGene
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 313, 190 + moveYButton, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 28,
                        allButtons.get(1).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 188, 213 + moveYButton, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Enemy’s Fire rate : 2.4", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 62, 232 + moveYButton, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Firerate", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 297, 234 + moveYButton, 0.25, 0.25), 55)));

        // Create LethalMutation
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 313, 188 + moveYButton*2, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(2).getTransform().getPosX() + 28,
                        allButtons.get(2).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 228, 211 + moveYButton*2, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Bullet Speed : 1.2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 62, 230 + moveYButton*2, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Minimize", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 335, 232 + moveYButton*2, 0.25, 0.25), 55)));

        // Create FuzzyMutation
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 313, 190 + moveYButton*3, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(3).getTransform().getPosX() + 28,
                        allButtons.get(3).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 220, 209 + moveYButton*3, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Bullet quantity : 8", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 62, 228 + moveYButton*3, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Dexterity", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 340, 232 + moveYButton*3, 0.25, 0.25), 55)));

        // Create Elongation
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 313, 188 + moveYButton*4, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(4).getTransform().getPosX() + 28,
                        allButtons.get(4).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 178, 207 + moveYButton*4, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Bullet length : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 62, 224 + moveYButton*4, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+1 part", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 325, 228 + moveYButton*4, 0.25, 0.25), 55)));


        // Create the button
        allButtons.add ((UIButton) create(new UIButton(Asset.UI.backButton, new Transform(Utility.getGameScreenX() + 33, 660, 0.7, 1), 54 , ButtonType.BACK)));
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChooseEnemyPage, new Transform(Utility.getGameScreenX() +17, 170, 0.25, 0.25), 53));

        //Init Templete
        descTemplete.add("Enemy’s HP : ");
        descTemplete.add("Enemy’s Fire rate : ");
        descTemplete.add("Bullet Speed : ");
        descTemplete.add("Bullet quantity : ");
        descTemplete.add("Bullet length : ");
        increaseTemplete.add("damage");
        increaseTemplete.add("shot/s");
        increaseTemplete.add("m");
        increaseTemplete.add("m");
        increaseTemplete.add("parts");
    }
    @Override
    public void onUpdate() {
        int coin = StatManager.getInstance().getCoin();
        if(allButtons.get(5).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
        for(int i=0;i<5;i++){
            //Variable
            int level = PlayerManager.getInstance().getPlayerPerks().get(i+1);
            int basePrice = Config.player_basePrices.get(i).intValue();
            int cost = basePrice * (int) Math.pow(Config.player_priceIncrements.get(i),level);
            //Price
            UISprite price = allPrice.get(i);
            price.getText().setText(Utility.NumberToString(cost));
            //Button
            UIButton button = allButtons.get(i);

            if(coin > cost){
                button.setEnable(true);
                if(button.isPressed()){
                    coin-= cost;
                    PlayerManager.getInstance().getPlayerPerks().set(i+1,level+1);
                }
            }
            else{
                button.setEnable(false);
            }
            //Level
            allLvL.get(i).getText().setText("LV."+Utility.NumberToString(level));
            //Desc
            allDescription.get(i).getText().setText(descTemplete.get(i)+Utility.NumberToString(Config.player_baseValues.get(i)+((Config.player_upgradeValues.get(i))*level))+" "+increaseTemplete.get(i));
            //Desc
            allIncrease.get(i).getText().setText(Utility.NumberToString(Config.player_upgradeValues.get(i))+" "+increaseTemplete.get(i));
        }
    }
}

