package Utils;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;


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
        public static Image backButton;
        public static Image upgradeChoosePlayerPage;
        public static Image backgroundPlayerPage;
        public static Image upgradeButton;
        public static Image upgradeButtonNoMoney;
        public static Image upgradeButtonHover;
        public static Image upgradeButtonPressed;


        static{
            loadResource();
        }

        private static void loadResource() {
            //Background
            baseBackground=Load("UI/Background/baseBackground.png");
            mainBackground=Load("UI/Background/mainBackground.png");
            backgroundPlayerPage=Load("UI/Background/backgroundPlayerPage.png");

            //Button
            buttonNavigate=Load("UI/Button/Navigate/buttonNavigate.png");
            backButton=Load("UI/Button/backButton.png");
            upgradeButton=Load("UI/Button/Upgrade/upgradeButton.png");
            upgradeButtonNoMoney=Load("UI/Button/Upgrade/upgradeButtonNoMoney.png");
            upgradeButtonHover=Load("UI/Button/Upgrade/upgradeButtonHover.png");
            upgradeButtonPressed=Load("UI/Button/Upgrade/upgradeButtonPressed.png");
            spriteHover=Load("UI/Button/spriteHover.png");
            spriteClick=Load("UI/Button/Navigate/buttonNavigate.png");


            upgradeChoosePlayerPage=Load("UI/UpgradeChoose/upgradeChoosePlayerPage.png");
            headerMain=Load("UI/headerMain.png");
            currencyBG=Load("UI/Currency/currencyBG.png");
            partUI=Load("UI/Currency/meat.png");
            soulUI=Load("UI/Enemy/skull.png");
            honeyUI=Load("UI/Currency/Honey.png");
            guniconUI=Load("UI/gun.png");
            sheepiconUI=Load("UI/Enemy/sheep.png");
            holyiconUI=Load("UI/Currency/holy-grail.png");
            dnaiconUI=Load("UI/Currency/dna.png");

        }
        private static Image Load(String url){
            return new Image(ClassLoader.getSystemResource(url).toString());
        }
    }



    public static class Game{
        public static Image player;
        public static Image bullet;
        public static Image enemyBullet;
        public static Image cowBullet;
        public static Image enemy;
        static{
            loadResource();
        }

        private static void loadResource() {
            player=Load("UI/kaosteak.png");
            bullet=Load("UI/Currency/Honey.png");
            enemyBullet=Load("UI/firebullet.png");
            cowBullet=Load("UI/CowBullet.png");
        }
        private static Image Load(String url){
            return new Image(ClassLoader.getSystemResource(url).toString());
        }

    }
    public static class Audio{

        public static AudioClip bulletSound;
        public static AudioClip bgm;

        static{
            loadResource();
        }

        public static void loadResource(){
            bulletSound = new AudioClip(ClassLoader.getSystemResource("AUDIO/bullet.wav").toString());
            bgm = new AudioClip(ClassLoader.getSystemResource("AUDIO/scope.wav").toString());
        }

    }


}
