package Manager;

import java.util.ArrayList;

public class EnemyManager {

    private static EnemyManager instance;
    private ArrayList<Enemy> enemies;
    private EnemyManager() {
        enemies = new ArrayList<Enemy>();

        // what to do here??
    }

    public static EnemyManager getInstance() {
        if (instance == null) {
            instance = new EnemyManager();
        }
        return instance;
    }

    void checkCollision() {
        for (Enemy enemy : enemies) {
            if (enemy.isDestroyed()) {
                continue;
            }
            //collides ???
        }
    }

    public void spawnEnemy() {
        Enemy enemy = new Enemy();
        add(enemy);
    }

    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    public void update() {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (enemies.get(i).isDestroyed())
                enemies.remove(i);
        }
    }
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

}
