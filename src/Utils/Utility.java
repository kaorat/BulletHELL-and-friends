package Utils;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
    public static Font getGameFont(double size){
        return Font.font("Arial", FontWeight.MEDIUM,size);
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
}
