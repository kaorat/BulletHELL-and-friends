package Pane;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class MainPage extends GameSideUIEditor {
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

    public MainPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));
        //Header
        create(new UISprite(Asset.UI.headerMain, new Transform(Utility.getGameScreenX() +125, 92, 0.7, 0.65), 53));
        textHeader=(UISprite) create(new UISprite(new Text("Upgrade",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+160,120),52));

        // Create the buttonPlayer
        buttonPlayer = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 , 0.25, 0.27), 54);
        playerText = (UISprite) create(new UISprite(new Text("Player", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonPlayer.getTransform().getPosX() + 110,
                        buttonPlayer.getTransform().getPosY() + 35), 55));

        // Create the buttonEnemy
        buttonEnemy = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 + moveYButton, 0.25, 0.27), 54);
        EnemyText = (UISprite) create(new UISprite(new Text("Enemy", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonEnemy.getTransform().getPosX() + 110,
                        buttonEnemy.getTransform().getPosY() + 35 ), 55));

        // Create the buttonGoblet
        buttonGoblet = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 + moveYButton*2, 0.25, 0.27), 54);
        GobletText = (UISprite) create(new UISprite(new Text("Goblet", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonGoblet.getTransform().getPosX() + 110,
                        buttonGoblet.getTransform().getPosY() + 35 ), 55));

        // Create the buttonSpecialDNA
        buttonSpecialDNA = new UIButton(Asset.UI.buttonNavigate, new Transform(Utility.getGameScreenX() + 57, 145 + moveYButton*3, 0.25, 0.27), 54);
        SpecialDNAText = (UISprite) create(new UISprite(new Text("Special DNA", Utility.getGameFont(20), Color.WHITE),
                new Transform(buttonSpecialDNA.getTransform().getPosX() + 80,
                        buttonSpecialDNA.getTransform().getPosY() + 35 ), 55));


        // Add the button and text to the pane
        create(buttonPlayer);
        create(buttonEnemy);
        create(buttonGoblet);
        create(buttonSpecialDNA);


    }
}
