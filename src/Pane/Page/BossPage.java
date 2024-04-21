package Pane.Page;

import GameEntity.Boss.BaseBoss;
import GameEntity.UI.UISprite;
import Manager.BossManager;
import Manager.SceneManager;
import Pane.GraphicEditor;
import Utils.Asset;
import Utils.Text;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BossPage extends GraphicEditor {
    private final UISprite timer;
    private final UISprite hpBar;
    private final BaseBoss boss;
    private int time;
    private double lastFrame;

    public BossPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background above main bg
        time = 1000;
        lastFrame = System.currentTimeMillis();
        boss = BossManager.getInstance().initBoss();
        create(new UISprite(Asset.UI.backgroundBoss, new Transform(0, 0, 0.65, 0.5), -10));
        create(new UISprite(Asset.UI.headerMain, new Transform(20, 35, 2, 0.3), 70));
        hpBar = (UISprite) create(new UISprite(Asset.UI.aPixel, new Transform(65, 36, 490, 11), 75));
        timer = (UISprite) create(new UISprite(new Text("60", Utility.getGameFont(30), Color.WHITE), new Transform(Utility.getGameScreenX() - 50, 50), 76));
    }

    @Override
    public void onUpdate() {
        if (time < 0) SceneManager.DeActivatedBossPage();
        if (System.currentTimeMillis() - lastFrame > 1000) {
            time--;
            timer.getText().setText(String.valueOf(time));
            lastFrame = System.currentTimeMillis();
        }
        hpBar.getTransform().setSclX((boss.getHp() * 490) / boss.getMaxHp());
    }
}

