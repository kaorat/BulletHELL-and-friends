import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Mainmenu mainMenu = new Mainmenu();
        Gamebox gameBox = new Gamebox();

        Pane root = new Pane(mainMenu , gameBox);

        // Set position
        mainMenu.relocate(770, 0);
        gameBox.relocate(-130 , 0);
        Scene scene = new Scene(root, 1100, 750);

        primaryStage.setTitle("My JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
