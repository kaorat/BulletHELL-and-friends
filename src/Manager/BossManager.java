package Manager;

import GameEntity.Boss.BaseBoss;
import GameEntity.Boss.KaoBoss;
import Utils.Updatable;

public class BossManager implements Updatable {
    private static BossManager instance;
    private BaseBoss boss;

    public static BossManager getInstance() {
        if (instance == null) {
            instance = new BossManager();
        }
        return instance;
    }

    @Override
    public void onUpdate() {

    }

    public BaseBoss initBoss() {
        //TODO:Decide boss here
//        this.boss = new MichaelJackson();
        this.boss = new KaoBoss();
        GameObjectHolder.getInstance().add(this.boss);
        return this.boss;
    }

    public void removeBoss() {
        this.boss.setDestroyed(true);
        this.boss = null;
    }

    public BaseBoss getBoss() {
        return boss;
    }
}
