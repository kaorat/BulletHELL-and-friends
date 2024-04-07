package Manager;

import GameEntity.Bullet.BaseBullet;
import GameEntity.GameObject;
import Utils.Updatable;

import java.util.ArrayList;

public class BulletManager implements Updatable {

    private static BulletManager instance;

    private final ArrayList<BaseBullet> bullets;

    private BulletManager() {
        bullets = new ArrayList<>();
    }

    public static BulletManager getInstance() {
        if (instance == null) {
            instance = new BulletManager();
        }
        return instance;
    }

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
        for(GameObject bullet : bullets){
            bullet.setDestroyed(true);
        }
    }

    public ArrayList<BaseBullet> getBullets() {
        return bullets;
    }

    @Override
    public void onUpdate() {
        removeDestroyed();
    }
}
