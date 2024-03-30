package GameEntity.Bullet;

import GameEntity.GameObject;
import Utils.Asset;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

// ---- !Suchas comment: This ought to be abstract (Fixed)-----
public abstract class BaseBullet extends GameObject {

    protected double damage; // ---- !Suchas comment: damage is only for player's bullet, no? (Enemy bullet one-shot you)----- Gannub -> please no, Suchas.
    protected GameObject owner; // ---- !Suchas comment: Unnecessary? or have a plan? if so, please inform -----

    public BaseBullet(double damage, GameObject owner, Transform transform, double z) {
        super(transform,z);
        this.damage = damage;
        this.owner = owner;
    }

    public void removeOutOfBounds() {
        //idk
        // ---- !Suchas comment: Correct -----
        if(this.transform.getPosY() < 0 || this.transform.getPosY() > 760 || this.transform.getPosX() < 0 || this.transform.getPosX() > 800) {
            destroyed = true;
        }
    }
    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public GameObject getOwner() {
        return owner;
    }

    public void setOwner(GameObject owner) {
        this.owner = owner;
    }
}
