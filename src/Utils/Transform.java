package Utils;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import GameEntity.GameObject;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Transform {
    private static final String UI_FOLDER = "UI/";

    // ---- Suchas comment: so 2 rots huh,one for visual, another for movement-----
    protected double posX,posY,rot,sclX,sclY;



    public Transform(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.rot = 0;
        this.sclX = 1;
        this.sclY = 1;
    }

    public Transform(double posX, double posY, double rot) {
        this.posX = posX;
        this.posY = posY;
        this.rot = rot;
        this.sclX = 1;
        this.sclY = 1;
    }

    public Transform(double posX, double posY, double sclX, double sclY) {
        this.posX = posX;
        this.posY = posY;
        this.rot = 0;
        this.sclX = sclX;
        this.sclY = sclY;
    }

    public Transform(double posX, double posY, double rot, double sclX, double sclY) {
        this.posX = posX;
        this.posY = posY;
        this.rot = rot;
        this.sclX = sclX;
        this.sclY = sclY;
    }

    public Point2D calculateTranslation(double factor) {

        double angleRad = Math.toRadians(rot);
        double deltaX = factor * Math.cos(angleRad);
        double deltaY = factor * Math.sin(angleRad);

        return new Point2D(deltaX, deltaY); // translations
    }

    public void translate(double speed) {
        Point2D translation = calculateTranslation(speed);
        posX += translation.getX();
        posY += translation.getY();
    }


    public static boolean checkCollide(Bounds b1, Bounds b2){
        // draw here the bounds of the object
        return b1.intersects(b2);
    }
    public static boolean checkContain(Bounds b1, Bounds b2){
        return b1.contains(b2);
    }
        public double getPosX() {
        return posX;
    }

    public static double calculateAngleToTarget(Transform from, Transform to) {
        return Math.toDegrees(Math.atan2(to.getPosY() - from.getPosY(), to.getPosX() - from.getPosX()));
    }
    public static double calculateDistanceToTarget(Transform from, Transform to) {
        return Math.sqrt(Math.pow(to.getPosX() - from.getPosX(), 2) + Math.pow(to.getPosY() - from.getPosY(), 2));
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getRot() {
        return rot;
    }

    public void setRot(double rot) {
        this.rot = rot;
    }

    public double getSclX() {
        return sclX;
    }

    public void setSclX(double sclX) {
        this.sclX = sclX;
    }

    public double getSclY() {
        return sclY;
    }

    public void setSclY(double sclY) {
        this.sclY = sclY;
    }


}
