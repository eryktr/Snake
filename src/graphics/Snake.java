package graphics;

import javafx.scene.paint.Color;
import model.Grid;
import model.MovingBehavior.MovingBehavior;
import model.MovingBehavior.MovingRight;
import model.Point;

import java.util.ArrayList;

public class Snake {
    public final Color aliveColor = Color.LIGHTCYAN;
    public final Color deadColor = Color.RED;
    private Point head;
    private ArrayList<Point> points;
    private int length;
    private MovingBehavior movingBehavior;
    private Grid grid;


    public Snake(Grid grid, Point initialPoint) {
        points = new ArrayList<>();
        points.add(initialPoint);
        head = initialPoint;
        movingBehavior = new MovingRight();
        this.grid = grid;
    }

    public void updatePosition(Point newPoint) {
        if(!isAlive(newPoint)) {
            System.out.println("You lost!");
        }
    }

    public boolean isAlive(Point point) {
        for(int i = 0; i < points.size() - 1; i++) {
            if(points.get(i).equals(point)) {
                return false;
            }
        }
        return true;
    }

    public Point getHead() {
        return head;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setMovingBehavior(MovingBehavior behavior) {
        movingBehavior = behavior;
    }

}


