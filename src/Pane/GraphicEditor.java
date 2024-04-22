package Pane;

import GameEntity.GameObject;
import Manager.GameObjectHolder;
import Utils.Updatable;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class GraphicEditor implements Updatable {
    protected GraphicsContext graphicsContext;
    protected ArrayList<GameObject> Monitored_Object;

    public GraphicEditor(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        Monitored_Object = new ArrayList<>();
    }

    public GameObject create(GameObject gameObject) {
        GameObjectHolder.getInstance().add(gameObject);
        Monitored_Object.add(gameObject);
        return gameObject;
    }

    public void clear() {
        for (GameObject gameObject : Monitored_Object) {
            gameObject.setDestroyed(true);
        }
        Monitored_Object.clear();
    }
}
