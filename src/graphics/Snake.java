package graphics;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import model.GameLoop;
import model.Grid;
import model.MovingBehavior.MovingBehavior;
import model.MovingBehavior.MovingRight;
import model.Point;
import window.GameWindow;

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

    public void updatePosition() {
        Point newPoint = grid.getGridController().wrapPoint(movingBehavior.move(this));
        if (isAlive(newPoint)) {
            if(newPoint.equals(grid.getFood().getPoint())) {
                expand(newPoint);
            }
            shift(newPoint);
        }
        else {
            for(Point p: getPoints()) {
                Platform.runLater(() -> grid.getPainter().drawRectangle(p, deadColor) );
            }
            grid.getWindow().getGameLoop().changeGameState();
            grid.getWindow().getGameLoop().notify();
        }
    }

    public boolean isAlive(Point point) {
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).equals(point)) {
                System.out.println("false");
                return false;

            }
        }
        return true;
    }

    public void shift(Point newPoint) {

        Platform.runLater(() -> {
            getPoints().add(newPoint);
            grid.getPainter().drawRectangle(newPoint, aliveColor);
            grid.getPainter().drawRectangle(getPoints().get(0), Color.BLACK);
            getPoints().remove(0);

        });
        head = newPoint;


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

    public MovingBehavior getMovingBehavior() {
        return movingBehavior;
    }

    public void expand(Point newPoint) {
        getPoints().add(0, getPoints().get(0));
        grid.setNewFood();
    }

}


