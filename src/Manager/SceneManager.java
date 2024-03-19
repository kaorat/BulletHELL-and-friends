package Manager;

import Pane.GameSideUIEditor;
import Pane.GameplayEditor;
import Pane.GraphicEditor;
import Pane.RootPane;
import Utils.Updatable;

import java.util.ArrayList;

public class SceneManager {
    public static int currentScene;
    public static ArrayList<Updatable> updatables=new ArrayList<>();
    public static int getCurrentScene() {
        return currentScene;
    }
    public static void GotoGameScene(){
        currentScene=1;
        SceneManager.updatables.clear();
        //GraphicEditor
        SceneManager.updatables.add(new GameplayEditor(RootPane.getRootPane().getGraphicsContext2D()));
        SceneManager.updatables.add(new GameSideUIEditor(RootPane.getRootPane().getGraphicsContext2D()));
        //Managers
        SceneManager.updatables.add(BossManager.getInstance());
        SceneManager.updatables.add(BulletManager.getInstance());
        SceneManager.updatables.add(EnemyManager.getInstance());
        SceneManager.updatables.add(PlayerManager.getInstance());
        SceneManager.updatables.add(GameObjectHolder.getInstance());
    }
    public static void update(){
        for (Updatable updatable : updatables) {
            updatable.onUpdate();
        }
    }
}
