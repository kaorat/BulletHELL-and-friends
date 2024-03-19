package Pane;

import javafx.scene.canvas.GraphicsContext;

//Bullet hell game here (game box)
// ---- Suchas comment: I not sure if this is needed. My thought right now : no -----
public class GameplayEditor extends GraphicEditor{
    public GameplayEditor(GraphicsContext graphicsContext) {
        super(graphicsContext);
        // DUMMY TEST
        create(new GameEntity.Enemy.Chicken(new Utils.Transform(10,-60),20));


        create(new GameEntity.Player.Player(new Utils.Transform(200,400),30));
    }

    @Override
    public void clear() {

    }

    @Override
    public void onUpdate() {

    }
}
