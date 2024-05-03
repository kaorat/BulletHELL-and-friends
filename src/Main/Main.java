package Main;

import Manager.SceneManager;
import Pane.RootPane;
import Utils.Config;
import Utils.Utility;
import Input.InputUtility;
import Input.MouseUtil;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public static Scene getScene() {
        return scene;
    }
    private long lastSecFrameTime;
    private long framePast;

    @Override
    public void start(Stage primaryStage) {
        SceneManager.gotoGameScene();
        StackPane root = new StackPane();
        root.getChildren().add(RootPane.getRootPane(Utility.getScreenX(), Utility.getScreenY()));
        root.setOnMousePressed(e -> {
            MouseUtil.setMouseX(e.getX());
            MouseUtil.setMouseY(e.getY());
            MouseUtil.setPressed(true);
        });
        root.setOnMouseReleased(e -> MouseUtil.setPressed(false));
        root.setOnMouseMoved(e -> {
            MouseUtil.setMouseX(e.getX());
            MouseUtil.setMouseY(e.getY());
        });
        root.setOnMouseDragged(e -> {
            MouseUtil.setMouseX(e.getX());
            MouseUtil.setMouseY(e.getY());
        });
        scene = new Scene(root, Utility.getScreenX(), Utility.getScreenY());
        InputUtility.setKey(scene);
        primaryStage.setTitle("Funny BulletHell Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        //Fps
        lastSecFrameTime = System.currentTimeMillis();
        framePast = 144;
        Config.fpsCalibration = 1;
        Config.deltaTime = 1.0 / 144;
        AnimationTimer animation = new AnimationTimer() {
            public void handle(long now) {
                //fps limit
                if(System.currentTimeMillis() - lastSecFrameTime >= 1000){
                    if(framePast%10>3 && framePast%10<=8){
                        framePast = (framePast / 10) * 10 + 5;
                    }
                    else{
                        framePast = (framePast / 10) * 10;
                    }
                    Config.fpsCalibration = (144.0 / framePast);
                    Config.deltaTime = 1.0 / framePast;
                    framePast = 0;
                    lastSecFrameTime = System.currentTimeMillis();
                }
                framePast++;
                //update
                scene.setCursor(Cursor.cursor("DEFAULT"));
                RootPane.paintComponent();
                SceneManager.update();
                MouseUtil.postUpdate();
            }
        };
        animation.start();
    }
}