package model.MovingBehavior;

import graphics.Snake;
import model.Point;

public interface MovingBehavior {
    Point move(Snake snake);
}
