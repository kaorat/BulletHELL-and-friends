package Utils;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.File;

import static input.InputUtility.*;

public class Utility {
    public static double getScreenX(){
        return 1080;
    }
    public static double getScreenY(){
        return 720;
    }
    public static double getGameScreenX(){
        return 640;
    }
    public static Font getGameFont(double size) {
        try {
            Font.loadFont(Utility.class.getResourceAsStream("/FONT/Valorax-lg25V.otf"), size);
            return Font.font("valorax", size);
        } catch (Exception e) {
            e.printStackTrace();
            return Font.font("Arial", FontWeight.NORMAL, size);
        }
    }


    public static String NumberToString(double i){
        if(i>=Math.pow(10,12)) {
            return (i / Math.pow(10, 12)) +"T";
        }
        if(i>=Math.pow(10,9)) {
            return (i / Math.pow(10, 9)) +"B";
        }
        if(i>=Math.pow(10,6)) {
            return (i / Math.pow(10, 6)) +"M";
        }
        if(i>Math.pow(10,3)) {
            return (i / Math.pow(10, 3)) +"K";
        }
        return String.valueOf(i);
    }
    public static String NumberToString(long i){
        if(i>=Math.pow(10,12)) {
            return (i / Math.pow(10, 12)) +"T";
        }
        if(i>=Math.pow(10,9)) {
            return (i / Math.pow(10, 9)) +"B";
        }
        if(i>=Math.pow(10,6)) {
            return (i / Math.pow(10, 6)) +"M";
        }
        if(i>Math.pow(10,3)) {
            return (i / Math.pow(10, 3)) +"K";
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
}
