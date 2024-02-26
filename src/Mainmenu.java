import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Mainmenu extends Canvas {

    public Mainmenu() {
        super(330, 750);
        System.out.println("MainMenu constructor called");
        draw();
    }

    private void draw() {

        System.out.println("draw method called");
        GraphicsContext gc = getGraphicsContext2D();

        // Fill the rectangle
        gc.setFill(Color.BROWN);
        gc.fillRect(0, 0, getWidth(), getHeight());

        // Draw the border
        gc.setStroke(Color.BLACK); // Set the color of the border
        gc.setLineWidth(5); // Set the width of the border
        gc.strokeRect(0, 0, getWidth(), getHeight()); // Draw the border
    }
}
