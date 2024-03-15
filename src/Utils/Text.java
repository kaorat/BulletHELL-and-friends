package Utils;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Text {
    private String text;
    private Font font;

    private Color fillColor;//default black
    private Color strokeColor;//default black
    private double linewidth;//default 2

    private double maxwidth;//if null be 0
    private TextAlignment textAlignment;

    public Text(String text, Font font) {
        this.text = text;
        this.font = font;
        this.fillColor=Color.BLACK;
        this.strokeColor=Color.BLACK;
        linewidth=2;
        maxwidth=0;
        this.textAlignment=TextAlignment.LEFT;
    }

    public Text(String text, Font font, Color fillColor) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor=Color.BLACK;
        linewidth=2;
        maxwidth=0;
        this.textAlignment=TextAlignment.LEFT;
    }

    public Text(String text, Font font, Color fillColor, double linewidth) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.linewidth = linewidth;
        this.strokeColor=Color.BLACK;
        maxwidth=0;
        this.textAlignment=TextAlignment.LEFT;
    }

    public Text(String text, Font font, Color fillColor, Color strokeColor) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        linewidth=2;
        maxwidth=0;
        this.textAlignment=TextAlignment.LEFT;
    }

    public Text(String text, Font font, Color fillColor, Color strokeColor, double linewidth) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.linewidth = linewidth;
        maxwidth=0;
        this.textAlignment=TextAlignment.LEFT;
    }

    public Text(String text, Font font, Color fillColor, Color strokeColor, double linewidth, double maxwidth) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.linewidth = linewidth;
        this.maxwidth = maxwidth;
        this.textAlignment=TextAlignment.LEFT;
    }
    public Text(String text, Font font,TextAlignment textAlignment) {
        this.text = text;
        this.font = font;
        this.fillColor=Color.BLACK;
        this.strokeColor=Color.BLACK;
        linewidth=2;
        maxwidth=0;
        this.textAlignment=textAlignment;
    }

    public Text(String text, Font font, Color fillColor,TextAlignment textAlignment) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor=Color.BLACK;
        linewidth=2;
        maxwidth=0;
        this.textAlignment=textAlignment;
    }

    public Text(String text, Font font, Color fillColor, double linewidth,TextAlignment textAlignment) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.linewidth = linewidth;
        this.strokeColor=Color.BLACK;
        maxwidth=0;
        this.textAlignment=textAlignment;
    }

    public Text(String text, Font font, Color fillColor, Color strokeColor,TextAlignment textAlignment) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        linewidth=2;
        maxwidth=0;
        this.textAlignment=textAlignment;
    }

    public Text(String text, Font font, Color fillColor, Color strokeColor, double linewidth,TextAlignment textAlignment) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.linewidth = linewidth;
        maxwidth=0;
        this.textAlignment=textAlignment;
    }

    public Text(String text, Font font, Color fillColor, Color strokeColor, double linewidth, double maxwidth,TextAlignment textAlignment) {
        this.text = text;
        this.font = font;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.linewidth = linewidth;
        this.maxwidth = maxwidth;
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

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public double getLinewidth() {
        return linewidth;
    }

    public void setLinewidth(double linewidth) {
        this.linewidth = linewidth;
    }

    public double getMaxwidth() {
        return maxwidth;
    }

    public void setMaxwidth(double maxwidth) {
        this.maxwidth = maxwidth;
    }

    public TextAlignment getTextAlignment() {
        return textAlignment;
    }

    public void setTextAlignment(TextAlignment textAlignment) {
        this.textAlignment = textAlignment;
    }
}
