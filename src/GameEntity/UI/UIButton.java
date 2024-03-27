package GameEntity.UI;

import Utils.Text;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class UIButton extends UISprite {
    private boolean pressed;
    private boolean hovered;
    private Runnable onClickHandler;

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
        super.draw(gc);
        // Add button-specific drawing logic here, such as highlighting when hovered or pressed
        if (hovered) {
            // Draw hover effect
        }
        if (pressed) {
            // Draw pressed effect
        }
    }

    @Override
    public void onUpdate() {
        // Add button-specific update logic here, if needed
    }
}
