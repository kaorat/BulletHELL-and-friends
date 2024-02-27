package Pane;

import Manager.SceneManager;
import javafx.scene.layout.StackPane;

public class RootPane extends StackPane {
    private static RootPane instance;

    private RootPane() {
        ///////////////////////
        SceneManager.setRootPane(this);
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}