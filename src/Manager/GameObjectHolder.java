package Manager;

import GameEntity.GameObject;
import Utils.Updatable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameObjectHolder implements Updatable {
    private static GameObjectHolder instance;
    private final List<GameObject> entities;
    private final Comparator<GameObject> comparator;
    public GameObjectHolder() {
        entities = new ArrayList<>();
        comparator = (GameObject o1, GameObject o2) -> {
            if (o1.getZ() > o2.getZ())
                return 1;
            return -1;
        };
    }
    public static GameObjectHolder getInstance() {
        if (instance == null) {
            instance = new GameObjectHolder();
        }
        return instance;
    }
    public void add(GameObject entity) {
        entities.add(entity);
        entities.sort(comparator);
    }
    public void onUpdate() {
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
