package Main;

import Manager.SceneManager;
import Utils.Asset;
import input.MouseUtil;
import Utils.Utility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import Pane.RootPane;
import input.InputUtility;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        SceneManager.GotoGameScene();
        StackPane root = new StackPane();
        root.getChildren().add(RootPane.getRootPane(Utility.getScreenX(),Utility.getScreenY()));
        root.setOnMousePressed(e -> {
            MouseUtil.setMouseX(e.getX());
            MouseUtil.setMouseY(e.getY());
            MouseUtil.setPressed(true);
        });
        root.setOnMouseReleased(e -> {
            MouseUtil.setPressed(false);
        });
        root.setOnMouseMoved(e -> {
            MouseUtil.setMouseX(e.getX());
            MouseUtil.setMouseY(e.getY());
        });
        root.setOnMouseDragged(e -> {
            MouseUtil.setMouseX(e.getX());
            MouseUtil.setMouseY(e.getY());
        });
        Scene scene = new Scene(root, Utility.getScreenX(), Utility.getScreenY());
        InputUtility.setKey(scene);
        primaryStage.setTitle("Funny BulletHell Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        AnimationTimer animation = new AnimationTimer() {
            public void handle(long now) {
                RootPane.paintComponent();
                SceneManager.update();
                //GameObjectHolder.getInstance().update();
                //InputUtility.updateInputState();
                MouseUtil.postUpdate();
            }
        };
        //just for testing bgm
//        AudioClip bgm = Asset.Audio.bgm;
//        bgm.setCycleCount(AudioClip.INDEFINITE);
//        bgm.setVolume(0.05);
//        bgm.play();
        animation.start();
    }
}