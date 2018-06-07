package model.MovingBehavior;

import graphics.Snake;
import model.Point;

public class NotMoving implements MovingBehavior {
    @Override
    public Point move(Snake snake) {
        Point head = snake.getHead();
        return head;
    }
}
