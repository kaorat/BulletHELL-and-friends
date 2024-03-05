package Manager;

import GameEntity.Enemy.BaseEnemy;
import Utils.Config;
import Utils.EnemyType;

import java.util.ArrayList;

public class EnemyManager {

    private static EnemyManager instance;
    private ArrayList<BaseEnemy> enemies;
    private ArrayList<Integer> ChickenPerks;
    private ArrayList<Integer> SheepPerks;
    private ArrayList<Integer> CowPerks;

    private EnemyManager() {
        enemies = new ArrayList<BaseEnemy>();
        ChickenPerks = new ArrayList<Integer>();
        SheepPerks = new ArrayList<Integer>();
        CowPerks = new ArrayList<Integer>();
        //singleton
        for(int i = 0; i < 8; i++){
            ChickenPerks.add(0);
            SheepPerks.add(0);
            CowPerks.add(0);
        }

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

    public void upgradePerks(EnemyType type, int index){ //index 0-7
        if(type == EnemyType.CHICKEN){
            ChickenPerks.set(index, ChickenPerks.get(index) + 1);
        }
        else if(type == EnemyType.SHEEP){
            SheepPerks.set(index, SheepPerks.get(index) + 1);
        }
        else if(type == EnemyType.COW){
            CowPerks.set(index, CowPerks.get(index) + 1);
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
