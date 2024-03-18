package Utils;

import javafx.scene.image.Image;

public class Asset {
    public static class UI{
        public static Image background;
        public static Image skull;
        static{
            loadResource();
        }

        private static void loadResource() {
            background=new Image(ClassLoader.getSystemResource("UI/Q86S4e.png").toString());
           skull=new Image(ClassLoader.getSystemResource("UI/skull (1).png").toString());
        }
    }
}
