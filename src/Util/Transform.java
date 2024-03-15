package Util;

public class Transform {
    protected double posX,posY,rot,sclX,sclY;

    public Transform(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.rot = 0;
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
}
