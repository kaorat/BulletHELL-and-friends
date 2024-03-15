package Main;

import Manager.GameObjectHolder;
import Manager.SceneManager;
import Utils.Utility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Pane.RootPane;

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
        primaryStage.setTitle("Funny BulletHell Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        AnimationTimer animation = new AnimationTimer() {
            public void handle(long now) {
                RootPane.paintComponent();
                //logic.logicUpdate();
                GameObjectHolder.getInstance().update();
                //InputUtility.updateInputState();
            }
        };
        animation.start();
    }
}