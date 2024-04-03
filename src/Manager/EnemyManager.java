package Manager;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.Enemy.BaseEnemy;
import GameEntity.Enemy.Chicken;
import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import Utils.*;

import Manager.BulletManager;
import java.util.ArrayList;
import java.util.Arrays;

public class EnemyManager implements Updatable {


    private static EnemyManager instance;
    private ArrayList<BaseEnemy> enemies;
    private ArrayList<Integer> ChickenPerks;
    private ArrayList<Integer> SheepPerks;
    private ArrayList<Integer> CowPerks;

    private long lastChickenSpawnTime;
    private long lastSheepSpawnTime;
    private long lastCowSpawnTime;


    private long chickenSpawnRate = 400;
    private long sheepSpawnRate = 800;
    private long cowSpawnRate = 1000;

    private EnemyManager() {
        enemies = new ArrayList<BaseEnemy>();
        //singleton , 10 is the starting part drop rate
        reset();

    }

    public static EnemyManager getInstance() {
        if (instance == null) {
            instance = new EnemyManager();
        }
        return instance;
    }


    public Transform randomTransform() {
        double x = (Math.random() * 640);
        double y = -60d;
        return new Transform(x, y, 0, 0.1, 0.1);
    }

    public void spawnEnemy(EnemyType type) {
        if(type == EnemyType.CHICKEN){
            BaseEnemy enemy = new Chicken(randomTransform(), Math.random());
            add(enemy);
        }
        else if(type == EnemyType.SHEEP){
            BaseEnemy enemy = new Sheep(randomTransform(), Math.random() + 10);
            add(enemy);
        }
        else if(type == EnemyType.COW){
            BaseEnemy enemy = new Cow(randomTransform(), Math.random() + 20);
            add(enemy);
        }

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


    public void clearEnemy() {
        for(BaseEnemy e : enemies){
            e.setDestroyed(true);
        }
        enemies.clear();
    }

    @Override
    public void onUpdate() {

        removeDestroyed();
        if(SceneManager.currentState== SceneManager.GameState.boss) return;
        if (System.currentTimeMillis() - lastChickenSpawnTime > EnemyUtils.calculateSpawnRate(ChickenPerks.get(7))) {
            spawnEnemy(EnemyType.CHICKEN);
            lastChickenSpawnTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - lastSheepSpawnTime > EnemyUtils.calculateSpawnRate(SheepPerks.get(7))) {
            spawnEnemy(EnemyType.SHEEP);
            lastSheepSpawnTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - lastCowSpawnTime > EnemyUtils.calculateSpawnRate(CowPerks.get(7))) {
            spawnEnemy(EnemyType.COW);
            lastCowSpawnTime = System.currentTimeMillis();
        }


    }


    public void reset(){
        ChickenPerks = new ArrayList<Integer>(Arrays.asList((int)Config.PARTS_DROP_BASE*Config.CHICKEN_MULTIPLIER, 0, 0, 0, 0, 0, 0, 0));
        SheepPerks = new ArrayList<Integer>(Arrays.asList((int)Config.PARTS_DROP_BASE, 0, 0, 0, 0, 0, 0, 0));
        CowPerks = new ArrayList<Integer>(Arrays.asList((int)Config.PARTS_DROP_BASE*Config.COW_MULTIPLIER, 0, 0, 0, 0, 0, 0, 0));
        clearEnemy();
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


    public long getLastChickenSpawnTime() {
        return lastChickenSpawnTime;
    }

    public void setLastChickenSpawnTime(long lastChickenSpawnTime) {
        this.lastChickenSpawnTime = lastChickenSpawnTime;
    }

    public long getLastSheepSpawnTime() {
        return lastSheepSpawnTime;
    }

    public void setLastSheepSpawnTime(long lastSheepSpawnTime) {
        this.lastSheepSpawnTime = lastSheepSpawnTime;
    }

    public long getLastCowSpawnTime() {
        return lastCowSpawnTime;
    }

    public void setLastCowSpawnTime(long lastCowSpawnTime) {
        this.lastCowSpawnTime = lastCowSpawnTime;
    }

    public long getChickenSpawnRate() {
        return chickenSpawnRate;
    }

    public void setChickenSpawnRate(long chickenSpawnRate) {
        this.chickenSpawnRate = chickenSpawnRate;
    }

    public long getSheepSpawnRate() {
        return sheepSpawnRate;
    }

    public void setSheepSpawnRate(long sheepSpawnRate) {
        this.sheepSpawnRate = sheepSpawnRate;
    }

    public long getCowSpawnRate() {
        return cowSpawnRate;
    }

    public void setCowSpawnRate(long cowSpawnRate) {
        this.cowSpawnRate = cowSpawnRate;
    }

}
