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
                new Transform(buttonRifleDamage.getTransform().getPosX() + 50,
                        buttonRifleDamage.getTransform().getPosY() + 35), 55));
        textRifleDamage.getTransform().setPosX(buttonRifleDamage.getTransform().getPosX() + 27);
        textRifleDamage.getTransform().setPosY(buttonRifleDamage.getTransform().getPosY() + 20);

        // Create RifleFirerate
        buttonRifleFirerate = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textRifleFirerate = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonRifleFirerate.getTransform().getPosX() + 50,
                        buttonRifleFirerate.getTransform().getPosY() + 35), 55));
        textRifleFirerate.getTransform().setPosX(buttonRifleFirerate.getTransform().getPosX() + 27);
        textRifleFirerate.getTransform().setPosY(buttonRifleFirerate.getTransform().getPosY() + 20);

        // Create Proficiency
        buttonProficiency = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*2, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textProficiency = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonProficiency.getTransform().getPosX() + 50,
                        buttonProficiency.getTransform().getPosY() + 35), 55));
        textProficiency.getTransform().setPosX(buttonProficiency.getTransform().getPosX() + 27);
        textProficiency.getTransform().setPosY(buttonProficiency.getTransform().getPosY() + 20);

        // Create Dexterity
        buttonDexterity = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*3, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textDexterity = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonDexterity.getTransform().getPosX() + 50,
                        buttonDexterity.getTransform().getPosY() + 35), 55));
        textDexterity.getTransform().setPosX(buttonDexterity.getTransform().getPosX() + 27);
        textDexterity.getTransform().setPosY(buttonDexterity.getTransform().getPosY() + 20);

        // Create Minimize
        buttonMinimize = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*4, 0.25, 0.27), 54 , ButtonType.UPGRADE);
        textMinimize = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonMinimize.getTransform().getPosX() + 50,
                        buttonMinimize.getTransform().getPosY() + 35), 55));
        textMinimize.getTransform().setPosX(buttonMinimize.getTransform().getPosX() + 27);
        textMinimize.getTransform().setPosY(buttonMinimize.getTransform().getPosY() + 20);



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
