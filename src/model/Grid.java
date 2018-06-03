package model;

import graphics.Food;
import graphics.Snake;
import window.GameWindow;

import java.util.Random;

public class Grid {
    private static final int side = 10;
    private final int rows;
    private final int columns;
    private final GridController gridController;
    private Random random;
    private Snake snake;
    private Food food;

    public Grid(GameWindow gameWindow) {
        rows = (int)gameWindow.getHeight() / side;
        columns = (int)gameWindow.getWidth() / side;
        random = new Random();
        gridController = new GridController(rows, columns);
        snake = new Snake(this, new Point(side * rows/2, side * columns/2));
        food = new Food(getFoodPoint());


    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public Point getFoodPoint() {
        Point randomPoint = gridController.getRandomPoint();
        while(snake.getPoints().contains(randomPoint)) {
            randomPoint = gridController.getRandomPoint();
        }

        return randomPoint;
    }

    public static int getSide() {
        return side;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}


