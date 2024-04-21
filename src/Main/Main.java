package Main;

import Manager.SceneManager;
import Pane.RootPane;
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

    @Override
    public void start(Stage primaryStage) {
        SceneManager.GotoGameScene();
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
        AnimationTimer animation = new AnimationTimer() {
            public void handle(long now) {
                scene.setCursor(Cursor.cursor("DEFAULT"));
                RootPane.paintComponent();
                SceneManager.update();
                MouseUtil.postUpdate();
            }
        };
        //just for testing bgm

        animation.start();
    }
}