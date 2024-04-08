package Utils;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Text {
    private String text;
    private final Font font;

    private Color fillColor;//default black
    private final Color strokeColor;//default black
    private final double lineWidth;//default 2

    private final double maxWidth;//if null be 0
    private final TextAlignment textAlignment;

    public Text(String text, Font font, Color fillColor) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor=Color.BLACK;
        lineWidth=2;
        maxWidth=0;
        this.textAlignment=TextAlignment.LEFT;
    }
    public Text(String text, Font font, Color fillColor,TextAlignment textAlignment) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor=Color.BLACK;
        lineWidth=2;
        maxWidth=0;
        this.textAlignment=textAlignment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public double getMaxWidth() {
        return maxWidth;
    }
    public void setFillColor(Color color){
        fillColor=color;
    }

    public TextAlignment getTextAlignment() {
        return textAlignment;
    }
}
