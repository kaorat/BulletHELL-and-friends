package Utils;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.File;

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
//Add classloader
        Font customFont = Font.loadFont(new File("src/Font/Valorax-lg25V.otf").toURI().toString(), size);
//        Font customFont = Font.loadFont(new File("FONT/Valorax-lg25V.otf").toURI().toString(), size);
//        return Font.font(customFont.getFamily(), FontWeight.MEDIUM,size);
        return Font.font("Times New Roman", FontWeight.MEDIUM,size);

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
