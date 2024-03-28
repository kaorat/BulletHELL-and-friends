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


    private int moveYButton = 65;
    private double x = Utility.getGameScreenX();

    public MainPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));
        //Header
        create(new UISprite(Asset.UI.headerMain, new Transform(Utility.getGameScreenX() +119, 92, 0.7, 0.65), 53));
        textHeader=(UISprite) create(new UISprite(new Text("Upgrade",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+155,120),52));

        // Create the buttonPlayer
        buttonPlayer = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 , 0.25, 0.27), 54, ButtonType.NAVIGATOR);
        playerText = (UISprite) create(new UISprite(new Text("Player", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonPlayer.getTransform().getPosX() + 110,
                        buttonPlayer.getTransform().getPosY() + 35), 55));

        // Create the buttonEnemy
        buttonEnemy = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 + moveYButton, 0.25, 0.27), 54 , ButtonType.NAVIGATOR);
        EnemyText = (UISprite) create(new UISprite(new Text("Enemy", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonEnemy.getTransform().getPosX() + 110,
                        buttonEnemy.getTransform().getPosY() + 35 ), 55));

        // Create the buttonGoblet
        buttonGoblet = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 + moveYButton*2, 0.25, 0.27), 54 , ButtonType.NAVIGATOR);
        GobletText = (UISprite) create(new UISprite(new Text("Goblet", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonGoblet.getTransform().getPosX() + 110,
                        buttonGoblet.getTransform().getPosY() + 35 ), 55));

        // Create the buttonSpecialDNA
        buttonSpecialDNA = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 + moveYButton*3, 0.25, 0.27), 54 , ButtonType.NAVIGATOR);
        SpecialDNAText = (UISprite) create(new UISprite(new Text("Special DNA", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonSpecialDNA.getTransform().getPosX() + 80,
                        buttonSpecialDNA.getTransform().getPosY() + 35 ), 55));




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
