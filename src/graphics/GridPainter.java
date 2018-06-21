package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Grid;
import model.Point;

public class GridPainter {
    private GraphicsContext gc;

    public GridPainter(GraphicsContext gc) {
        this.gc = gc;
    }

    public void drawRectangle(int x, int y, int width, int height, Color color) {
        gc.setFill(color);
        gc.fillRect(x,y, width, height);
    }

    public void drawRectangle(Point point, Color color) {
        gc.setFill(color);
        gc.fillRect(point.getX() * Grid.getSide(), point.getY() * Grid.getSide(), Grid.getSide(), Grid.getSide());
    }

    public GraphicsContext getGraphicsContext() {
        return gc;
    }


}
