package graphics;

import javafx.scene.paint.Color;
import model.Grid;
import model.MovingBehavior.MovingBehavior;
import model.Point;

import java.util.ArrayList;

public class Snake {
    private final Color aliveColor = Color.LIGHTCYAN;
    private final Color deadColor = Color.RED;
    private Point head;
    private ArrayList<Point> points;
    private int length;
    private MovingBehavior movingBehavior;


    public Snake(Grid grid, Point initialPoint) {
    }

    public void updatePosition() {

    }

    public Point getHead() {
        return head;
    }

    private ArrayList<Point> getPoints() {
        return points;
    }

    public void setMovingBehavior(MovingBehavior behavior) {
        movingBehavior = behavior;
    }

}


