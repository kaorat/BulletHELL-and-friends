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

public class PlayerPage extends GraphicEditor {

    private UIButton buttonGoBack;
    private UISprite textHeader;
    private UIButton buttonBioticRifleDamage;
    private UISprite textBioticRifleDamage;
    private UIButton buttonBioticRifleFirerate;
    private UISprite textBioticRifleFirerate;
    private UIButton buttonProficiency;
    private UISprite textProficiency;
    private UIButton buttonDexterity;
    private UISprite textDexterity;
    private UIButton buttonMinimize;
    private UISprite textMinimize;

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
        buttonBioticRifleDamage = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 , 0.25, 0.27), 54);

        // Create BioticRifleDamage
        textBioticRifleDamage = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonBioticRifleDamage.getTransform().getPosX() + 27,
                        buttonBioticRifleDamage.getTransform().getPosY() + 20), 55));

        // Create BioticRifleFirerate
        buttonBioticRifleFirerate = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton, 0.25, 0.27), 54);
        textBioticRifleFirerate = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonBioticRifleFirerate.getTransform().getPosX() + 27,
                        buttonBioticRifleFirerate.getTransform().getPosY() + 20), 55));

        // Create Proficiency
        buttonProficiency = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*2, 0.25, 0.27), 54);
        textProficiency = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonProficiency.getTransform().getPosX() + 27,
                        buttonProficiency.getTransform().getPosY() + 20), 55));

        // Create Dexterity
        buttonDexterity = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*3, 0.25, 0.27), 54);
        textDexterity = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonDexterity.getTransform().getPosX() + 27,
                        buttonDexterity.getTransform().getPosY() + 20), 55));

        // Create Minimize
        buttonMinimize = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*4, 0.25, 0.27), 54);
        textMinimize = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonMinimize.getTransform().getPosX() + 27,
                        buttonMinimize.getTransform().getPosY() + 20), 55));

        // Create the button
        buttonGoBack = new UIButton(Asset.UI.backButton, new Transform(Utility.getGameScreenX() + 33, 660, 0.7, 1), 54);
        //choose upgrade
        create(new UISprite(Asset.UI.upgradeChoose5, new Transform(Utility.getGameScreenX() +10, 145, 0.25, 0.25), 53));

        create(buttonGoBack);
        create(buttonBioticRifleDamage);
        create(buttonBioticRifleFirerate);
        create(buttonProficiency);
        create(buttonDexterity);
        create(buttonMinimize);

        allButtons.add(buttonGoBack);
        allButtons.add(buttonBioticRifleDamage);
        allButtons.add(buttonBioticRifleFirerate);
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
