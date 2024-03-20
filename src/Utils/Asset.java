package Utils;

import javafx.scene.image.Image;

public class Asset {
    public static class UI{
        public static Image background;
        public static Image currencyBG;
        public static Image partUI;
        public static Image soulUI;
        public static Image honeyUI;
        public static Image guniconUI;
        public static Image sheepiconUI;
        public static Image holyiconUI;
        public static Image dnaiconUI;
        static{
            loadResource();
        }

        private static void loadResource() {
            background=Load("UI/mainBackground.png");
            currencyBG=Load("UI/currencyBG.png");
            partUI=Load("UI/meat.png");
            soulUI=Load("UI/skull.png");
            honeyUI=Load("UI/computer.png");
            guniconUI=Load("UI/gun.png");
            sheepiconUI=Load("UI/sheep.png");
            holyiconUI=Load("UI/holy-grail.png");
            dnaiconUI=Load("UI/dna.png");
        }
        private static Image Load(String url){
            return new Image(ClassLoader.getSystemResource(url).toString());
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
            player=Load("UI/kaosteak.png");
            bullet=Load("UI/computer.png");
            enemyBullet=Load("UI/firebullet.png");
        }
        private static Image Load(String url){
            return new Image(ClassLoader.getSystemResource(url).toString());
        }
    }
}
