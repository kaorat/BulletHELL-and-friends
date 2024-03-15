package GameEntity;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class GameObject {

    protected double posX,posY,rotX,rotY,sclX,sclY,tslX,tslY;
    protected int z;
    protected boolean visible,destroyed;

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
