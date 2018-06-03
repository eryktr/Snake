package model.MovingBehavior;

import graphics.Snake;
import model.Point;

import java.util.ArrayList;

public class MovingUp implements MovingBehavior {
    @Override
    public void move(Snake snake) {
        ArrayList<Point> points = snake.getPoints();
        points.add(snake.getHead().translate(0, 1));
        snake.getPoints().remove(0);
    }
}
