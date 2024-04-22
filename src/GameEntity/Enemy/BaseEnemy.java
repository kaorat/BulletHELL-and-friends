package GameEntity.Enemy;

import GameEntity.Bullet.BaseBullet;
import GameEntity.Bullet.PlayerBullet;
import GameEntity.GameObject;
import GameEntity.Item.Soul;
import Manager.BulletManager;
import Manager.ItemManager;
import Manager.StatManager;
import Utils.EnemyType;
import Utils.EnemyUtils;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class BaseEnemy extends GameObject {

    protected long partDrop;
    protected double hp;
    protected double fireRate;
    protected double bulletSpeed;
    protected int bulletQuantity;
    protected int bulletLength;
    protected double soulChance;
    protected ArrayList<Integer> perks; // stores level of each perk

    protected double uptime;
    protected double downtime;
    protected double shootTime;
    protected States state;

    public BaseEnemy(Transform transform, double z) {
        super(transform, z);

        this.fireRate = 700;
        this.partDrop = 11;
        state = States.DOWN;
        downtime = Math.random() * 1000 + 1400;
        uptime = downtime;
        shootTime = Math.random() * 3000 + 5000;

    }

    public abstract void firing();

    public abstract void action();

    public void applyStat(EnemyType type) {
        this.partDrop = perks.get(0);
        this.hp = EnemyUtils.calculateStat(type, 1, perks.get(1));
        this.fireRate = EnemyUtils.calculateStat(type, 2, perks.get(2));
        this.bulletSpeed = EnemyUtils.calculateStat(type, 3, perks.get(3));
        this.bulletQuantity = (int) EnemyUtils.calculateStat(type, 4, perks.get(4));
        this.bulletLength = (int) EnemyUtils.calculateStat(type, 5, perks.get(5));
        this.soulChance = EnemyUtils.calculateStat(type, 6, perks.get(6))*StatManager.getInstance().getGobletLevels().get(4);
    }

    public void drawHpBar(GraphicsContext gc, EnemyType type) {
        //TODO
//        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);
        gc.fillRect(transform.getPosX(), transform.getPosY() - 7, (this.hp / EnemyUtils.calculateStat(type, 1, perks.get(1))) * 80, 5); // hard coded (image width varies)


    }

    @Override
    public void onUpdate() { //from animationTimer
        action();
        //bullet collision
        BulletManager bm = BulletManager.getInstance();
        ArrayList<BaseBullet> bulletList = bm.getBullets();
        if (this.hp <= 0) {
            EnemyUtils.dropParts(transform.getPosX(), transform.getPosY(), partDrop);
            if(Math.random() * 100 <= soulChance){
                ItemManager.getInstance().add(new Soul(transform.getPosX(), transform.getPosY()));
            }
            this.setDestroyed(true);
            StatManager.getInstance().addKilled();
        }
        for (BaseBullet bullet : bulletList) {
            if (Transform.checkCollide(this.getBounds(), bullet.getBounds()) && bullet instanceof PlayerBullet) {
                this.hp -= ((PlayerBullet) bullet).getDamage();
                bullet.setDestroyed(true);
            }
        }

    }

    protected enum States {
        UP,
        DOWN,
        SHOOT
    }

}
