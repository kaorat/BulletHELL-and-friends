package Utils;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class Asset {

    public static class UI{
        public static Image baseBackground;
        public static Image aPixel;
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
        public static Image upgradeHeader;
        public static Image playerHeader;
        public static Image enemyHeader;
        public static Image gobletHeader;
        public static Image DNAHeader;
        public static Image enemyLock;
        public static Image enemyUnlockedHover;
        public static Image sheepUnlocked;
        public static Image cowUnlocked;
        public static Image chickenUnlocked;
        public static Image partsDrop;
        public static Image WhiteSheepIdleRight;
        public static Image WhiteCowIdleRight;
        public static Image WhiteChickenIdleRight;
        public static Image BlackSheepIdleRight;
        public static Image BlackCowIdleRight;
        public static Image BlackChickenIdleRight;
        public static Image WhiteSheepIdleLeft;
        public static Image WhiteCowIdleLeft;
        public static Image WhiteChickenIdleLeft;
        public static Image BlackSheepIdleLeft;
        public static Image BlackCowIdleLeft;
        public static Image BlackChickenIdleLeft;
        public static Image BlackSheepAimRight;
        public static Image BlackCowAimRight;
        public static Image BlackChickenAimRight;
        public static Image BlackSheepAimLeft;
        public static Image BlackCowAimLeft;
        public static Image BlackChickenAimLeft;
        public static Image WhiteSheepAimRight;
        public static Image WhiteCowAimRight;
        public static Image WhiteChickenAimRight;
        public static Image WhiteSheepAimLeft;
        public static Image WhiteCowAimLeft;
        public static Image WhiteChickenAimLeft;
        public static Image BlackSheepShootRight;
        public static Image BlackCowShootRight;
        public static Image BlackChickenShootRight;
        public static Image BlackSheepShootLeft;
        public static Image BlackCowShootLeft;
        public static Image BlackChickenShootLeft;
        public static Image WhiteSheepShootRight;
        public static Image WhiteCowShootRight;
        public static Image WhiteChickenShootRight;
        public static Image WhiteSheepShootLeft;
        public static Image WhiteCowShootLeft;
        public static Image WhiteChickenShootLeft;


        static{
            loadResource();
        }

        private static void loadResource() {
            //pixel
            aPixel = LoadImg("UI/A pixel.png");
            //Background
            baseBackground=LoadImg("UI/Background/baseBackground.png");
            mainBackground=LoadImg("UI/Background/mainBackground.png");
            backgroundPlayerPage=LoadImg("UI/Background/backgroundPlayerPage.png");
            backgroundEnemyPage=LoadImg("UI/Background/backgroundEnemyPage.png");
            backgroundGobletPage=LoadImg("UI/Background/backgroundGobletPage.png");
            backgroundSpecialDNAPage=LoadImg("UI/Background/backgroundSpecialDNAPage.png");
            backgroundGameplay=LoadImg("UI/Background/farmBg.png");

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
            upgradeButtonDNA=LoadImg("UI/Button/Upgrade/DNA/upgradeButtonDNA.png");
            upgradeButtonHoverDNA=LoadImg("UI/Button/Upgrade/DNA/upgradeButtonHoverDNA.png");
            upgradeButtonNoMoneyDNA=LoadImg("UI/Button/Upgrade/DNA/upgradeButtonNoMoneyDNA.png");

            spriteHover=LoadImg("UI/Button/spriteHover.png");
            spriteClick=LoadImg("UI/Button/Navigate/buttonNavigate.png");

            upgradeChoosePlayerPage=LoadImg("UI/UpgradeChoose/upgradeChoosePlayerPage.png");
            upgradeChooseEnemyPage=LoadImg("UI/UpgradeChoose/upgradeChooseEnemyPage.png");
            upgradeChooseGobletPage=LoadImg("UI/UpgradeChoose/upgradeChooseGobletPage.png");
            upgradeChooseDNAPage=LoadImg("UI/UpgradeChoose/upgradeChooseDNAPage.png");

            enemyLock=LoadImg("UI/Button/UnlockEnemy/enemyLock.png");
            enemyUnlockedHover=LoadImg("UI/Button/UnlockEnemy/enemyUnlockedHover.png");
            sheepUnlocked=LoadImg("UI/Button/UnlockEnemy/sheepUnlocked.png");
            cowUnlocked=LoadImg("UI/Button/UnlockEnemy/cowUnlocked.png");
            chickenUnlocked=LoadImg("UI/Button/UnlockEnemy/chickenUnlocked.png");
            partsDrop=LoadImg("UI/Currency/partsDrop.png");

            headerMain=LoadImg("UI/headerMain.png");
            currencyBG=LoadImg("UI/Currency/currencyBG.png");
            partUI=LoadImg("UI/Currency/meat.png");
            soulUI=LoadImg("UI/Enemy/skull.png");
            honeyUI=LoadImg("UI/Currency/Honey.png");
            guniconUI=LoadImg("UI/gun.png");
            sheepiconUI=LoadImg("UI/Enemy/sheep.png");
            holyiconUI=LoadImg("UI/Currency/holy-grail.png");
            dnaiconUI=LoadImg("UI/Currency/dna.png");

            upgradeHeader=LoadImg("UI/Header/upgradeHeader.png");
            playerHeader=LoadImg("UI/Header/playerHeader.png");
            enemyHeader=LoadImg("UI/Header/enemyHeader.png");
            gobletHeader=LoadImg("UI/Header/gobletHeader.png");
            DNAHeader=LoadImg("UI/Header/DNAHeader.png");

            WhiteSheepIdleRight=LoadImg("UI/Enemy/Idle/Right/WhiteSheepIdleRight.png");
            WhiteCowIdleRight=LoadImg("UI/Enemy/Idle/Right/WhiteCowIdleRight.png");
            WhiteChickenIdleRight=LoadImg("UI/Enemy/Idle/Right/WhiteChickenIdleRight.png");
            BlackSheepIdleRight=LoadImg("UI/Enemy/Idle/Right/BlackSheepIdleRight.png");
            BlackCowIdleRight=LoadImg("UI/Enemy/Idle/Right/BlackCowIdleRight.png");
            BlackChickenIdleRight=LoadImg("UI/Enemy/Idle/Right/BlackChickenIdleRight.png");
            WhiteSheepIdleLeft=LoadImg("UI/Enemy/Idle/Left/WhiteSheepIdleLeft.png");
            WhiteCowIdleLeft=LoadImg("UI/Enemy/Idle/Left/WhiteCowIdleLeft.png");
            WhiteChickenIdleLeft=LoadImg("UI/Enemy/Idle/Left/WhiteChickenIdleLeft.png");
            BlackSheepIdleLeft=LoadImg("UI/Enemy/Idle/Left/BlackSheepIdleLeft.png");
            BlackCowIdleLeft=LoadImg("UI/Enemy/Idle/Left/BlackCowIdleLeft.png");
            BlackChickenIdleLeft=LoadImg("UI/Enemy/Idle/Left/BlackChickenIdleLeft.png");

            WhiteSheepAimRight=LoadImg("UI/Enemy/Aim/Right/WhiteSheepAimRight.png");
            WhiteCowAimRight=LoadImg("UI/Enemy/Aim/Right/WhiteCowAimRight.png");
            WhiteChickenAimRight=LoadImg("UI/Enemy/Aim/Right/WhiteChickenAimRight.png");
            BlackSheepAimRight=LoadImg("UI/Enemy/Aim/Right/BlackSheepAimRight.png");
            BlackCowAimRight=LoadImg("UI/Enemy/Aim/Right/BlackCowAimRight.png");
            BlackChickenAimRight=LoadImg("UI/Enemy/Aim/Right/BlackChickenAimRight.png");
            WhiteSheepAimLeft=LoadImg("UI/Enemy/Aim/Left/WhiteSheepAimLeft.png");
            WhiteCowAimLeft=LoadImg("UI/Enemy/Aim/Left/WhiteCowAimLeft.png");
            WhiteChickenAimLeft=LoadImg("UI/Enemy/Aim/Left/WhiteChickenAimLeft.png");
            BlackSheepAimLeft=LoadImg("UI/Enemy/Aim/Left/BlackSheepAimLeft.png");
            BlackCowAimLeft=LoadImg("UI/Enemy/Aim/Left/BlackCowAimLeft.png");
            BlackChickenAimLeft=LoadImg("UI/Enemy/Aim/Left/BlackChickenAimLeft.png");

            WhiteSheepShootRight=LoadImg("UI/Enemy/Shoot/Right/WhiteSheepShootRight.png");
            WhiteCowShootRight=LoadImg("UI/Enemy/Shoot/Right/WhiteCowShootRight.png");
            WhiteChickenShootRight=LoadImg("UI/Enemy/Shoot/Right/WhiteChickenShootRight.png");
            BlackSheepShootRight=LoadImg("UI/Enemy/Shoot/Right/BlackSheepShootRight.png");
            BlackCowShootRight=LoadImg("UI/Enemy/Shoot/Right/BlackCowShootRight.png");
            BlackChickenShootRight=LoadImg("UI/Enemy/Shoot/Right/BlackChickenShootRight.png");
            WhiteSheepShootLeft=LoadImg("UI/Enemy/Shoot/Left/WhiteSheepShootLeft.png");
            WhiteCowShootLeft=LoadImg("UI/Enemy/Shoot/Left/WhiteCowShootLeft.png");
            WhiteChickenShootLeft=LoadImg("UI/Enemy/Shoot/Left/WhiteChickenShootLeft.png");
            BlackSheepShootLeft=LoadImg("UI/Enemy/Shoot/Left/BlackSheepShootLeft.png");
            BlackCowShootLeft=LoadImg("UI/Enemy/Shoot/Left/BlackCowShootLeft.png");
            BlackChickenShootLeft=LoadImg("UI/Enemy/Shoot/Left/BlackChickenShootLeft.png");

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
        public static Image michealJackson;
        static{
            loadResource();
        }

        private static void loadResource() {
            player=Load("UI/kaosteak.png");
            bullet=Load("UI/Currency/Honey.png");
            rifleBullet=Load("UI/Bullet/RifleShot.png");

            enemyBullet=Load("UI/Bullet/NormalShot.png");
            cowBullet=Load("UI/CowBullet.png");
            michealJackson=Load("UI/Enemy/mc.png");


        }
        private static Image Load(String url){
            return new Image(ClassLoader.getSystemResource(url).toString());
        }

    }
    public static class Audio{

        public static AudioClip bulletSound;
        public static AudioClip bgm;
        public static AudioClip bossFight1;

        static{
            loadResource();
        }

        public static void loadResource(){
            bulletSound = new AudioClip(ClassLoader.getSystemResource("AUDIO/bullet.wav").toString());
            bgm = new AudioClip(ClassLoader.getSystemResource("AUDIO/scope.wav").toString());
            bossFight1 = new AudioClip(ClassLoader.getSystemResource("AUDIO/bossfight1.wav").toString());
        }

    }


}
