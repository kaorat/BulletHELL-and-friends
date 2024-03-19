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

    public static class Game{
        public static Image player;
        public static Image bullet;
        public static Image enemyBullet;
        public static Image enemy;
        static{
            loadResource();
        }

        private static void loadResource() {
            player=new Image(ClassLoader.getSystemResource("UI/kaosteak.png").toString());
            bullet=new Image(ClassLoader.getSystemResource("UI/computer.png").toString());
            enemyBullet=new Image(ClassLoader.getSystemResource("UI/firebullet.png").toString());
        }
    }
}
