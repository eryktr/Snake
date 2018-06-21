package model;

import javafx.application.Platform;

public class GameLoop implements Runnable {
    private volatile boolean continueGame;
    private Grid grid;

    public GameLoop(Grid grid) {
        this.grid = grid;
        continueGame = true;

    }
    @Override
    public synchronized void run() {
        Platform.runLater(() -> grid.getWindow().getStateLabel().setText(""));
        while(continueGame) {
            grid.getSnake().updatePosition();
            try {
                wait(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(grid.getWindow().getGameMode() == GameMode.DEAD) {
            Platform.runLater( () -> {
                grid.getWindow().getStateLabel().setText("You have died! Press SPACE to start over");
                grid.getWindow().getBlinker().restart();
                (new Thread(grid.getWindow().getBlinker())).start();
            });
        }
    }

    public void changeGameState() {
        continueGame = !continueGame;
    }
}
