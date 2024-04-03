package Pane.Page;

import GameEntity.Boss.BaseBoss;
import GameEntity.UI.UIButton;
import GameEntity.UI.UISprite;
import Manager.BossManager;
import Manager.SceneManager;
import Manager.StatManager;
import Pane.GraphicEditor;
import Utils.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BossPage extends GraphicEditor {
    private int time;
    private double lastframe;
    private UISprite timer;
    private UISprite hpBar;
    private BaseBoss boss;
    public BossPage(GraphicsContext graphicsContext) {
        super(graphicsContext);
        //Background above main bg
        time=60;
        lastframe=System.currentTimeMillis();
        boss = BossManager.getInstance().initBoss();
        create(new UISprite(Asset.UI.mainBackground, new Transform(0, 0, 0.65, 0.5), -10));
        create(new UISprite(Asset.UI.headerMain,new Transform(20,35,2,0.3),70));
        hpBar = (UISprite) create(new UISprite(Asset.UI.aPixel,new Transform(65,36,490,11),75));
        timer = (UISprite) create(new UISprite(new Text("60", Utility.getGameFont(30), Color.WHITE),new Transform(Utility.getGameScreenX()-50,50),76));
        create(new UISprite(Asset.UI.aPixel,new Transform(100,100,1,20),75));
        create(new UISprite(Asset.UI.aPixel,new Transform(200,100,1,20),75));
        create(new UISprite(Asset.UI.aPixel,new Transform(300,100,1,20),75));
        create(new UISprite(Asset.UI.aPixel,new Transform(400,100,1,20),75));
        create(new UISprite(Asset.UI.aPixel,new Transform(500,100,1,20),75));
        create(new UISprite(Asset.UI.aPixel,new Transform(600,100,1,20),75));
    }
    @Override
    public void onUpdate() {
        if(time<0) SceneManager.DeActivatedBossPage();
        if (System.currentTimeMillis() - lastframe > 1000) {
            time--;
            timer.getText().setText(String.valueOf(time));
            lastframe=System.currentTimeMillis();
        }
        hpBar.getTransform().setSclX((boss.getHp() * 490) /boss.getMaxHp());
    }
}

