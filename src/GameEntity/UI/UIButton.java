package GameEntity.UI;

import input.MouseUtil;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class UIButton extends UISprite {
    private boolean pressed;
    private boolean hovered;
    private boolean enabled;
    private Runnable onClickHandler;
    private int clickCount = 0;


    public UIButton(Image sprite, Transform transform, int z) {
        super(sprite, transform, z);
        this.pressed = false;
        this.hovered = false;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isHovered() {
        return hovered;
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    @Override
    public void draw(GraphicsContext gc) {

        // Add button-specific drawing logic here, such as highlighting when hovered or pressed
        if(!enabled){
            //Not enough money
        }
        else{
            if (pressed) {
                // Draw hover effect
            }
            else if (hovered) {
                // Draw pressed effect
            }
            else{
                //Normal
            }
        }

        super.draw(gc);
    }

    @Override
    public void onUpdate() {
        hovered = MouseUtil.getMouseX() > getTransform().getPosX() && MouseUtil.getMouseX() < getTransform().getPosX()
                + getSprite().getWidth() * getTransform().getSclX() && MouseUtil.getMouseY() > getTransform().getPosY() &&
                MouseUtil.getMouseY() < getTransform().getPosY() + getSprite().getHeight() * getTransform().getSclY();
        pressed = MouseUtil.isActivated() && hovered;
        if(pressed) {
            clickCount++;
        }
//        System.out.println(clickCount);
    }

    public void setEnable(boolean enable) {
        this.enabled=enabled;
    }
    public boolean isEnables(){
        return enabled;
    }

}
