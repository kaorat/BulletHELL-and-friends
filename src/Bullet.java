public class Bullet {
    private double bx;
    private double by;

    public Bullet(double bx, double by) {
        this.bx = bx-2;
        this.by = by;
    }

    public double getBx() {
        return bx;
    }

    public double getBy() {
        return by;
    }

    public void setBx(double bx) {
        this.bx = bx;
    }

    public void setBy(double by) {
        this.by = by;
    }

    public void moveUp() {
        by -= 5;
    }
}
