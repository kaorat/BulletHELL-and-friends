package Utils;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class Asset {

    public static class UI {
        public static Image aPixel;
        public static Image mainBackground;
        public static Image buttonNavigate;
        public static Image currencyBG;
        public static Image partUI;
        public static Image soulUI;
        public static Image honeyUI;
        public static Image headerMain;
        public static Image backButtonNormal;
        public static Image backButtonHover;
        public static Image upgradeChoosePlayerPage;
        public static Image upgradeChooseEnemyPage;
        public static Image upgradeChooseGobletPage;
        public static Image upgradeChooseDNAPage;
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
        public static Image upgradeButtonDNA;
        public static Image upgradeButtonHoverDNA;
        public static Image upgradeButtonNoMoneyDNA;
        public static Image buttonNavigatePlayer;
        public static Image buttonNavigateEnemy;
        public static Image buttonNavigateGoblet;
        public static Image buttonNavigateDNA;
        public static Image buttonNavigateHover;
        public static Image backgroundGameplay;
        public static Image backgroundBoss;
        public static Image upgradeHeader;
        public static Image playerHeader;
        public static Image enemyHeader;
        public static Image gobletHeader;
        public static Image dnaHeader;
        public static Image enemyLock;
        public static Image enemyUnlockedHover;
        public static Image sheepUnlocked;
        public static Image cowUnlocked;
        public static Image chickenUnlocked;
        public static Image partsDrop;
        public static Image idle1;
        public static Image idle2;
        public static Image attacked;
        public static Image goblet;
        public static Image buttonGoblet;
        public static Image buttonGobletHover;
        public static Image buttonGobletDisabled;
        public static Image backgroundStatus;
        public static Image buttonBossHover;
        public static Image buttonBossNormal;
        public static Image buttonBossPressed;


        static {
            loadResource();
        }

        private static void loadResource() {
            //pixel
            aPixel = LoadImg("UI/A pixel.png");
            //Background
            mainBackground = LoadImg("UI/Background/mainBackground.png");
            backgroundPlayerPage = LoadImg("UI/Background/backgroundPlayerPage.png");
            backgroundEnemyPage = LoadImg("UI/Background/backgroundEnemyPage.png");
            backgroundGobletPage = LoadImg("UI/Background/backgroundGobletPage.png");
            backgroundSpecialDNAPage = LoadImg("UI/Background/backgroundSpecialDNAPage.png");
            backgroundGameplay = LoadImg("UI/Background/farmBg.png");
            backgroundBoss = LoadImg("UI/Background/test.png");

            //Button
            buttonNavigate = LoadImg("UI/Button/Navigate/buttonNavigate.png");
            buttonNavigatePlayer = LoadImg("UI/Button/Navigate/buttonNavigatePlayer.png");
            buttonNavigateEnemy = LoadImg("UI/Button/Navigate/buttonNavigateEnemy.png");
            buttonNavigateGoblet = LoadImg("UI/Button/Navigate/buttonNavigateGoblet.png");
            buttonNavigateDNA = LoadImg("UI/Button/Navigate/buttonNavigateDNA.png");
            buttonNavigateHover = LoadImg("UI/Button/Navigate/buttonNavigateHover.png");

            backButtonNormal = LoadImg("UI/Button/Back/backButtonNormal.png");
            backButtonHover = LoadImg("UI/Button/Back/backButtonHover.png");
            upgradeButtonMeat = LoadImg("UI/Button/Upgrade/Meat/upgradeButtonMeat.png");
            upgradeButtonNoMoneyMeat = LoadImg("UI/Button/Upgrade/Meat/upgradeButtonNoMoneyMeat.png");
            upgradeButtonHoverMeat = LoadImg("UI/Button/Upgrade/Meat/upgradeButtonHoverMeat.png");
            upgradeButtonPressedMeat = LoadImg("UI/Button/Upgrade/Meat/upgradeButtonPressedMeat.png");
            upgradeButtonHoney = LoadImg("UI/Button/Upgrade/Honey/upgradeButtonHoney.png");
            upgradeButtonNoMoneyHoney = LoadImg("UI/Button/Upgrade/Honey/upgradeButtonNoMoneyHoney.png");
            upgradeButtonCARTHoney = LoadImg("UI/Button/Upgrade/Honey/upgradeButtonCARTHoney.png");
            upgradeButtonDNA = LoadImg("UI/Button/Upgrade/DNA/upgradeButtonDNA.png");
            upgradeButtonHoverDNA = LoadImg("UI/Button/Upgrade/DNA/upgradeButtonHoverDNA.png");
            upgradeButtonNoMoneyDNA = LoadImg("UI/Button/Upgrade/DNA/upgradeButtonNoMoneyDNA.png");


            upgradeChoosePlayerPage = LoadImg("UI/UpgradeChoose/upgradeChoosePlayerPage.png");
            upgradeChooseEnemyPage = LoadImg("UI/UpgradeChoose/upgradeChooseEnemyPage.png");
            upgradeChooseGobletPage = LoadImg("UI/UpgradeChoose/upgradeChooseGobletPage.png");
            upgradeChooseDNAPage = LoadImg("UI/UpgradeChoose/upgradeChooseDNAPage.png");

            enemyLock = LoadImg("UI/Button/UnlockEnemy/enemyLock.png");
            enemyUnlockedHover = LoadImg("UI/Button/UnlockEnemy/enemyUnlockedHover.png");
            sheepUnlocked = LoadImg("UI/Button/UnlockEnemy/sheepUnlocked.png");
            cowUnlocked = LoadImg("UI/Button/UnlockEnemy/cowUnlocked.png");
            chickenUnlocked = LoadImg("UI/Button/UnlockEnemy/chickenUnlocked.png");
            partsDrop = LoadImg("UI/Currency/partsDrop.png");

            headerMain = LoadImg("UI/headerMain.png");
            currencyBG = LoadImg("UI/Currency/currencyBG.png");
            partUI = LoadImg("UI/Currency/meat.png");
            soulUI = LoadImg("UI/Enemy/skull.png");
            honeyUI = LoadImg("UI/Currency/Honey.png");

            upgradeHeader = LoadImg("UI/Header/upgradeHeader.png");
            playerHeader = LoadImg("UI/Header/playerHeader.png");
            enemyHeader = LoadImg("UI/Header/enemyHeader.png");
            gobletHeader = LoadImg("UI/Header/gobletHeader.png");
            dnaHeader = LoadImg("UI/Header/DNAHeader.png");

            idle1 = LoadImg("UI/Player/Other/idle1.png");
            idle2 = LoadImg("UI/Player/Other/idle2.png");
            attacked = LoadImg("UI/Player/Other/attacked.png");

            goblet = LoadImg("UI/Currency/goblet.png");
            buttonGoblet = LoadImg("UI/Button/Goblet/buttonGoblet.png");
            buttonGobletHover = LoadImg("UI/Button/Goblet/buttonGobletHover.png");
            buttonGobletDisabled = LoadImg("UI/Button/Goblet/buttonGobletDisabled.png");

            backgroundStatus = LoadImg("UI/Status/backgroundStatus.png");
            buttonBossHover = LoadImg("UI/Status/buttonBossHover.png");
            buttonBossNormal = LoadImg("UI/Status/buttonBossNormal.png");
            buttonBossPressed = LoadImg("UI/Status/buttonBossPressed.png");

        }

        private static Image LoadImg(String url) {
            return new Image(ClassLoader.getSystemResource(url).toString());
        }
    }


    public static class Game {
        public static Image player;
        public static Image bullet;
        public static Image rifleBullet;
        public static Image laserBullet;
        public static Image missileBullet;
        public static Image enemyBullet;
        public static Image michealJackson;
        public static Image whiteChickenIdleRight;
        public static Image whiteSheepIdleLeft;
        public static Image whiteCowIdleLeft;
        public static Image whiteChickenAimRight;
        public static Image whiteSheepAimLeft;
        public static Image whiteCowAimLeft;
        public static Image whiteChickenShootRight;
        public static Image whiteSheepShootLeft;
        public static Image whiteCowShootLeft;
        public static Image toothless;

        static {
            loadResource();
        }

        private static void loadResource() {
            player = LoadImg("UI/kaosteak.png");
            bullet = LoadImg("UI/Currency/Honey.png");
            rifleBullet = LoadImg("UI/Bullet/RifleShot.png");
            laserBullet = LoadImg("UI/Bullet/Laser.png");
            missileBullet = LoadImg("UI/Bullet/Missile.png");

            enemyBullet = LoadImg("UI/Bullet/NormalShot.png");
            michealJackson = LoadImg("UI/Enemy/mc.png");
            toothless = LoadImg("UI/toothless.png");

            whiteChickenIdleRight = LoadImg("UI/Enemy/Idle/Right/WhiteChickenIdleRight.png");
            whiteSheepIdleLeft = LoadImg("UI/Enemy/Idle/Left/WhiteSheepIdleLeft.png");
            whiteCowIdleLeft = LoadImg("UI/Enemy/Idle/Left/WhiteCowIdleLeft.png");
            whiteChickenAimRight = LoadImg("UI/Enemy/Aim/Right/WhiteChickenAimRight.png");
            whiteSheepAimLeft = LoadImg("UI/Enemy/Aim/Left/WhiteSheepAimLeft.png");
            whiteCowAimLeft = LoadImg("UI/Enemy/Aim/Left/WhiteCowAimLeft.png");

            whiteChickenShootRight = LoadImg("UI/Enemy/Shoot/Right/WhiteChickenShootRight.png");
            whiteSheepShootLeft = LoadImg("UI/Enemy/Shoot/Left/WhiteSheepShootLeft.png");
            whiteCowShootLeft = LoadImg("UI/Enemy/Shoot/Left/WhiteCowShootLeft.png");
        }

        private static Image LoadImg(String url) {
            return new Image(ClassLoader.getSystemResource(url).toString());
        }

    }

    public static class Audio {

        public static AudioClip bgm;
        public static AudioClip bossFight1;
        public static AudioClip warp;

        public static AudioClip bulletSound;
        public static AudioClip technoShoot1;
        public static AudioClip rifleShoot;
        public static AudioClip missileShoot;
        public static AudioClip laserShoot;
        public static AudioClip playerDead;

        static {
            loadResource();
        }

        public static void loadResource() {
            bulletSound = new AudioClip(ClassLoader.getSystemResource("AUDIO/bullet.wav").toString());
            bgm = new AudioClip(ClassLoader.getSystemResource("AUDIO/scope.wav").toString());
            bossFight1 = new AudioClip(ClassLoader.getSystemResource("AUDIO/bossfight1.wav").toString());
            warp = new AudioClip(ClassLoader.getSystemResource("AUDIO/warp.wav").toString());
            technoShoot1 = new AudioClip(ClassLoader.getSystemResource("AUDIO/technoShoot1.wav").toString());
            playerDead = new AudioClip(ClassLoader.getSystemResource("AUDIO/playerDead.wav").toString());
            rifleShoot = new AudioClip(ClassLoader.getSystemResource("AUDIO/rifle.wav").toString());
            missileShoot = new AudioClip(ClassLoader.getSystemResource("AUDIO/missile.wav").toString());
            laserShoot = new AudioClip(ClassLoader.getSystemResource("AUDIO/laser.wav").toString());
        }


    }


}
