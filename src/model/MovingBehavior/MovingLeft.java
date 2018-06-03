package model.MovingBehavior;

import graphics.Snake;
import model.Point;

import java.util.ArrayList;

public class MovingLeft implements MovingBehavior {
    @Override
    public void move(Snake snake) {
        ArrayList<Point> points = snake.getPoints();
        points.add(snake.getHead().translate(-1, 0));
        snake.getPoints().remove(0);
    }
}
