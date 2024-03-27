package GameEntity;

import Utils.Transform;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

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

    protected Image image;
    protected Bounds bounds;
    protected boolean visible,destroyed;
    protected ArrayList<GameObject> childrenNode;

    public void drawBounds(double offsetW, double offsetH, double width, double height){
        this.bounds = new BoundingBox(transform.getPosX() + offsetW,transform.getPosY() + offsetH, width, height);
    }
    public Bounds getBounds(){
        if(bounds == null)
            return new BoundingBox(0,0,0,0);
        return bounds;
    }

    public GameObject(Transform transform,int z) {
        this.transform=transform;
        this.z = z;
        this.visible = true;
        this.destroyed = false;
        this.image = null;

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

    public void setImage(Image image){ this.image = image;}
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getZ(){
        return z;
    }

    public Image getImage() { return image; }

    public boolean isDestroyed(){
        return destroyed;
    }

    public boolean isVisible(){
        return visible;
    }

    public abstract void draw(GraphicsContext gc);

    public abstract void onUpdate();

}
