package GameEntity;

import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    protected Transform transform;
    protected int z;
    protected boolean visible,destroyed;
    public GameObject(Transform transform,int z) {
        this.transform=transform;
        this.z = z;
        this.visible = true;
        this.destroyed = false;
    }
    public void setZ(int z) {
        this.z = z;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getZ(){
        return z;
    }
    public abstract void draw(GraphicsContext gc);
    public boolean isDestroyed(){
        return destroyed;
    }
    public boolean isVisible(){
        return visible;
    }
    public abstract void onUpdate();

}
