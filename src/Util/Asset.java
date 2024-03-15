package Util;

import javafx.scene.image.Image;

public class Asset {
    public static class UI{
        public static Image background;
        static{
            loadResource();
        }

        private static void loadResource() {
            background=new Image(ClassLoader.getSystemResource("UI/Q86S4e.png").toString());
        }
    }
}
