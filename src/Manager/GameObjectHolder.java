package Manager;

import GameEntity.GameObject;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameObjectHolder {
    private static final GameObjectHolder instance = new GameObjectHolder();

    private List<GameObject> entities;
    private Comparator<GameObject> comparator;
    public static Image mapSprite;
    public static Image mineSprite;
    public static AudioClip explosionSound;

    static {
        loadResource();
    }

    public GameObjectHolder() {
        entities = new ArrayList<GameObject>();
        comparator = (GameObject o1, GameObject o2) -> {
            if (o1.getZ() > o2.getZ())
                return 1;
            return -1;
        };
    }

    public static GameObjectHolder getInstance() {
        return instance;
    }

    public static void loadResource() {
        //mapSprite = new Image(ClassLoader.getSystemResource("Map.png").toString());
        //mineSprite = new Image(ClassLoader.getSystemResource("Mine.png").toString());
        //explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
    }

    public void add(GameObject entity) {
//        System.out.println("add");
        entities.add(entity);
        entities.sort(comparator);
        /*
        for(GameObject x: entities){
            if(x instanceof Tank) System.out.println("tank");
            if(x instanceof Mine) System.out.println("mine");
            if(x instanceof Field) System.out.println("field");

        }*/
    }

    public void update() {
        System.out.println(entities.size());
        for (int i = entities.size() - 1; i >= 0; i--) {
            if (entities.get(i).isDestroyed())
                entities.remove(i);
            else entities.get(i).onUpdate();
        }
    }

    public List<GameObject> getEntities() {
        return entities;
    }
}
