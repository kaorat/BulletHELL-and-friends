package Manager;

import GameEntity.Boss.BaseBoss;

public class BossManager {
    private static BossManager instance;


    public static BossManager getInstance() {
        if (instance == null){
            instance = new BossManager();
        }
        return instance;
    }
// idk what to do lol
}
