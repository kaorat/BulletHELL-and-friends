package Main;

import Manager.GameObjectHolder;
import Manager.SceneManager;
import Utils.Utility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
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
                GameObjectHolder.getInstance().update();
                //InputUtility.updateInputState();
            }
        };
        animation.start();
    }
}