package GameEntity;

import Utils.Transform;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class GameObject {
    protected Transform transform;
    protected double z;
    protected Image image;
    protected Bounds bounds;
    protected boolean visible, destroyed;
    public GameObject(Transform transform, double z) {
        this.transform = transform;
        this.z = z;
        this.visible = true;
        this.destroyed = false;
        this.image = null;

    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public void drawBounds(double offsetW, double offsetH, double scaleX, double scaleY) {
        this.bounds = new BoundingBox(transform.getPosX() + (offsetW * image.getWidth() * transform.getSclX()), transform.getPosY() + (offsetH * image.getHeight() * transform.getSclY()), image.getWidth() * transform.getSclX() * scaleX, image.getHeight() * transform.getSclY() * scaleY);
    }

    public void drawBounds(double offsetW, double offsetH) {
        this.bounds = new BoundingBox(transform.getPosX() + offsetW, transform.getPosY() + offsetH, image.getWidth() * transform.getSclX(), image.getHeight() * transform.getSclY());
    }

    public Bounds getBounds() {
        if (bounds == null)
            return new BoundingBox(0, 0, 0, 0);
        return bounds;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public abstract void draw(GraphicsContext gc);

    public abstract void onUpdate();

}
