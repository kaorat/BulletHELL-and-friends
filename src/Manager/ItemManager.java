package Manager;

import GameEntity.Item.BaseItem;
import Utils.Updatable;

import java.util.ArrayList;

public class ItemManager implements Updatable {

    private static ItemManager instance;
    private ArrayList<BaseItem> items;

    private ItemManager() {
        items = new ArrayList<BaseItem>();

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
                StatManager.getInstance().addCoin();
            }
        }
    }


    @Override
    public void onUpdate() {
        removeDestroyed();
//        for(BaseItem item : items){
//            item.spawn();
//        }
        System.out.println(items.size());
    }
}
