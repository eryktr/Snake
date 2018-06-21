package model;

import graphics.Food;
import graphics.GridPainter;
import graphics.Snake;
import window.GameWindow;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
    private static final int side = 10;
    private final int rows;
    private final int columns;
    private int score;
    private final GridController gridController;
    private Random random;
    private Snake snake;
    private Food food;
    private GridPainter painter;
    private GameWindow window;

    public Grid(GameWindow gameWindow) {
        window = gameWindow;
        rows = (int)gameWindow.getHeight() / side;
        columns = (int)gameWindow.getWidth() / side;
        random = new Random();
        gridController = new GridController(rows, columns);
        snake = new Snake(this, new Point(rows/2,  columns/2));
        food = new Food(getFoodPoint());
        painter = gameWindow.getPainter();
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public Point getFoodPoint() {
        Point randomPoint = gridController.getRandomPoint();
        while(contains(snake.getPoints(), randomPoint)) {
            randomPoint = gridController.getRandomPoint();
        }

        return randomPoint;
    }

    public static int getSide() {
        return side;
    }
    public GridController getGridController() {return gridController;}
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    public GridPainter getPainter() {return painter;}
    public void setNewFood() {
        food = new Food(getFoodPoint());
        painter.drawRectangle(food.getPoint(), Food.color);
    }

    public static boolean contains(ArrayList<Point> list, Point point) {
        for(Point p : list) {
            if(p.equals(point)) {
                return true;
            }
        }

        return false;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score = score + 100;
    }
    public GameWindow getWindow() {return window;}
}


