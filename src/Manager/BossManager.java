package Manager;

import GameEntity.Boss.BaseBoss;
import Utils.Updatable;

public class BossManager implements Updatable {
    private static BossManager instance;


    public static BossManager getInstance() {
        if (instance == null){
            instance = new BossManager();
        }
        return instance;
    }

    @Override
    public void onUpdate() {

    }
}
