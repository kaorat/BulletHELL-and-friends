import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class BlockGame extends Application {

    private static final int CANVAS_WIDTH = 400;
    private static final int CANVAS_HEIGHT = 400;
    private static final int BLOCK_SIZE = 20;

    private double blockX = CANVAS_WIDTH / 2 - BLOCK_SIZE / 2;
    private double blockY = CANVAS_HEIGHT / 2 - BLOCK_SIZE / 2;

    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;

    private List<Bullet> bullets = new ArrayList<>();
    private long lastFireTime = 0;
    private long fireRate = 200; // Fire rate in milliseconds (2 shots per second)

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Block Game");

        // Create a canvas
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Handle key pressed and released events
        canvas.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case W:
                    wPressed = true;
                    break;
                case A:
                    aPressed = true;
                    break;
                case S:
                    sPressed = true;
                    break;
                case D:
                    dPressed = true;
                    break;
                default:
                    break;
            }
        });

        canvas.setOnKeyReleased(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case W:
                    wPressed = false;
                    break;
                case A:
                    aPressed = false;
                    break;
                case S:
                    sPressed = false;
                    break;
                case D:
                    dPressed = false;
                    break;
                default:
                    break;
            }
        });

        // Create the root pane
        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        // Create the scene
        Scene scene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Request focus on the canvas to receive key events
        canvas.requestFocus();

        // Update block movement and bullet continuously
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(20); // Adjust speed if needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastFireTime > fireRate) {
                    shoot();
                    lastFireTime = currentTime;
                }
                moveBlock();
                moveBullets();
                drawBlock(gc);
            }
        }).start();
    }

    private void moveBlock() {
        double speed = 3; // Adjust speed if needed
        double diagonalSpeed = speed / sqrt(2);

        if (wPressed && dPressed) { // Move up-right
            blockX += diagonalSpeed;
            blockY -= diagonalSpeed;
        } else if (wPressed && aPressed) { // Move up-left
            blockX -= diagonalSpeed;
            blockY -= diagonalSpeed;
        } else if (sPressed && dPressed) { // Move down-right
            blockX += diagonalSpeed;
            blockY += diagonalSpeed;
        } else if (sPressed && aPressed) { // Move down-left
            blockX -= diagonalSpeed;
            blockY += diagonalSpeed;
        } else if (wPressed) { // Move up
            blockY -= speed;
        } else if (aPressed) { // Move left
            blockX -= speed;
        } else if (sPressed) { // Move down
            blockY += speed;
        } else if (dPressed) { // Move right
            blockX += speed;
        }

        // Boundary checks to prevent block from going outside the canvas
        if (blockX < 0) {
            blockX = 0;
        }
        if (blockY < 0) {
            blockY = 0;
        }
        if (blockX + BLOCK_SIZE > CANVAS_WIDTH) {
            blockX = CANVAS_WIDTH - BLOCK_SIZE;
        }
        if (blockY + BLOCK_SIZE > CANVAS_HEIGHT) {
            blockY = CANVAS_HEIGHT - BLOCK_SIZE;
        }
    }

    private void moveBullets() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.moveUp();
            // Remove bullet if it goes out of the canvas
            if (bullet.getBy() < 0) {
                bullets.remove(i);
                i--; // Update the index since we removed an element
            }
        }
    }

    private void shoot() {
        double bulletX = blockX + (double) BLOCK_SIZE / 2; // Bullet starts at center of the block
        double bulletY = blockY;
        bullets.add(new Bullet(bulletX, bulletY));
    }

    private void drawBlock(GraphicsContext gc) {
        // Clear the canvas
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        // Draw the background
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        // Draw the block
        gc.setFill(Color.RED);
        gc.fillRect(blockX, blockY, BLOCK_SIZE, BLOCK_SIZE);
        // Draw the bullets
        gc.setFill(Color.BLACK);
        for (Bullet bullet : bullets) {
            gc.fillRect(bullet.getBx(), bullet.getBy(), 5, 5);
        }
    }

}