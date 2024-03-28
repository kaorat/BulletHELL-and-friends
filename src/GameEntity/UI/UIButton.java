package GameEntity.UI;

import Utils.Asset;
import Utils.ButtonType;
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
    private ButtonType buttonType;


    public UIButton(Image sprite, Transform transform, int z , ButtonType buttonType) {
        super(sprite, transform, z);
        this.pressed = false;
        this.hovered = false;
        this.enabled = true;
        this.buttonType = buttonType;
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
    public void draw(GraphicsContext gc ) {

        // Add button-specific drawing logic here, such as highlighting when hovered or pressed
        if(!enabled){
            //Not enough money
            setSprite(Asset.UI.upgradeButtonNoMoney);


        }
        else{
            if (pressed) {
                // Draw pressed effect

            }
            else if (hovered) {
                // Draw  hover
                if(buttonType == ButtonType.UPGRADE){
                    setSprite(Asset.UI.upgradeButtonHover);
                    System.out.println(getTransform().getSclX());
                }
                else if(buttonType == ButtonType.NAVIGATOR){
//                    setSprite();
                }

            }
            else{
                //Normal
                if(buttonType == ButtonType.UPGRADE){
                    setSprite(Asset.UI.upgradeButton);
                }
                else if(buttonType == ButtonType.NAVIGATOR){

                }

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
//        System.out.println(clickCount);
    }

    public void setEnable(boolean enable) {
        this.enabled=enabled;
    }
    public boolean isEnables(){
        return enabled;
    }

}
