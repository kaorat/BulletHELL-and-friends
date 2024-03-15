package Manager;

import GameEntity.Bullet.BaseBullet;

import java.util.ArrayList;

public class BulletManager {

    private static BulletManager instance;

    private ArrayList<BaseBullet> bullets;

    private BulletManager() {
        bullets = new ArrayList<BaseBullet>();
    }

    private static BulletManager getInstance() {
        if (instance == null) {
            instance = new BulletManager();
        }
        return instance;
    }

    public void add(BaseBullet bullet) {
        bullets.add(bullet);
    }

    public void removeDestroyed() {
        for (int i = bullets.size() - 1; i >= 0; i--) {
            if (bullets.get(i).isDestroyed())
                bullets.remove(i);
        }
    }

    public void clearBullets() {
        bullets.clear();
    }

}
