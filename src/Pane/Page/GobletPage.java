package Pane.Page;

import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.EnemyManager;
import Manager.PlayerManager;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.GameSideUIEditor;
import Pane.GraphicEditor;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import Utils.ButtonType;

import java.util.ArrayList;

public class GobletPage extends GraphicEditor {

    private UIButton buttonGoBack;
    private UISprite textHeader;

    private int moveYButton = 65;
    private double x = Utility.getGameScreenX();
    public GobletPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background
        create(new UISprite(Asset.UI.mainBackground, new Transform(Utility.getGameScreenX(), 0, 0.3, 0.25), 50));

        //Header
        create(new UISprite(Asset.UI.headerMain, new Transform(Utility.getGameScreenX() +135, 92, 0.60, 0.65), 53));
        textHeader=(UISprite) create(new UISprite(new Text("Goblet",Utility.getGameFont(22 ), Color.BLACK),
                new Transform(x+168,120),52));



        // Create the button
        buttonGoBack = new UIButton(Asset.UI.backButton, new Transform(Utility.getGameScreenX() + 33, 660, 0.7, 1), 54 , ButtonType.BACK);


        create(buttonGoBack);



    }
    @Override
    public void onUpdate() {
        if(buttonGoBack.isPressed()){
            SceneManager.setCurrentPage(new MainPage(graphicsContext));
            System.out.println("Now is MainPage");
        }

    }
    public void reset(){
        //calculate honey
        StatManager statManager = StatManager.getInstance();
        while(statManager.getTotalCoin()>=1000*statManager.getHoneyLevel()){
            statManager.setTotalCoin(statManager.getTotalCoin()-(1000*statManager.getHoneyLevel()));
            StatManager.getInstance().setHoneyLevel(statManager.getHoneyLevel()+1);
            statManager.setAmber(statManager.getAmber()+1);
        }
        PlayerManager.getInstance().reset();
        EnemyManager.getInstance().reset();
    }
}
