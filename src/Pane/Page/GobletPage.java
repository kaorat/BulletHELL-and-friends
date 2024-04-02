package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.EnemyManager;
import Manager.PlayerManager;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.GameSideUIEditor;
import Pane.GraphicEditor;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GobletPage extends GraphicEditor {

    private ArrayList<UIButton> allButtons = new ArrayList<>(); //0-4 upgrade button 5 go back button
    private ArrayList<UISprite> allPrice = new ArrayList<>();
    private ArrayList<UISprite> allLvL = new ArrayList<>();
    private ArrayList<UISprite> allDescription = new ArrayList<>();
    private ArrayList<UISprite> allIncrease = new ArrayList<>();
    private final ArrayList<String> descTemplete = new ArrayList<>();
    private final ArrayList<String> increaseTemplete = new ArrayList<>();
    private int moveYButton = 70;

    private double x = Utility.getGameScreenX();

    public GobletPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundGobletPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(Asset.UI.gobletHeader, new Transform(Utility.getGameScreenX() + 86, 70, 0.24, 0.22), 52));


        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButtonHoney, new Transform(Utility.getGameScreenX() + 310, 170 , 0.28, 0.27), 54 , ButtonType.UPGRADEHONEY)));

        // Create WorshipGoblet
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 32,
                        allButtons.get(0).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 220, 192, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Goblet conversion rate : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 58, 210, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0 rate", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 213, 0.25, 0.25), 55)));

        // Create EmbraceWealth
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonHoney, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton, 0.28, 0.27), 54 , ButtonType.UPGRADEHONEY)));
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 32,
                        allButtons.get(1).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 230, 192 + moveYButton, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Parts obtain multiplier : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0 multiplier", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 304, 213 + moveYButton, 0.25, 0.25), 55)));

        // Create EmbraceStrength
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonHoney, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton*2, 0.28, 0.27), 54 , ButtonType.UPGRADEHONEY)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(2).getTransform().getPosX() + 32,
                        allButtons.get(2).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 250, 190 + moveYButton*2, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Damage multiplier : 0", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 60, 210 + moveYButton*2, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0 multiplier", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 320 , 210 + moveYButton*2, 0.25, 0.25), 55)));

        // Create EmbraceGalore
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonHoney, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton*3, 0.28, 0.27), 54 , ButtonType.UPGRADEHONEY)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(3).getTransform().getPosX() + 32,
                        allButtons.get(3).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 235, 190 + moveYButton*3, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Multiple Spawn Chance : ", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*3, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0% chance", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 320, 210 + moveYButton*3, 0.25, 0.25), 55)));

        // Create EmbraceSoul
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButtonHoney, new Transform(Utility.getGameScreenX() + 310, 170 + moveYButton*4, 0.28, 0.27), 54 , ButtonType.UPGRADEHONEY)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(4).getTransform().getPosX() + 32,
                        allButtons.get(4).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 210, 188 + moveYButton*4, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Chance to obtain soul : ", Utility.getGameFont(11), Color.BLACK) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*4, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0 multiplier", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 325, 210 + moveYButton*4, 0.25, 0.25), 55)));


        // Create the button
        allButtons.add ((UIButton) create(new UIButton(Asset.UI.backButtonNormal, new Transform(Utility.getGameScreenX() + 33, 660, 0.38, 0.38), 54 , ButtonType.BACK)));
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChooseGobletPage, new Transform(Utility.getGameScreenX() +10, 145, 0.25, 0.25), 53));

        //Init Templete
        descTemplete.add("Goblet conversion rate : x");
        descTemplete.add("Parts obtain multiplier : x");
        descTemplete.add("Damage multiplier : x");
        descTemplete.add("Multiple Spawn Chance : ");
        descTemplete.add("Chance to obtain soul : x");
        increaseTemplete.add("multiplier");
        increaseTemplete.add("multiplier");
        increaseTemplete.add("multiplier");
        increaseTemplete.add("%");
        increaseTemplete.add("multiplier");


    }
    @Override
    public void onUpdate() {
        int amber = StatManager.getInstance().getAmber();
        if(allButtons.get(5).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
        for(int i=0;i<5;i++){
            //Variable
            int level = StatManager.getInstance().getGobletLevels().get(i);
            int cost = (int) (10*(Math.pow(2,level)));
            //Price
            UISprite price = allPrice.get(i);
            price.getText().setText(Utility.NumberToString(cost));
            //Button
            UIButton button = allButtons.get(i);

            if(amber > cost){
                button.setEnable(true);
                if(button.isPressed()){
                    StatManager.getInstance().setAmber(amber-cost);
                    StatManager.getInstance().getGobletLevels().set(i,level+1);
                }
            }
            else{
                button.setEnable(false);
            }
            //Level
            allLvL.get(i).getText().setText("LV."+Utility.NumberToString(level));
            //Desc
            if(i==3){
                allDescription.get(i).getText().setText(descTemplete.get(i)+level*10+" "+increaseTemplete.get(i));
                allIncrease.get(i).getText().setText(10+" "+increaseTemplete.get(i));
            }
            else{
                allDescription.get(i).getText().setText(descTemplete.get(i)+(level+1));
                allIncrease.get(i).getText().setText("1"+" "+increaseTemplete.get(i));
            }

            //Desc

        }
    }
}

