package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GridPainter {
    private GraphicsContext gc;

    public GridPainter(GraphicsContext gc) {
        this.gc = gc;
    }

    public void drawRectangle(int x, int y, int width, int height, Color color) {
        gc.setFill(color);
        gc.fillRect(x,y, width, height);
    }

}
