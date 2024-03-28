package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Pane.GameSideUIEditor;
import Pane.GraphicEditor;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
                new Transform(buttonBioticRifleDamage.getTransform().getPosX() + 50,
                        buttonBioticRifleDamage.getTransform().getPosY() + 35), 55));
        textBioticRifleDamage.getTransform().setPosX(buttonBioticRifleDamage.getTransform().getPosX() + 27);
        textBioticRifleDamage.getTransform().setPosY(buttonBioticRifleDamage.getTransform().getPosY() + 20);

        // Create BioticRifleFirerate
        buttonBioticRifleFirerate = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton, 0.25, 0.27), 54);
        textBioticRifleFirerate = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonBioticRifleFirerate.getTransform().getPosX() + 50,
                        buttonBioticRifleFirerate.getTransform().getPosY() + 35), 55));
        textBioticRifleFirerate.getTransform().setPosX(buttonBioticRifleFirerate.getTransform().getPosX() + 27);
        textBioticRifleFirerate.getTransform().setPosY(buttonBioticRifleFirerate.getTransform().getPosY() + 20);

        // Create Proficiency
        buttonProficiency = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*2, 0.25, 0.27), 54);
        textProficiency = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonProficiency.getTransform().getPosX() + 50,
                        buttonProficiency.getTransform().getPosY() + 35), 55));
        textProficiency.getTransform().setPosX(buttonProficiency.getTransform().getPosX() + 27);
        textProficiency.getTransform().setPosY(buttonProficiency.getTransform().getPosY() + 20);

        // Create Dexterity
        buttonDexterity = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*3, 0.25, 0.27), 54);
        textDexterity = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonDexterity.getTransform().getPosX() + 50,
                        buttonDexterity.getTransform().getPosY() + 35), 55));
        textDexterity.getTransform().setPosX(buttonDexterity.getTransform().getPosX() + 27);
        textDexterity.getTransform().setPosY(buttonDexterity.getTransform().getPosY() + 20);

        // Create Minimize
        buttonMinimize = new UIButton(Asset.UI.upgradeButton, new Transform(Utility.getGameScreenX() + 320, 170 + moveYButton*4, 0.25, 0.27), 54);
        textMinimize = (UISprite) create(new UISprite(new Text("100", Utility.getGameFont(13), Color.YELLOWGREEN),
                new Transform(buttonMinimize.getTransform().getPosX() + 50,
                        buttonMinimize.getTransform().getPosY() + 35), 55));
        textMinimize.getTransform().setPosX(buttonMinimize.getTransform().getPosX() + 27);
        textMinimize.getTransform().setPosY(buttonMinimize.getTransform().getPosY() + 20);



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

}

    @Override
    public void onUpdate() {
        if(buttonGoBack.isPressed()){
            SceneManager.setCurrentPage(new MainPage(graphicsContext));
            System.out.println("Now is MainPage");
        }

    }
}
