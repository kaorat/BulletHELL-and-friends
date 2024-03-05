package Manager;

import Pane.GameSideUIPane;
import Pane.GameplayPane;
import Pane.GraphicEditor;
import Pane.RootPane;

import java.util.ArrayList;

public class SceneManager {
    public static int currentScene;
    public static ArrayList<GraphicEditor> graphicEditors;
    public static int getCurrentScene() {
        return currentScene;
    }
    public static void GotoGameScene(){
        currentScene=1;
        SceneManager.graphicEditors.clear();
        SceneManager.graphicEditors.add(new GameplayPane(RootPane.getRootPane().getGraphicsContext2D()));
        SceneManager.graphicEditors.add(new GameSideUIPane(RootPane.getRootPane().getGraphicsContext2D()));
    }
}
