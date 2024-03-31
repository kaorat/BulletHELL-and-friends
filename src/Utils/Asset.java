package Utils;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


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
        public static Image upgradeChooseEnemyPage;
        public static Image backgroundPlayerPage;
        public static Image backgroundEnemyPage;
        public static Image backgroundGobletPage;
        public static Image backgroundSpecialDNAPage;
        public static Image upgradeButton;
        public static Image upgradeButtonNoMoney;
        public static Image upgradeButtonHover;
        public static Image upgradeButtonPressed;


        static{
            loadResource();
        }

        private static void loadResource() {
            //Background
            baseBackground=LoadImg("UI/Background/baseBackground.png");
            mainBackground=LoadImg("UI/Background/mainBackground.png");
            backgroundPlayerPage=LoadImg("UI/Background/backgroundPlayerPage.png");
            backgroundEnemyPage=LoadImg("UI/Background/backgroundEnemyPage.png");
            backgroundGobletPage=LoadImg("UI/Background/backgroundGobletPage.png");
            backgroundSpecialDNAPage=LoadImg("UI/Background/backgroundSpecialDNAPage.png");

            //Button
            buttonNavigate=LoadImg("UI/Button/Navigate/buttonNavigate.png");
            backButton=LoadImg("UI/Button/backButton.png");
            upgradeButton=LoadImg("UI/Button/Upgrade/upgradeButton.png");
            upgradeButtonNoMoney=LoadImg("UI/Button/Upgrade/upgradeButtonNoMoney.png");
            upgradeButtonHover=LoadImg("UI/Button/Upgrade/upgradeButtonHover.png");
            upgradeButtonPressed=LoadImg("UI/Button/Upgrade/upgradeButtonPressed.png");
            spriteHover=LoadImg("UI/Button/spriteHover.png");
            spriteClick=LoadImg("UI/Button/Navigate/buttonNavigate.png");

            upgradeChoosePlayerPage=LoadImg("UI/UpgradeChoose/upgradeChoosePlayerPage.png");
            upgradeChooseEnemyPage=LoadImg("UI/UpgradeChoose/upgradeChooseEnemyPage.png");

            headerMain=LoadImg("UI/headerMain.png");
            currencyBG=LoadImg("UI/Currency/currencyBG.png");
            partUI=LoadImg("UI/Currency/meat.png");
            soulUI=LoadImg("UI/Enemy/skull.png");
            honeyUI=LoadImg("UI/Currency/Honey.png");
            guniconUI=LoadImg("UI/gun.png");
            sheepiconUI=LoadImg("UI/Enemy/sheep.png");
            holyiconUI=LoadImg("UI/Currency/holy-grail.png");
            dnaiconUI=LoadImg("UI/Currency/dna.png");

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
            bullet=Load("UI/Currency/Honey.png");
            enemyBullet=Load("UI/firebullet.png");
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
