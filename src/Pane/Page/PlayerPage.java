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

    private UIButton buttonGoBack;
    private UISprite textHeader;
    private UIButton buttonRifleDamage;
    private UISprite textRifleDamage;
    private UIButton buttonRifleFirerate;
    private UISprite textRifleFirerate;
    private UIButton buttonProficiency;
    private UISprite textProficiency;
    private UIButton buttonDexterity;
    private UISprite textDexterity;
    private UIButton buttonMinimize;
    private UISprite textMinimize;
    private UISprite descriptionRifleDamage;
    private UISprite descriptionRifleFirerate;
    private UISprite descriptionProficiency;
    private UISprite descriptionDexterity;
    private UISprite descriptionMinimize;
    private UISprite lvlRifleDamage;
    private UISprite lvlRifleFirerate;
    private UISprite lvlProficiency;
    private UISprite lvlDexterity;
    private UISprite lvlMinimize;
    private UISprite increaseRifleDamage;
    private UISprite increaseRifleFirerate;
    private UISprite increaseProficiency;
    private UISprite increaseDexterity;
    private UISprite increaseMinimize;

    private ArrayList<UIButton> allButtons = new ArrayList<>();

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
        buttonRifleDamage = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 , 0.25, 0.27), 54 , ButtonType.UPGRADE);

        // Create RifleDamage
        textRifleDamage = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonRifleDamage.getTransform().getPosX() + 28,
                        buttonRifleDamage.getTransform().getPosY() + 23), 55));
        lvlRifleDamage = (UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 260, 192, 0.25, 0.25), 55));
        descriptionRifleDamage = (UISprite) create(new UISprite(new Text("Damage : 2.4", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210, 0.25, 0.25), 55));
        increaseRifleDamage = (UISprite) create(new UISprite(new Text("+0.25 Damage", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 213, 0.25, 0.25), 55));

        // Create RifleFirerate
        buttonRifleFirerate = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textRifleFirerate = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonRifleFirerate.getTransform().getPosX() + 28,
                        buttonRifleFirerate.getTransform().getPosY() + 23), 55));
        lvlRifleFirerate = (UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 260, 192 + moveYButton, 0.25, 0.25), 55));
        descriptionRifleFirerate = (UISprite) create(new UISprite(new Text("Firerate : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton, 0.25, 0.25), 55));
        increaseRifleFirerate = (UISprite) create(new UISprite(new Text("+0.25 Firerate", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 310, 213 + moveYButton, 0.25, 0.25), 55));

        // Create Proficiency
        buttonProficiency = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*2, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textProficiency = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonProficiency.getTransform().getPosX() + 28,
                        buttonProficiency.getTransform().getPosY() + 23), 55));
        lvlProficiency = (UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 180, 190 + moveYButton*2, 0.25, 0.25), 55));
        descriptionProficiency = (UISprite) create(new UISprite(new Text("Proficiency : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*2, 0.25, 0.25), 55));
        increaseProficiency = (UISprite) create(new UISprite(new Text("+0.25 Proficiency", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 280, 213 + moveYButton*2, 0.25, 0.25), 55));

        // Create Dexterity
        buttonDexterity = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*3, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textDexterity = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonDexterity.getTransform().getPosX() + 28,
                        buttonDexterity.getTransform().getPosY() + 23), 55));
        lvlDexterity = (UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 160, 190 + moveYButton*3, 0.25, 0.25), 55));
        descriptionDexterity = (UISprite) create(new UISprite(new Text("Dexterity : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*3, 0.25, 0.25), 55));
        increaseDexterity = (UISprite) create(new UISprite(new Text("+0.25 Dexterity", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 290, 213 + moveYButton*3, 0.25, 0.25), 55));


        // Create Minimize
        buttonMinimize = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*4, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textMinimize = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonMinimize.getTransform().getPosX() + 28,
                        buttonMinimize.getTransform().getPosY() + 23), 55));
        lvlMinimize = (UISprite) create(new UISprite(new Text("Lv.1", Utility.getGameFont(13), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 160, 190 + moveYButton*4, 0.25, 0.25), 55));
        descriptionMinimize = (UISprite) create(new UISprite(new Text("Minimize : 2", Utility.getGameFont(11), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 58, 210 + moveYButton*4, 0.25, 0.25), 55));
        increaseMinimize = (UISprite) create(new UISprite(new Text("+0.25 Minimize", Utility.getGameFont(10), Color.WHITE) ,new Transform(Utility.getGameScreenX() + 290, 210 + moveYButton*4, 0.25, 0.25), 55));


        // Create the button
        buttonGoBack = new UIButton(Asset.UI.backButton, new Transform(Utility.getGameScreenX() + 33, 660, 0.7, 1), 54 , ButtonType.BACK);
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChoose5, new Transform(Utility.getGameScreenX() +10, 145, 0.25, 0.25), 53));

        create(buttonGoBack);
        create(buttonRifleDamage);
        create(buttonRifleFirerate);
        create(buttonProficiency);
        create(buttonDexterity);
        create(buttonMinimize);

        allButtons.add(buttonGoBack);
        allButtons.add(buttonRifleDamage);
        allButtons.add(buttonRifleFirerate);
        allButtons.add(buttonMinimize);
        allButtons.add(buttonDexterity);
        allButtons.add(buttonProficiency);
}
    @Override
    public void onUpdate() {
        int coin = StatManager.getInstance().getCoin();
        for(int i=0;i<6;i++){
            UIButton button = allButtons.get(i);
            if(i==0){
                if(button.isPressed()) SceneManager.setCurrentPage(new MainPage(graphicsContext));
            }
            else{
                int level = PlayerManager.getInstance().getPlayerPerks().get(i);
                int basePrice = Config.player_basePrices.get(i-1).intValue();
                int cost = basePrice * (int) Math.pow(Config.player_priceIncrements.get(i-1),level);

                if(coin > cost){
                    button.setEnable(true);
                    if(button.isPressed()){
                        coin-= cost;
                        PlayerManager.getInstance().getPlayerPerks().set(i,level+1);
                    }
                }
                else{
                    button.setEnable(false);
                }
            }
        }
    }
}
