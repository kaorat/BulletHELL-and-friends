package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Transform;

public class EnemyBullet extends BaseBullet{

    public EnemyBullet(double damage, GameObject owner, Transform transform, int z) {
        super(damage, owner,transform,z);
    }


}
