package Manager;

import Pane.GameSideUIPane;
import Pane.GameplayPane;
import Pane.RootPane;

public class SceneManager {
    public static int currentScene;

    private static RootPane rootPane;
    public static void setRootPane(RootPane rootPane){
        SceneManager.rootPane = rootPane;
    }
    public static int getCurrentScene() {
        return currentScene;
    }
    public static void clearRoot(){
        if(!rootPane.getChildren().isEmpty()) {
            while(!rootPane.getChildren().isEmpty()){
                rootPane.getChildren().remove(1);
            }
        }
    }
    public static void GotoGameScene(){
        currentScene=1;
        clearRoot();
        rootPane.getChildren().add(new GameplayPane());
        rootPane.getChildren().add(new GameSideUIPane());
    }
}
