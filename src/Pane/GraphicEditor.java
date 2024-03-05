package Pane;

import javafx.scene.canvas.GraphicsContext;

public abstract class GraphicEditor {
    GraphicsContext graphicsContext;

    public GraphicEditor(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}
