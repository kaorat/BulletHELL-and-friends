package Utils;


import GameEntity.GameObject;
import Main.Main;
import Input.MouseUtil;
import javafx.scene.Cursor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static Input.InputUtility.*;

public class Utility {
    public static double getScreenX() {
        return 1080;
    }

    public static double getScreenY() {
        return 720;
    }

    public static double getGameScreenX() {
        return 640;
    }

    public static Font getGameFont(double size) {
        try {
            Font.loadFont(Utility.class.getResourceAsStream("/FONT/VeniteAdoremus-rgRBA.ttf"), size);
            return Font.font("Venite Adoremus", size);
        } catch (Exception e) {
            return Font.font("Arial", FontWeight.NORMAL, size);
        }
    }


    public static String numberToString(double i) {
        if (i >= Math.pow(10, 12)) {
            return BigDecimal.valueOf(i / Math.pow(10, 12)).setScale(2, RoundingMode.DOWN) + "T";
        }
        if (i >= Math.pow(10, 9)) {
            return BigDecimal.valueOf(i / Math.pow(10, 9)).setScale(2, RoundingMode.DOWN) + "B";
        }
        if (i >= Math.pow(10, 6)) {
            return BigDecimal.valueOf(i / Math.pow(10, 6)).setScale(2, RoundingMode.DOWN) + "M";
        }
        if (i > Math.pow(10, 3)) {
            return BigDecimal.valueOf(i / Math.pow(10, 3)).setScale(2, RoundingMode.DOWN) + "K";
        }
        return String.valueOf(i);
    }

    public static String numberToString(long i) {
        if (i >= Math.pow(10, 12)) {
            return BigDecimal.valueOf(i / Math.pow(10, 12)).setScale(2, RoundingMode.DOWN) + "T";
        }
        if (i >= Math.pow(10, 9)) {
            return BigDecimal.valueOf(i / Math.pow(10, 9)).setScale(2, RoundingMode.DOWN) + "B";
        }
        if (i >= Math.pow(10, 6)) {
            return BigDecimal.valueOf(i / Math.pow(10, 6)).setScale(2, RoundingMode.DOWN) + "M";
        }
        if (i > Math.pow(10, 3)) {
            return BigDecimal.valueOf(i / Math.pow(10, 3)).setScale(2, RoundingMode.DOWN) + "K";
        }
        return String.valueOf(i);
    }

    public static void controlUtility(Transform transform, double speed) {

        if (isWPressed() && isDPressed()) { // Move up-right
            transform.setRot(-45);
            transform.translate(speed);
        } else if (isWPressed() && isAPressed()) { // Move up-left
            transform.setRot(-135);
            transform.translate(speed);
        } else if (isSPressed() && isDPressed()) { // Move down-right
            transform.setRot(45);
            transform.translate(speed);
        } else if (isSPressed() && isAPressed()) { // Move down-left
            transform.setRot(135);
            transform.translate(speed);
        } else if (isSPressed()) { // Move down
            transform.setRot(90);
            transform.translate(speed);
        } else if (isWPressed()) { // Move up
            transform.setRot(-90);
            transform.translate(speed);
        } else if (isAPressed()) { // Move left
            transform.setRot(180);
            transform.translate(speed);
        } else if (isDPressed()) { // Move right
            transform.setRot(0);
            transform.translate(speed);
        }
    }

    public static void isOutOfBounds(GameObject gameObject) {
        if (gameObject.getTransform().getPosY() < -20 || gameObject.getTransform().getPosY() > getScreenY() + 20 || gameObject.getTransform().getPosX() < -20 || gameObject.getTransform().getPosX() > getGameScreenX() + 20) { // lower than the screen
            gameObject.setDestroyed(true);
        }
    }

    public static void drawImage(GraphicsContext gc, Image sprite, Transform transform) {
        gc.drawImage(sprite, transform.getPosX(), transform.getPosY(), sprite.getWidth() * transform.getSclX(), sprite.getHeight() * transform.getSclY());
    }

    public static boolean checkHover(Transform transform, Image image) {
        boolean hover = MouseUtil.getMouseX() > transform.getPosX() && MouseUtil.getMouseX() < transform.getPosX()
                + image.getWidth() * transform.getSclX() && MouseUtil.getMouseY() > transform.getPosY() &&
                MouseUtil.getMouseY() < transform.getPosY() + image.getHeight() * transform.getSclY();
        if (hover) {
            Main.getScene().setCursor(Cursor.cursor("HAND"));
        }
        return hover;
    }
}
