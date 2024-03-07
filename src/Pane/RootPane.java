package Pane;

import GameEntity.GameObject;
import Manager.GameObjectHolder;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RootPane extends Canvas {
    private static RootPane instance;

    private RootPane(double width,double height) {
        ///////////////////////
        super(width, height);
        this.setVisible(true);
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane(1290,760);
        return instance;
    }
    public static RootPane getRootPane(double width,double height) {
        if (instance == null)
            instance = new RootPane(width,height);
        return instance;
    }
    public static void paintComponent() {
        GraphicsContext gc = RootPane.getRootPane().getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        for (GameObject entity : GameObjectHolder.getInstance().getEntities()) {
            if (entity.isVisible() && !entity.isDestroyed()) {
                entity.draw(gc);
            }
        }

        // System.out.println("===============");
        // System.out.println("===============");

    }
}