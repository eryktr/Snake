package model.MovingBehavior;

import graphics.Snake;
import model.Point;

import java.util.ArrayList;

public class MovingDown implements MovingBehavior {
    @Override
    public Point move(Snake snake) {
        return snake.getHead().translate(0, 1);
    }
}
