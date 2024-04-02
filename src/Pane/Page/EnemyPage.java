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
        create(new UISprite(Asset.UI.enemyHeader, new Transform(Utility.getGameScreenX() + 86, 70, 0.24, 0.22), 52));


        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 303, 194 , 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        // Create CalciumGene
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 32,
                        allButtons.get(0).getTransform().getPosY() + 21), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 200, 217, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Enemy’s HP : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 62, 234, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 HP", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 323, 231, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 parts", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 315, 241, 0.25, 0.25), 55)));


        // Create AgilityGene
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 303, 192 + moveYButton, 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 32,
                        allButtons.get(1).getTransform().getPosY() + 21), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 188, 217 + moveYButton, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Enemy’s Fire rate : 0", Utility.getGameFont(10), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 62, 232 + moveYButton, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 fire rate", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 230 + moveYButton*1, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 parts", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 239 + moveYButton*1, 0.25, 0.25), 55)));

        // Create LethalMutation
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 303, 190 + moveYButton*2, 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(2).getTransform().getPosX() + 32,
                        allButtons.get(2).getTransform().getPosY() + 21), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 228, 213 + moveYButton*2, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Bullet Speed : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 62, 230 + moveYButton*2, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 speed", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 229 + moveYButton*2, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 parts", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 239 + moveYButton*2, 0.25, 0.25), 55)));

        // Create FuzzyMutation
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 303, 188 + moveYButton*3, 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(3).getTransform().getPosX() + 32,
                        allButtons.get(3).getTransform().getPosY() + 21), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 220, 211 + moveYButton*3, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Bullet quantity : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 62, 228 + moveYButton*3, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 quantity", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 228 + moveYButton*3, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 parts", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 239 + moveYButton*3, 0.25, 0.25), 55)));

        // Create Elongation
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 303, 186 + moveYButton*4, 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(4).getTransform().getPosX() + 32,
                        allButtons.get(4).getTransform().getPosY() + 21), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 178, 209 + moveYButton*4, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Bullet length : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 62, 226 + moveYButton*4, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 length", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 225 + moveYButton*4, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 parts", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 237 + moveYButton*4, 0.25, 0.25), 55)));

        //Create GeneticDrift
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 303, 188 + moveYButton*5, 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(5).getTransform().getPosX() + 32,
                        allButtons.get(5).getTransform().getPosY() + 21), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 200, 209 + moveYButton*5, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Chance to obtain soul : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 62, 222 + moveYButton*5, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0% chances", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 228 + moveYButton*5, 0.25, 0.25), 55)));

        //Create FastReproduction
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 303, 184 + moveYButton*6, 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(6).getTransform().getPosX() + 32,
                        allButtons.get(6).getTransform().getPosY() + 21), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 245, 203 + moveYButton*6, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Spawn time : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 62, 222 + moveYButton*6, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("0 s", Utility.getGameFont(9), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 330, 222 + moveYButton*6, 0.25, 0.25), 55)));

        //Unlock
        create(new UISprite(new Text("Unlock Sheep ",Utility.getGameFont(18 ), Color.BLACK),
                new Transform(x+100,685),52));
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonMeat, new Transform(Utility.getGameScreenX() + 280, 665, 0.28, 0.24), 54 , ButtonType.UPGRADEMEAT)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(12), Color.YELLOWGREEN),
                new Transform(allButtons.get(7).getTransform().getPosX() + 32,
                        allButtons.get(7).getTransform().getPosY() + 21), 55)));


        // Create the button
        allButtons.add ((UIButton) create(new UIButton(Asset.UI.backButtonNormal, new Transform(Utility.getGameScreenX() + 33, 660, 0.34, 0.34), 54 , ButtonType.BACK)));

        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChooseEnemyPage, new Transform(Utility.getGameScreenX() +17, 170, 0.25, 0.25), 53));

        //Init Templete
        descTemplete.add("Enemy’s HP : ");
        descTemplete.add("Enemy’s Fire rate : ");
        descTemplete.add("Bullet Speed : ");
        descTemplete.add("Bullet quantity : ");
        descTemplete.add("Bullet length : ");
        descTemplete.add("Chance to obtain soul :  ");
        descTemplete.add("Spawn time :  ");

        increaseTemplete.add("hp");
        increaseTemplete.add("shot/s");
        increaseTemplete.add("m/s");
        increaseTemplete.add("");
        increaseTemplete.add("");
        increaseTemplete.add("%");
        increaseTemplete.add("s");
    }
    @Override
    public void onUpdate() {
        int coin = StatManager.getInstance().getCoin();
        if(allButtons.get(8).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
//        for(int i=0;i<8;i++){
//            //Variable
//            int level = PlayerManager.getInstance().getPlayerPerks().get(i+1);
//            int basePrice = Config.enemy_basePrices.get(i).intValue();
//            int cost = (int)(basePrice * Math.pow(Config.enemy_priceIncrements.get(i),level));
//            //Price
//            UISprite price = allPrice.get(i);
//            price.getText().setText(Utility.NumberToString(cost));
//            //Button
//            UIButton button = allButtons.get(i);
//
//            if(coin > cost){
//                button.setEnable(true);
//                if(button.isPressed()){
//                    StatManager.getInstance().setCoin(coin-cost);
//                    PlayerManager.getInstance().getPlayerPerks().set(i+1,level+1);
//                }
//            }
//            else{
//                button.setEnable(false);
//            }
//            //Level
//            allLvL.get(i).getText().setText("LV."+Utility.NumberToString(level));
//            //Desc
//            allDescription.get(i).getText().setText(descTemplete.get(i)+Utility.NumberToString(Config.player_baseValues.get(i)+((Config.player_upgradeValues.get(i))*level))+" "+increaseTemplete.get(i));
//            //Desc
//            allIncrease.get(i).getText().setText(Utility.NumberToString(Config.player_upgradeValues.get(i))+" "+increaseTemplete.get(i));
//        }
    }
}

