public class Bullet {
    private double bx;
    private double by;
    private String image;

    public Bullet(double bx, double by) {
        this.bx = bx-2;
        this.by = by;
        this.image = "Image/cover.jpg";
    }

    public String getImage() {
        return image;
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
        by -= 1;
    }
}
