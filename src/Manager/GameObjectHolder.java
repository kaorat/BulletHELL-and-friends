package Manager;

import GameEntity.GameObject;
import Pane.GraphicEditor;
import Utils.Updatable;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// ---- Suchas comment: This is manager too-----
public class GameObjectHolder implements Updatable {
    private static final GameObjectHolder instance = new GameObjectHolder();
    private List<GameObject> entities;
    private Comparator<GameObject> comparator;

    public GameObjectHolder() {
        entities = new ArrayList<GameObject>();
        comparator = (GameObject o1, GameObject o2) -> {
            if (o1.getZ() > o2.getZ())
                return 1;
            return -1;
        };
    }

    public static GameObjectHolder getInstance() {
        return instance;
    }
    public void add(GameObject entity) {
//        System.out.println("add");
        entities.add(entity);
        entities.sort(comparator);
    }

    public void onUpdate() {
//        System.out.println(entities.size());
        for (int i = entities.size() - 1; i >= 0; i--) {
            if (entities.get(i).isDestroyed())
                entities.remove(i);
            else entities.get(i).onUpdate();
        }
    }

    public List<GameObject> getEntities() {
        return entities;
    }
}
