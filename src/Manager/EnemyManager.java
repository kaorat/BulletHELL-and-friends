package Manager;

import GameEntity.Enemy.BaseEnemy;
import GameEntity.Enemy.Chicken;
import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import Utils.*;

import java.util.ArrayList;
import java.util.Arrays;

public class EnemyManager implements Upgradable, Updatable {

    private static EnemyManager instance;
    private ArrayList<BaseEnemy> enemies;
    private ArrayList<Integer> ChickenPerks;
    private ArrayList<Integer> SheepPerks;
    private ArrayList<Integer> CowPerks;

    private EnemyManager() {
        enemies = new ArrayList<BaseEnemy>();
        //singleton , 25 is the starting part drop rate
        ChickenPerks = new ArrayList<Integer>(Arrays.asList((int)Config.PARTS_DROP_BASE*Config.CHICKEN_MULTIPLIER, 1, 1, 1, 1, 1, 1, 1));
        SheepPerks = new ArrayList<Integer>(Arrays.asList((int)Config.PARTS_DROP_BASE, 1, 1, 1, 1, 1, 1, 1));
        CowPerks = new ArrayList<Integer>(Arrays.asList((int)Config.PARTS_DROP_BASE*Config.COW_MULTIPLIER, 1, 1, 1, 1, 1, 1, 1));

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

    public Transform randomTransform() {
        double x = (Math.random() * 640);
        double y = -60d;
        return new Transform(x, y, 0, 2, 2);
    }

    public void spawnEnemy(EnemyType type) {
        if(type == EnemyType.CHICKEN){
            BaseEnemy enemy = new Chicken(randomTransform(), 0);
            add(enemy);
        }
        else if(type == EnemyType.SHEEP){
            BaseEnemy enemy = new Sheep(randomTransform(), 0);
            add(enemy);
        }
        else if(type == EnemyType.COW){
            BaseEnemy enemy = new Cow(randomTransform(), 0);
            add(enemy);
        }

    }

    public boolean checkEnemyLeft(){
        return enemies.size() < 3;
    }

    public void add(BaseEnemy enemy) {
        enemies.add(enemy);
        GameObjectHolder.getInstance().add(enemy);
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
            ChickenPerks.set(0, (int) (ChickenPerks.get(0) + Config.enemy_dropUpgradeValues.get(index)));
        }
        else if(type == EnemyType.SHEEP){
            SheepPerks.set(index, SheepPerks.get(index) + 1);
            SheepPerks.set(0, (int) (SheepPerks.get(0) + Config.enemy_dropUpgradeValues.get(index)));
        }
        else if(type == EnemyType.COW){
            CowPerks.set(index, CowPerks.get(index) + 1);
            CowPerks.set(0, (int) (CowPerks.get(0) + Config.enemy_dropUpgradeValues.get(index)));
        }

    }

    public double calculatePerkValue(EnemyType type, int index){
        if(type == EnemyType.CHICKEN){
            return Config.enemy_baseValues.get(index) + (ChickenPerks.get(index) * Config.enemy_upgradeValues.get(index));
        }
        else if(type == EnemyType.SHEEP){
            return Config.enemy_baseValues.get(index) + (SheepPerks.get(index) * Config.enemy_upgradeValues.get(index));
        }
        else if(type == EnemyType.COW){
            return Config.enemy_baseValues.get(index) + (CowPerks.get(index) * Config.enemy_upgradeValues.get(index));
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

    @Override
    public void upgradeLevel() {
        //TODO: implement this
    }

    @Override
    public void clearLevel() {
        //TODO: implement this
    }

    @Override
    public void onUpdate() {
        
    }
}
