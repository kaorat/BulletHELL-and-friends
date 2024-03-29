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
import Utils.ButtonType;

import java.util.ArrayList;

public class PlayerPage extends GraphicEditor {
    private UISprite textHeader; //May not need a variable
    private ArrayList<UIButton> allButtons = new ArrayList<>(); //0-4 upgrade button 5 go back button
    private ArrayList<UISprite> allPrice = new ArrayList<>();
    private ArrayList<UISprite> allLvL = new ArrayList<>();
    private ArrayList<UISprite> allDescription = new ArrayList<>();
    private ArrayList<UISprite> allIncrease = new ArrayList<>();

    private int moveYButton = 70;

    private double x = Utility.getGameScreenX();

    public PlayerPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.backgroundPlayerPage, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        textHeader=(UISprite) create(new UISprite(new Text("Player",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+165,120),52));

        // Create the button
        allButtons.add((UIButton) create(new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 , 0.25, 0.27), 54 , ButtonType.UPGRADE)));

        // Create RifleDamage
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(0).getTransform().getPosX() + 28,
                        allButtons.get(0).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 260, 192, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Damage : 2.4", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Damage", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 213, 0.25, 0.25), 55)));

        // Create RifleFirerate
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add( (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(1).getTransform().getPosX() + 28,
                        allButtons.get(1).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 260, 192 + moveYButton, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Firerate : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Firerate", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 213 + moveYButton, 0.25, 0.25), 55)));

        // Create Proficiency
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*2, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(2).getTransform().getPosX() + 28,
                        allButtons.get(2).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 180, 190 + moveYButton*2, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Parts per graze : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*2, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+1 part", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 280, 213 + moveYButton*2, 0.25, 0.25), 55)));

        // Create Dexterity
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*3, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(3).getTransform().getPosX() + 28,
                        allButtons.get(3).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 160, 190 + moveYButton*3, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Dexterity : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*3, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Dexterity", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 290, 213 + moveYButton*3, 0.25, 0.25), 55)));


        // Create Minimize
        allButtons.add((UIButton) create( new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*4, 0.25, 0.27), 54 , ButtonType.UPGRADE)));
        allPrice.add((UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(allButtons.get(4).getTransform().getPosX() + 28,
                        allButtons.get(4).getTransform().getPosY() + 23), 55)));
        allLvL.add((UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 160, 190 + moveYButton*4, 0.25, 0.25), 55)));
        allDescription.add((UISprite) create(new UISprite(new Text("Minimize : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*4, 0.25, 0.25), 55)));
        allIncrease.add((UISprite) create(new UISprite(new Text("+0.25 Minimize", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 290, 210 + moveYButton*4, 0.25, 0.25), 55)));


        // Create the button
        allButtons.add ((UIButton) create(new UIButton(Asset.UI.backButton, new Transform(Utility.getGameScreenX() + 33, 660, 0.7, 1), 54 , ButtonType.BACK)));
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChoose5, new Transform(Utility.getGameScreenX() +10, 145, 0.25, 0.25), 53));
}
    @Override
    public void onUpdate() {
        int coin = StatManager.getInstance().getCoin();
        if(allButtons.get(5).isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
        for(int i=0;i<5;i++){
            //Price

            //Button
            UIButton button = allButtons.get(i);
            int level = PlayerManager.getInstance().getPlayerPerks().get(i+1);
            int basePrice = Config.player_basePrices.get(i).intValue();
            int cost = basePrice * (int) Math.pow(Config.player_priceIncrements.get(i),level);
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

        }
    }
}
