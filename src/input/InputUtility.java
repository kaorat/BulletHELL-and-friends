package input;

import Manager.SceneManager;
import Pane.Page.BossPage;
import Pane.RootPane;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class InputUtility {
    private static boolean wPressed = false;
    private static boolean aPressed = false;
    private static boolean sPressed = false;
    private static boolean dPressed = false;
    private static boolean shiftPressed = false;
    private static boolean slashPressed = false;
    private static boolean bPressed = false;

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
    public static boolean isShiftPressed() {
        return shiftPressed;
    }
    public static boolean isSlashPressed() {
        return slashPressed;
    }

    public static boolean isbPressed() { return bPressed; }

    public static void setbPressed(boolean bPressed) { InputUtility.bPressed = bPressed; }

    public static void setKey(Scene canvas) {
//        canvas.requestFocus();

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
                case SHIFT:
                    shiftPressed = true;
                    break;
                case SLASH:
                    slashPressed = true;
                    break;
                case B:
                    bPressed = true;
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
                case SHIFT:
                    shiftPressed = false;
                    break;
                case SLASH:
                    slashPressed = false;
                    break;
                case B:
                    bPressed = false;
                    break;
                default:
                    break;
            }
        });
    }
}
