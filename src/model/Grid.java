package model;

import graphics.Food;
import graphics.Snake;
import window.GameWindow;

import java.util.Random;

public class Grid {
    private final int side = 10;
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
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public int getSide() {
        return side;
    }
}


