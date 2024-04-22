package Input;

public class MouseUtil {
    private static double mouseX;
    private static double mouseY;
    private static boolean isPressed;
    private static boolean activated;


    public static double getMouseX() {
        return mouseX;
    }

    public static void setMouseX(double mouseX) {
        MouseUtil.mouseX = mouseX;
    }

    public static double getMouseY() {
        return mouseY;
    }

    public static void setMouseY(double mouseY) {
        MouseUtil.mouseY = mouseY;
    }

    public static boolean isActivated() {
        return activated;
    }

    public static boolean isPressed() {
        return isPressed;
    }

    public static void setPressed(boolean pressed) {
        if (!pressed && isPressed) {
            activated = true;
        }
        isPressed = pressed;
    }

    public static void postUpdate() {
        activated = false;

    }

}
