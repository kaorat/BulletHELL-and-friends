package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Transform;

public class BossBullet extends BaseBullet{

    public BossBullet(double damage, GameObject owner, Transform transform, int z) {
        super(damage, owner,transform,z);
    }

}
