package GameEntity.Boss;

import GameEntity.GameObject;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseBoss extends GameObject {
    protected int hp;
    protected int fireRate;
    protected int bulletSpeed;
    protected int bulletLength;

//    boss should drop sth????

    public BaseBoss(int hp,int fireRate,int bulletSpeed,int bulletLength){
        this.hp = hp;
        this.fireRate = fireRate;
        this.bulletSpeed = bulletSpeed;
        this.bulletLength = bulletLength;
    }
//    to set firing pattern for each boss
    public abstract void StartFiring();
    public abstract void firing();

    @Override
    public void onUpdate() {

    }

    @Override
    public void draw(GraphicsContext gc) {

    }
}
