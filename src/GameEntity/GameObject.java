package GameEntity;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class GameObject {

    protected double posX,posY,rotX,rotY,sclX,sclY;
    protected int z;
    protected boolean visible,destroyed;
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
