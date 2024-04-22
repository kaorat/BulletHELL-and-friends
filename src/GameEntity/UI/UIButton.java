package GameEntity.UI;

import Main.Main;
import Utils.Asset;
import Utils.ButtonType;
import Utils.Transform;
import Utils.Utility;
import Input.MouseUtil;
import javafx.scene.Cursor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class UIButton extends UISprite {
    private final ButtonType buttonType;
    private boolean pressed;
    private boolean hovered;
    private boolean enabled;


    public UIButton(Image sprite, Transform transform, double z, ButtonType buttonType) {
        super(sprite, transform, z);
        this.pressed = false;
        this.hovered = false;
        this.enabled = true;
        this.buttonType = buttonType;
    }

    public boolean isPressed() {
        return pressed;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (!visible) {
            return;
        }

        // Add button-specific drawing logic here, such as highlighting when hovered or pressed
        if (!enabled) {
            //Not enough money
            if (buttonType == ButtonType.UPGRADEMEAT) {
                setSprite(Asset.UI.upgradeButtonNoMoneyMeat);
            } else if (buttonType == ButtonType.UPGRADEHONEY) {
                setSprite(Asset.UI.upgradeButtonNoMoneyHoney);
            } else if (buttonType == ButtonType.UPGRADEDNA) {
                setSprite(Asset.UI.upgradeButtonNoMoneyDNA);
            } else if ((buttonType == ButtonType.UPGRADESHEEP) || (buttonType == ButtonType.UPGRADECOW) || (buttonType == ButtonType.UPGRADECHICKEN)) {
                setSprite(Asset.UI.enemyLock);
            } else if (buttonType == ButtonType.GOBLET) {
                setSprite(Asset.UI.buttonGobletDisabled);
            }

        } else {
            if (MouseUtil.isPressed() && hovered) {
                // Draw pressed effect
                if (buttonType == ButtonType.UPGRADEMEAT) {
                    setSprite(Asset.UI.upgradeButtonPressedMeat);
                } else if (buttonType == ButtonType.BOSSCALLED) {
                    setSprite(Asset.UI.buttonBossPressed);
                }

            } else if (hovered) {
                Main.getScene().setCursor(Cursor.cursor("HAND"));
                // Draw  hover
                if (buttonType == ButtonType.UPGRADEMEAT) {
                    setSprite(Asset.UI.upgradeButtonHoverMeat);
                } else if (buttonType == ButtonType.NAVIGATORPLAYER || buttonType == ButtonType.NAVIGATORENEMY || buttonType == ButtonType.NAVIGATORGOBLET || buttonType == ButtonType.NAVIGATORDNA) {
                    setSprite(Asset.UI.buttonNavigateHover);
                } else if (buttonType == ButtonType.UPGRADEHONEY) {
                    setSprite(Asset.UI.upgradeButtonCARTHoney);
                } else if (buttonType == ButtonType.UPGRADEDNA) {
                    setSprite(Asset.UI.upgradeButtonHoverDNA);
                } else if (buttonType == ButtonType.BACK) {
                    setSprite(Asset.UI.backButtonHover);
                } else if ((buttonType == ButtonType.UPGRADESHEEP) || (buttonType == ButtonType.UPGRADECOW) || (buttonType == ButtonType.UPGRADECHICKEN)) {
                    setSprite(Asset.UI.enemyUnlockedHover);
                } else if (buttonType == ButtonType.GOBLET) {
                    setSprite(Asset.UI.buttonGobletHover);
                } else if (buttonType == ButtonType.BOSSCALLED) {
                    setSprite(Asset.UI.buttonBossHover);
                }


            } else {
                //Normal
                if (buttonType == ButtonType.UPGRADEMEAT) {
                    setSprite(Asset.UI.upgradeButtonMeat);
                } else if (buttonType == ButtonType.NAVIGATORPLAYER) {
                    setSprite(Asset.UI.buttonNavigatePlayer);
                } else if (buttonType == ButtonType.NAVIGATORENEMY) {
                    setSprite(Asset.UI.buttonNavigateEnemy);
                } else if (buttonType == ButtonType.NAVIGATORGOBLET) {
                    setSprite(Asset.UI.buttonNavigateGoblet);
                } else if (buttonType == ButtonType.NAVIGATORDNA) {
                    setSprite(Asset.UI.buttonNavigateDNA);
                } else if (buttonType == ButtonType.UPGRADEHONEY) {
                    setSprite(Asset.UI.upgradeButtonHoney);
                } else if (buttonType == ButtonType.BACK) {
                    setSprite(Asset.UI.backButtonNormal);
                } else if (buttonType == ButtonType.UPGRADEDNA) {
                    setSprite(Asset.UI.upgradeButtonDNA);
                } else if (buttonType == ButtonType.UPGRADESHEEP) {
                    setSprite(Asset.UI.sheepUnlocked);
                } else if (buttonType == ButtonType.UPGRADECOW) {
                    setSprite(Asset.UI.cowUnlocked);
                } else if (buttonType == ButtonType.UPGRADECHICKEN) {
                    setSprite(Asset.UI.chickenUnlocked);
                } else if (buttonType == ButtonType.GOBLET) {
                    setSprite(Asset.UI.buttonGoblet);
                } else if (buttonType == ButtonType.BOSSCALLED) {
                    setSprite(Asset.UI.buttonBossNormal);
                }
            }
        }

        super.draw(gc);
    }

    @Override
    public void onUpdate() {
        hovered = enabled && Utility.checkHover(getTransform(), getSprite());
        pressed = MouseUtil.isActivated() && hovered;
//        System.out.println(clickCount);
    }

    public void setEnable(boolean enable) {
        this.enabled = enable;
    }

}
