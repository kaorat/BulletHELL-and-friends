package Manager;

import GameEntity.Boss.BaseBoss;
import Utils.Updatable;

public class BossManager implements Updatable {
    private static BossManager instance;
    private BaseBoss boss;


    public static BossManager getInstance() {
        if (instance == null){
            instance = new BossManager();
        }
        return instance;
    }

    @Override
    public void onUpdate() {

    }

    public void spawnBoss(BaseBoss boss){
        this.boss = boss;
        GameObjectHolder.getInstance().add(boss);
    }

    public void removeBoss(){
        this.boss.setDestroyed(true);
        this.boss = null;
    }

    public BaseBoss getBoss(){
        return boss;
    }

    public boolean isBossSpawned(){
        return boss != null;
    }




}
