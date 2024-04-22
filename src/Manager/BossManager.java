package Manager;

import GameEntity.Boss.BaseBoss;
import GameEntity.Boss.DragonKing;
import GameEntity.Boss.KaoBoss;
import GameEntity.Boss.MichaelJackson;
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
        switch (StatManager.getInstance().getBossDefeated()){
            case 0:{
                this.boss = new KaoBoss();
                break;
            }
            case 1:{
                this.boss = new MichaelJackson();
                break;
            }
            case 2:{
                this.boss = new DragonKing();
                break;
            }
            case 3:{
                GameObjectHolder.getInstance().add(new KaoBoss());
                GameObjectHolder.getInstance().add(new MichaelJackson());
                this.boss = new DragonKing();
                break;
            }
        }

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
