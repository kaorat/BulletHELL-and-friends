package Manager;

import GameEntity.Enemy.BaseEnemy;
import GameEntity.Enemy.Chicken;
import GameEntity.Enemy.Cow;
import GameEntity.Enemy.Sheep;
import Utils.*;

import java.util.ArrayList;
import java.util.Arrays;

public class EnemyManager implements Updatable {


    private static EnemyManager instance;
    private final ArrayList<BaseEnemy> enemies;
    private ArrayList<Integer> ChickenPerks;
    private ArrayList<Integer> SheepPerks;
    private ArrayList<Integer> CowPerks;

    private long lastChickenSpawnTime;
    private long lastSheepSpawnTime;
    private long lastCowSpawnTime;

    private EnemyManager() {
        enemies = new ArrayList<>();
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
        double x = (Math.random() * 570);
        double y = -60d;
        return new Transform(x, y, 0, 0.3, 0.3);
    }

    public void spawnEnemy(EnemyType type) {
        if (type == EnemyType.CHICKEN && StatManager.getInstance().getEnemyUnlocked().get(2)) {
            add(new Chicken(randomTransform(), Math.random()));
        } else if (type == EnemyType.SHEEP) {
            add(new Sheep(randomTransform(), Math.random()));
        } else if (type == EnemyType.COW && StatManager.getInstance().getEnemyUnlocked().get(1)) {
            add(new Cow(randomTransform(), Math.random()));
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


    public void clearEnemy() {
        for (BaseEnemy e : enemies) {
            e.setDestroyed(true);
        }
        enemies.clear();
    }

    @Override
    public void onUpdate() {

        removeDestroyed();
        if (SceneManager.currentState == SceneManager.GameState.boss) return;
        int multiRespawnChance = StatManager.getInstance().getGobletLevels().get(3)-1;
        if (System.currentTimeMillis() - lastChickenSpawnTime > EnemyUtils.calculateSpawnRate(ChickenPerks.get(7))) {
            spawnEnemy(EnemyType.CHICKEN);
            if (multiRespawnChance * 10 > Math.random() * 100) {
                spawnEnemy(EnemyType.CHICKEN);
            }
            lastChickenSpawnTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - lastSheepSpawnTime > EnemyUtils.calculateSpawnRate(SheepPerks.get(7))) {
            spawnEnemy(EnemyType.SHEEP);
            if (multiRespawnChance * 10 > Math.random() * 100) {
                spawnEnemy(EnemyType.SHEEP);
            }
            lastSheepSpawnTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - lastCowSpawnTime > EnemyUtils.calculateSpawnRate(CowPerks.get(7))) {
            spawnEnemy(EnemyType.COW);
            if (multiRespawnChance * 10 > Math.random() * 100) {
                spawnEnemy(EnemyType.COW);
            }
            lastCowSpawnTime = System.currentTimeMillis();
        }


    }


    public void reset() {
        ChickenPerks = new ArrayList<>(Arrays.asList((int) Config.PARTS_DROP_BASE * Config.CHICKEN_MULTIPLIER, 0, 0, 0, 0, 0, 0, 0));
        SheepPerks = new ArrayList<>(Arrays.asList((int) Config.PARTS_DROP_BASE, 0, 0, 0, 0, 0, 0, 0));
        CowPerks = new ArrayList<>(Arrays.asList((int) Config.PARTS_DROP_BASE * Config.COW_MULTIPLIER, 0, 0, 0, 0, 0, 0, 0));
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

}
