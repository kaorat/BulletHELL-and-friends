package Pane;

import GameEntity.UI.UISprite;
import Manager.SceneManager;
import Pane.Page.BossPage;
import Utils.Asset;
import Utils.Transform;
import Utils.Utility;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;

//Bullet hell game here (game box)
// ---- Suchas comment: I not sure if this is needed. My thought right now : no -----
public class GameplayEditor extends GraphicEditor{
    public GameplayEditor(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background

        create(new UISprite(Asset.UI.backgroundGameplay, new Transform(0, 0, 0.65, 0.5), -100));



        // DUMMY TEST
//        create(new GameEntity.Enemy.Chicken(new Utils.Transform(10,-60),20));


//        create(new GameEntity.Player.Player(new Utils.Transform(200,400),30));
    }


    @Override
    public void onUpdate() {
        if(InputUtility.isbPressed()) {
            if(SceneManager.currentState== SceneManager.GameState.normal){
                SceneManager.ActivatedBossPage(new BossPage(this.graphicsContext));
            }
            else{
                SceneManager.DeActivatedBossPage();
            }
            InputUtility.setbPressed(false);
        }

    }
}
