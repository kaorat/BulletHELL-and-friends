package Utils;

import javafx.scene.image.Image;


public class Asset {

    public static class UI{
        public static Image baseBackground;
        public static Image mainBackground;
        public static Image buttonNavigate;
        public static Image spriteHover;
        public static Image spriteClick;
        public static Image currencyBG;
        public static Image partUI;
        public static Image soulUI;
        public static Image honeyUI;
        public static Image guniconUI;
        public static Image sheepiconUI;
        public static Image holyiconUI;
        public static Image dnaiconUI;
        public static Image headerMain;

        static{
            loadResource();
        }

        private static void loadResource() {
            //Background
            baseBackground=LoadImg("UI/baseBackground.png");
            mainBackground=LoadImg("UI/mainBackground.png");
            //Button
            buttonNavigate=LoadImg("UI/buttonNavigate.png");
            spriteHover=LoadImg("UI/spriteHover.png");
            spriteClick=LoadImg("UI/buttonNavigate.png");

            headerMain=LoadImg("UI/headerMain.png");
            currencyBG=LoadImg("UI/currencyBG.png");
            partUI=LoadImg("UI/meat.png");
            soulUI=LoadImg("UI/skull.png");
            honeyUI=LoadImg("UI/computer.png");
            guniconUI=LoadImg("UI/gun.png");
            sheepiconUI=LoadImg("UI/sheep.png");
            holyiconUI=LoadImg("UI/holy-grail.png");
            dnaiconUI=LoadImg("UI/dna.png");

        }
        private static Image LoadImg(String url){
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
