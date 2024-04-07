package Manager;

import Pane.*;
import Utils.Track;
import Utils.Updatable;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

public class SceneManager {
    public static int currentScene;
    public enum GameState{
        normal,
        boss
    }
    public static GameState currentState;
    public static ArrayList<Updatable> updatables;
    private static GraphicEditor currentPage;
    private static GraphicEditor bossPage;

    public static void GotoGameScene(){
        updatables=new ArrayList<>();
        currentScene=1;
        SceneManager.updatables.add(GameObjectHolder.getInstance());

        //GraphicEditor
        SceneManager.updatables.add(new GameplayEditor(RootPane.getRootPane().getGraphicsContext2D()));
        SceneManager.updatables.add(new GameSideUIEditor(RootPane.getRootPane().getGraphicsContext2D()));

        //Managers
        SceneManager.updatables.add(BossManager.getInstance());
        SceneManager.updatables.add(BulletManager.getInstance());
        SceneManager.updatables.add(EnemyManager.getInstance());
        SceneManager.updatables.add(PlayerManager.getInstance());
        SceneManager.updatables.add(ItemManager.getInstance());
        SceneManager.updatables.add(StatManager.getInstance());
        currentState=GameState.normal;
        Track.bgm.setCycleCount(AudioClip.INDEFINITE);
        Track.bgm.setVolume(0.2);
        Track.bgm.play();
    }
    public static void update(){
        for (Updatable updatable : updatables) {
            updatable.onUpdate();
        }
        if(currentPage!=null) {
            currentPage.onUpdate();
        }
        if(bossPage!=null){
            bossPage.onUpdate();
        }
    }

    public static void setCurrentPage(GraphicEditor currentPage) {
        if(SceneManager.currentPage != null){
            SceneManager.currentPage.clear();
        }
        SceneManager.currentPage = currentPage;
    }
    public static void ActivatedBossPage(GraphicEditor bossPage){
        currentState=GameState.boss;
        SceneManager.bossPage=bossPage;

        Track.bgm.stop();
        Track.bossTheme.setCycleCount(AudioClip.INDEFINITE);
        Track.bossTheme.setVolume(0.5);
        Track.bossTheme.play();
        EnemyManager.getInstance().clearEnemy();
        BulletManager.getInstance().clearBullets();
    }
    public static void DeActivatedBossPage(){
        currentState=GameState.normal;
        BossManager.getInstance().removeBoss();
        SceneManager.bossPage.clear();
        SceneManager.bossPage=null;
        BulletManager.getInstance().clearBullets();
        Track.bossTheme.stop();
        Track.bgm.setCycleCount(AudioClip.INDEFINITE);
        Track.bgm.setVolume(0.2);
        Track.bgm.play();
    }

}
