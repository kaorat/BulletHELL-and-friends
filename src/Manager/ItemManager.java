package Manager;

import GameEntity.GameObject;
import GameEntity.Item.BaseItem;
import Utils.Updatable;

import java.util.ArrayList;

public class ItemManager implements Updatable {

    private static ItemManager instance;
    private final ArrayList<BaseItem> items;

    private ItemManager() {
        items = new ArrayList<>();

    }

    public static ItemManager getInstance() {
        if (instance == null) {
            instance = new ItemManager();
        }
        return instance;
    }

    public void add(BaseItem item) {
        items.add(item);
        GameObjectHolder.getInstance().add(item);
    }

    public void removeDestroyed() {
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i).isDestroyed()) {
                items.remove(i);
            }
        }
    }

    public void activateAutoCollect() {
        for (int i = items.size() - 1; i >= 0; i--) {
            items.get(i).AutoCollect();
        }
    }

    @Override
    public void onUpdate() {
        removeDestroyed();
    }

    public void clearItems() {
        for (GameObject item : items) {
            item.setDestroyed(true);
        }
    }
}
