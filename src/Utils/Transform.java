package Utils;

import GameEntity.GameObject;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class Transform {
    protected double posX, posY, rot, sclX, sclY, speed, maxSpeed, accel;


    public Transform(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.rot = 0;
        this.sclX = 1;
        this.sclY = 1;
        this.speed = 0;
        this.maxSpeed = 0;
        this.accel = 0;
    }

    public Transform(double posX, double posY, double rot) {
        this.posX = posX;
        this.posY = posY;
        this.rot = rot;
        this.sclX = 1;
        this.sclY = 1;
        this.speed = 0;
        this.maxSpeed = 0;
        this.accel = 0;
    }

    public Transform(double posX, double posY, double sclX, double sclY) {
        this.posX = posX;
        this.posY = posY;
        this.rot = 0;
        this.sclX = sclX;
        this.sclY = sclY;
        this.speed = 0;
        this.maxSpeed = 0;
        this.accel = 0;
    }

    public Transform(double posX, double posY, double rot, double sclX, double sclY) {
        this.posX = posX;
        this.posY = posY;
        this.rot = rot;
        this.sclX = sclX;
        this.sclY = sclY;
        this.speed = 0;
        this.maxSpeed = 0;
        this.accel = 0;
    }

    public static boolean checkCollide(Bounds b1, Bounds b2) {
        // draw here the bounds of the object
        return b1.intersects(b2);
    }

    public static double calculateAngleToTarget(Transform from, Bounds to) {

        return Math.toDegrees(Math.atan2(to.getMinY() - from.getPosY(), to.getMinX() - from.getPosX()));
    }

    public static double calculateAngleToTarget(Transform from, Transform to) {

        return Math.toDegrees(Math.atan2(to.getPosY() - from.getPosY(), to.getPosX() - from.getPosX()));
    }

    public static double calculateDistanceToTarget(Transform from, Transform to) {
        return Math.sqrt(Math.pow(to.getPosX() - from.getPosX(), 2) + Math.pow(to.getPosY() - from.getPosY(), 2));
    }

    public static Point2D centerPos(GameObject obj) {
        double x = obj.getTransform().getPosX() + (obj.getImage().getWidth() * obj.getTransform().getSclX()) / 2;
        double y = obj.getTransform().getPosY() + (obj.getImage().getHeight() * obj.getTransform().getSclY()) / 2;
        return new Point2D(x, y);
    }

    public Point2D calculateTranslation(double factor) {

        double angleRad = Math.toRadians(rot);
        double deltaX = factor * Math.cos(angleRad) * Config.fpsCalibration;
        double deltaY = factor * Math.sin(angleRad) * Config.fpsCalibration;

        return new Point2D(deltaX, deltaY); // translations
    }

    private void accelerate() {
        if (maxSpeed > speed && accel > 0) {
            speed += accel * Config.fpsCalibration;
            if (speed > maxSpeed) speed = maxSpeed;
        } else if (maxSpeed < speed && accel < 0) {
            speed += accel * Config.fpsCalibration;
            if (speed < maxSpeed) speed = maxSpeed;
        }
    }

    public void translate() {
        Point2D translation = calculateTranslation(speed);
        posX += translation.getX();
        posY += translation.getY();
        accelerate();
    }

    public void translate(double speed) {
        this.speed = speed;
        Point2D translation = calculateTranslation(speed);
        posX += translation.getX();
        posY += translation.getY();
        accelerate();
    }

    public void translateToPositionInMilliSecond(double x, double y, double frame) {
        //System.out.println(x+" "+y);
        rot = calculateAngleToTarget(new Transform(posX, posY), new Transform(x, y));
        speed = (calculateDistanceToTarget(new Transform(posX, posY), new Transform(x, y)) / frame) * 6.8;
        double startFrame = System.currentTimeMillis();
        new AnimationTimer() {
            public void handle(long now) {
                if (System.currentTimeMillis() - startFrame > frame) {
                    this.stop();
                }
                translate();
            }
        }.start();
    }

    public double getPosX() {
        return posX;
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

    public void setScl(double sclX, double sclY) {
        this.sclX = sclX;
        this.sclY = sclY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAccel(double accel) {
        this.accel = accel;
    }
}
