package Manager;

import GameEntity.Enemy.BaseEnemy;
import Utils.Config;
import Utils.EnemyType;

import java.util.ArrayList;
import java.util.Arrays;

public class EnemyManager {

    private static EnemyManager instance;
    private ArrayList<BaseEnemy> enemies;
    private ArrayList<Integer> ChickenPerks;
    private ArrayList<Integer> SheepPerks;
    private ArrayList<Integer> CowPerks;

    private EnemyManager() {
        enemies = new ArrayList<BaseEnemy>();
        //singleton , 25 is the starting part drop rate
        ChickenPerks = new ArrayList<Integer>(Arrays.asList(25, 0, 0, 0, 0, 0, 0, 0));
        SheepPerks = new ArrayList<Integer>(Arrays.asList(25, 0, 0, 0, 0, 0, 0, 0));
        CowPerks = new ArrayList<Integer>(Arrays.asList(25, 0, 0, 0, 0, 0, 0, 0));

    }

    public static EnemyManager getInstance() {
        if (instance == null) {
            instance = new EnemyManager();
        }
        return instance;
    }

//    public void checkCollision() {
//        for (BaseEnemy enemy : enemies) {
//            if (enemy.isDestroyed()) {
//                continue;
//            }
//            //collides ???
//        }
//    }

    public void spawnEnemy(BaseEnemy e) {
        add(e); // might be redundant.
    }

    public void add(BaseEnemy enemy) {
        enemies.add(enemy);
    }

    public void removeDestroyed() {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (enemies.get(i).isDestroyed())
                enemies.remove(i);
        }
    }

    // parts drop is still messed up!!!!
    // 0 is the drop rate, 1-7 are the perks

    public void upgradePerks(EnemyType type, int index){ //index should be between 1-7
        if(index == 0) return;
        if(type == EnemyType.CHICKEN){
            ChickenPerks.set(index, ChickenPerks.get(index) + 1);
            ChickenPerks.set(0, (int) (ChickenPerks.get(0) + Config.dropUpgradeValues.get(index)));
        }
        else if(type == EnemyType.SHEEP){
            SheepPerks.set(index, SheepPerks.get(index) + 1);
            SheepPerks.set(0, (int) (SheepPerks.get(0) + Config.dropUpgradeValues.get(index)));
        }
        else if(type == EnemyType.COW){
            CowPerks.set(index, CowPerks.get(index) + 1);
            CowPerks.set(0, (int) (CowPerks.get(0) + Config.dropUpgradeValues.get(index)));
        }

    }

    public double calculatePerkValue(EnemyType type, int index){
        if(type == EnemyType.CHICKEN){
            return Config.baseValues.get(index) + (ChickenPerks.get(index) * Config.upgradeValues.get(index));
        }
        else if(type == EnemyType.SHEEP){
            return Config.baseValues.get(index) + (SheepPerks.get(index) * Config.upgradeValues.get(index));
        }
        else if(type == EnemyType.COW){
            return Config.baseValues.get(index) + (CowPerks.get(index) * Config.upgradeValues.get(index));
        }
        return 0;
    }

    public void clearEnemy() {
        enemies.clear();
    }

    public ArrayList<BaseEnemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Integer> getChickenPerks() {
        return ChickenPerks;
    }

    public ArrayList<Integer> getSheepPerks() {
        return SheepPerks;
    }

    public ArrayList<Integer> getCowPerks() {
        return CowPerks;
    }
}
