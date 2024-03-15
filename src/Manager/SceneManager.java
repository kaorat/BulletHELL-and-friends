package Manager;

import Pane.GameSideUIEditor;
import Pane.GameplayEditor;
import Pane.GraphicEditor;
import Pane.RootPane;

import java.util.ArrayList;

public class SceneManager {
    public static int currentScene;
    public static ArrayList<GraphicEditor> graphicEditors=new ArrayList<>();
    public static int getCurrentScene() {
        return currentScene;
    }
    public static void GotoGameScene(){
        currentScene=1;
        SceneManager.graphicEditors.clear();
        SceneManager.graphicEditors.add(new GameplayEditor(RootPane.getRootPane().getGraphicsContext2D()));
        SceneManager.graphicEditors.add(new GameSideUIEditor(RootPane.getRootPane().getGraphicsContext2D()));
    }
    public static void update(){
        for (GraphicEditor graphicEditor : graphicEditors) {
            graphicEditor.onUpdate();
        }
    }
}
