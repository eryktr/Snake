package model;
public class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point translate(int deltaX, int deltaY) {
        return new Point(this.getX() + deltaX, this.getX()+deltaX);
    }

    public boolean equals(Point p) {
        return (x == p.getX() && y == p.getY());
    }
}
