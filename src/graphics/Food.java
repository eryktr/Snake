package graphics;

import javafx.scene.paint.Color;
import model.Point;

public class Food {
    private Point point;
    public static final Color color = Color.PINK;

    public Food(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }
}
