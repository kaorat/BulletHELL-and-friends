package Utils;

public class MouseUtil {
    private static double mouseX;
    private static double mouseY;
    private static boolean isPressed;
    private static boolean isPressedTriggered;



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

    public static void setPressed(boolean pressed) {
        isPressed = pressed;
        isPressedTriggered = pressed;
    }

    public static boolean isPressed() {
        return isPressedTriggered;
    }

    public static void postUpdate() {
        isPressedTriggered = false;

    }

}
