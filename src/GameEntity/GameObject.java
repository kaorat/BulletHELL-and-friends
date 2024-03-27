package GameEntity;

import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class GameObject {
    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    protected Transform transform;
    protected int z;
    protected boolean visible,destroyed;
    protected ArrayList<GameObject> childrenNode;
    public GameObject(Transform transform,int z) {
        this.transform=transform;
        this.z = z;
        this.visible = true;
        this.destroyed = false;
    }

    public void addChildrenNode(GameObject childNode){
        this.childrenNode.add(childNode);
    }
    public void removeChildrenNode(GameObject childNode){
        this.childrenNode.remove(childNode);
    }
    public void clearChildrenNode(){
        this.childrenNode.clear();
    }
    public GameObject getChildrenNode(int index){
        return this.childrenNode.get(index);
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

    public boolean isDestroyed(){
        return destroyed;
    }

    public boolean isVisible(){
        return visible;
    }

    public abstract void draw(GraphicsContext gc);

    public abstract void onUpdate();

}
