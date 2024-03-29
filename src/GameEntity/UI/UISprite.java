package GameEntity.UI;

import GameEntity.GameObject;
import Utils.Text;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class UISprite extends GameObject {
    private final String type;
    private Image sprite;
    private Text text;
    //Image
    public UISprite(Image sprite,Transform transform, int z) {
        super(transform, z);
        this.sprite=sprite;
        type="image";
    }
    //Text
    public UISprite(Text text, Transform transform, int z){
        super(transform,z);
        this.text=text;
        type="text";
    }
    //Updatable Text
    @Override
    public void draw(GraphicsContext gc) {
        if(type.equals("image")) gc.drawImage(sprite, transform.getPosX(), transform.getPosY(), sprite.getWidth() * transform.getSclX(), sprite.getHeight() * transform.getSclY());
        else if(type.equals("text")){
            gc.setLineWidth(text.getLinewidth());
            gc.setFill(text.getFillColor());
            gc.setStroke(text.getStrokeColor());
            gc.setFont(text.getFont());
            gc.setTextAlign(text.getTextAlignment());
            if(text.getMaxwidth() ==0){
                gc.fillText(text.getText(), transform.getPosX(), transform.getPosY());
            }
            else {
                gc.fillText(text.getText(), transform.getPosX(), transform.getPosY(), text.getMaxwidth());
            }
        }
    }

    @Override
    public void onUpdate() {

    }

    public String getType() {
        return type;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
