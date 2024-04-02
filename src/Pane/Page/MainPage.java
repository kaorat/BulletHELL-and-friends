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
    private UISprite textHeader;
    private UISprite playerText;
    private UISprite EnemyText;
    private UISprite GobletText;
    private UISprite SpecialDNAText;
    private UIButton buttonPlayer;
    private UIButton buttonEnemy;
    private UIButton buttonGoblet;
    private UIButton buttonSpecialDNA;


    private int moveYButton = 70;
    private double x = Utility.getGameScreenX();

    public MainPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));
        //Header
        create(new UISprite(Asset.UI.upgradeHeader, new Transform(Utility.getGameScreenX() + 45, 75, 0.30, 0.28), 52));


        // Create the buttonPlayer
        buttonPlayer = new UIButton(Asset.UI.buttonNavigatePlayer, new Transform(Utility.getGameScreenX() + 60, 180 , 0.26, 0.25), 54, ButtonType.NAVIGATORPLAYER);
        // Create the buttonEnemy
        buttonEnemy = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 60, 180 + moveYButton, 0.26, 0.25), 54 , ButtonType.NAVIGATORENEMY);
        // Create the buttonGoblet
        buttonGoblet = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 60, 180 + moveYButton*2, 0.26, 0.25), 54 , ButtonType.NAVIGATORGOBLET);
        // Create the buttonSpecialDNA
        buttonSpecialDNA = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 60, 180 + moveYButton*3, 0.26, 0.25), 54 , ButtonType.NAVIGATORDNA);

        // Add the button and text to the pane
        create(buttonPlayer);
        create(buttonEnemy);
        create(buttonGoblet);
        create(buttonSpecialDNA);

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
