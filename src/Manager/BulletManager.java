package Manager;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import Utils.Asset;

import java.util.ArrayList;

public class BulletManager {

    private static BulletManager instance;

    private ArrayList<BaseBullet> bullets;

    private BulletManager() {
        bullets = new ArrayList<BaseBullet>();
    }

    public static BulletManager getInstance() {
        if (instance == null) {
            instance = new BulletManager();
        }
        return instance;
    }

//    public void shoot() {
//        PlayerBullet bullet = new PlayerBullet(10, null, null, 0);
//        add(bullet);
//    }

    public void add(BaseBullet bullet) {
        bullets.add(bullet);
        GameObjectHolder.getInstance().add(bullet);
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

    public ArrayList<BaseBullet> getBullets() {
        return bullets;
    }
}
