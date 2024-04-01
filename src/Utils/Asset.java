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
        public static Image backButtonNormal;
        public static Image backButtonHover;
        public static Image upgradeChoosePlayerPage;
        public static Image upgradeChooseEnemyPage;
        public static Image upgradeChooseGobletPage;
        public static Image backgroundPlayerPage;
        public static Image backgroundEnemyPage;
        public static Image backgroundGobletPage;
        public static Image backgroundSpecialDNAPage;
        public static Image upgradeButtonMeat;
        public static Image upgradeButtonNoMoneyMeat;
        public static Image upgradeButtonHoney;
        public static Image upgradeButtonNoMoneyHoney;
        public static Image upgradeButtonHoverMeat;
        public static Image upgradeButtonPressedMeat;
        public static Image upgradeButtonCARTHoney;
        public static Image buttonNavigatePlayer;
        public static Image buttonNavigateEnemy;
        public static Image buttonNavigateGoblet;
        public static Image buttonNavigateDNA;
        public static Image buttonNavigateHover;
        public static Image backgroundGameplay;


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
            backgroundGameplay=LoadImg("UI/Background/backgroundGameplay2.png");

            //Button
            buttonNavigate=LoadImg("UI/Button/Navigate/buttonNavigate.png");
            buttonNavigatePlayer=LoadImg("UI/Button/Navigate/buttonNavigatePlayer.png");
            buttonNavigateEnemy=LoadImg("UI/Button/Navigate/buttonNavigateEnemy.png");
            buttonNavigateGoblet=LoadImg("UI/Button/Navigate/buttonNavigateGoblet.png");
            buttonNavigateDNA=LoadImg("UI/Button/Navigate/buttonNavigateDNA.png");
            buttonNavigateHover=LoadImg("UI/Button/Navigate/buttonNavigateHover.png");

            backButtonNormal=LoadImg("UI/Button/Back/backButtonNormal.png");
            backButtonHover=LoadImg("UI/Button/Back/backButtonHover.png");
            upgradeButtonMeat=LoadImg("UI/Button/Upgrade/Meat/upgradeButtonMeat.png");
            upgradeButtonNoMoneyMeat=LoadImg("UI/Button/Upgrade/Meat/upgradeButtonNoMoneyMeat.png");
            upgradeButtonHoverMeat=LoadImg("UI/Button/Upgrade/Meat/upgradeButtonHoverMeat.png");
            upgradeButtonPressedMeat=LoadImg("UI/Button/Upgrade/Meat/upgradeButtonPressedMeat.png");
            upgradeButtonHoney=LoadImg("UI/Button/Upgrade/Honey/upgradeButtonHoney.png");
            upgradeButtonNoMoneyHoney=LoadImg("UI/Button/Upgrade/Honey/upgradeButtonNoMoneyHoney.png");
            upgradeButtonCARTHoney=LoadImg("UI/Button/Upgrade/Honey/upgradeButtonCARTHoney.png");

            spriteHover=LoadImg("UI/Button/spriteHover.png");
            spriteClick=LoadImg("UI/Button/Navigate/buttonNavigate.png");

            upgradeChoosePlayerPage=LoadImg("UI/UpgradeChoose/upgradeChoosePlayerPage.png");
            upgradeChooseEnemyPage=LoadImg("UI/UpgradeChoose/upgradeChooseEnemyPage.png");
            upgradeChooseGobletPage=LoadImg("UI/UpgradeChoose/upgradeChooseGobletPage.png");

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
        public static Image rifleBullet;
        public static Image enemyBullet;
        public static Image cowBullet;
        public static Image enemy;
        static{
            loadResource();
        }

        private static void loadResource() {
            player=Load("UI/kaosteak.png");
            bullet=Load("UI/Currency/Honey.png");
            rifleBullet=Load("UI/Bullet/RifleShot.png");

            enemyBullet=Load("UI/Bullet/NormalShot.png");
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
