import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;


public class Gamebox extends Canvas {

    public Gamebox() {
        super(900, 850);
        System.out.println("MainMenu constructor called");
        draw();
    }

    private void draw() {
        System.out.println("draw method called");
        GraphicsContext gc = getGraphicsContext2D();

        //++++MAIN GACKGROUND++++
        // Load the image (replace "image_file_name" with your image file name)
        Image mainBackground = new Image("file:res/backgroundMaingame.jpeg");

        // Get the width and height of the canvas
        double canvasWidth = getWidth();
        double canvasHeight = getHeight();

        // Calculate the scaling factor for width and height
        double scaleX = canvasWidth / mainBackground.getWidth();
        double scaleY = canvasHeight / mainBackground.getHeight();

        // Use the smaller scaling factor to maintain aspect ratio
        double scale = Math.min(scaleX, scaleY);

        // Calculate the new width and height
        double width = mainBackground.getWidth() * scale;
        double height = mainBackground.getHeight() * scale;

        // Draw the image on the canvas, scaled to fit
        gc.drawImage(mainBackground, 0, 0, width, height);

        //++++MAIN GACKGROUND++++


//        Canvas canvas = new Canvas(400, 400);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//
//        Image img = new Image("file:");
//        gc.drawImage(img, 0, 0);




    }


}
