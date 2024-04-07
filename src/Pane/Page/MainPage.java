package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Pane.GraphicEditor;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import Utils.ButtonType;
public class MainPage extends GraphicEditor {
    private final UIButton buttonPlayer;
    private final UIButton buttonEnemy;
    private final UIButton buttonGoblet;
    private final UIButton buttonSpecialDNA;


    public MainPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));
        //Header
        create(new UISprite(Asset.UI.upgradeHeader, new Transform(Utility.getGameScreenX() + 45, 75, 0.30, 0.28), 52));


        // Create the buttonPlayer
        buttonPlayer = new UIButton(Asset.UI.buttonNavigatePlayer, new Transform(Utility.getGameScreenX() + 80, 180 , 0.22, 0.21), 54, ButtonType.NAVIGATORPLAYER);
        // Create the buttonEnemy
        int moveYButton = 60;
        buttonEnemy = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 80, 180 + moveYButton, 0.22, 0.21), 54 , ButtonType.NAVIGATORENEMY);
        // Create the buttonGoblet
        buttonGoblet = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 80, 180 + moveYButton *2, 0.22, 0.21), 54 , ButtonType.NAVIGATORGOBLET);
        // Create the buttonSpecialDNA
        buttonSpecialDNA = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 80, 180 + moveYButton *3, 0.22, 0.21), 54 , ButtonType.NAVIGATORDNA);

        UIButton buttonBossCalled = new UIButton(Asset.UI.buttonBossNormal, new Transform(Utility.getGameScreenX() + 140, 415, 0.24, 0.24), 54, ButtonType.BOSSCALLED);

        create(new UISprite(new Text("1 / 3", Utility.getGameFont(23), Color.BROWN) ,new Transform(Utility.getGameScreenX() + 190, 540, 0.25, 0.25), 55));
        create(new UISprite(new Text("Soul:    100", Utility.getGameFont(11), Color.BROWN) ,new Transform(Utility.getGameScreenX() + 180, 560, 0.25, 0.25), 55));
        create(new UISprite(new Text("00.00.00.00", Utility.getGameFont(11), Color.BROWN) ,new Transform(Utility.getGameScreenX() + 280, 617, 0.25, 0.25), 55));
        create(new UISprite(new Text("68%", Utility.getGameFont(11), Color.BROWN) ,new Transform(Utility.getGameScreenX() + 280, 636, 0.25, 0.25), 55));
        create(new UISprite(new Text("213", Utility.getGameFont(11), Color.BROWN) ,new Transform(Utility.getGameScreenX() + 280, 656, 0.25, 0.25), 55));
        create(new UISprite(new Text("8", Utility.getGameFont(11), Color.BROWN) ,new Transform(Utility.getGameScreenX() + 280, 676, 0.25, 0.25), 55));

        create(new UISprite(Asset.UI.backgroundStatus, new Transform(Utility.getGameScreenX() + 55, 440, 0.25, 0.25), 52));


        // Add the button and text to the pane
        create(buttonPlayer);
        create(buttonEnemy);
        create(buttonGoblet);
        create(buttonSpecialDNA);
        create(buttonBossCalled);

    }

    @Override
    public void onUpdate() {
     if(buttonPlayer.isPressed()){
            SceneManager.setCurrentPage(new PlayerPage(graphicsContext));
         System.out.println("Now is PlayerPage");
     }
        if(buttonEnemy.isPressed()){
                SceneManager.setCurrentPage(new EnemyPage(graphicsContext));
            System.out.println("Now is EnemyPage");
        }
        if(buttonGoblet.isPressed()){
            SceneManager.setCurrentPage(new GobletPage(graphicsContext));
            System.out.println("Now is GobletPage");
        }
        if(buttonSpecialDNA.isPressed()){
            SceneManager.setCurrentPage(new SpecialDNAPage(graphicsContext));
            System.out.println("Now is SpecialDNAPage");
        }


    }
}
