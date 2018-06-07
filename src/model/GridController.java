package model;

import java.util.Random;

public class GridController {
    private final int rows;
    private final int columns;
    private Random random;

    public GridController(final int rows, final int columns) {
        random = new Random();
        this.rows = rows;
        this.columns = columns;
    }

    public Point getRandomPoint() {
        return new Point(random.nextInt(rows-1), random.nextInt(columns-1));
    }

    public Point wrapPoint(Point point) {
        int x = point.getX();
        int y = point.getY();
        if (x >= columns)   x = 0;
        if (y >= rows)      y = 0;
        if (x < 0)          x = columns - 1;
        if (y < 0)          y = rows - 1;

        return new Point(x,y);
    }


}
