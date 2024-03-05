package Manager;

import GameEntity.Enemy.BaseEnemy;
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

        // what to do here??
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

    public void upgradePerks(EnemyType type, int index){
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

    public void clearEnemy() {
        enemies.clear();
    }

    public ArrayList<BaseEnemy> getEnemies() {
        return enemies;
    }

}
