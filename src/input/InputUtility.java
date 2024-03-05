package input;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class InputUtility {
    private static boolean wPressed = false;
    private static boolean aPressed = false;
    private static boolean sPressed = false;
    private static boolean dPressed = false;

    public static boolean isWPressed() {
        return wPressed;
    }

    public static boolean isAPressed() {
        return aPressed;
    }

    public static boolean isSPressed() {
        return sPressed;
    }

    public static boolean isDPressed() {
        return dPressed;
    }

    public static void setKey(Canvas canvas) {
        canvas.requestFocus();
        canvas.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case W:
                    wPressed = true;
                    break;
                case A:
                    aPressed = true;
                    break;
                case S:
                    sPressed = true;
                    break;
                case D:
                    dPressed = true;
                    break;
                default:
                    break;
            }
        });

        canvas.setOnKeyReleased(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case W:
                    wPressed = false;
                    break;
                case A:
                    aPressed = false;
                    break;
                case S:
                    sPressed = false;
                    break;
                case D:
                    dPressed = false;
                    break;
                default:
                    break;
            }
        });
    }
}
