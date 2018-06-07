package model;

public class GameLoop implements Runnable {
    private volatile boolean continueGame;
    private Grid grid;

    public GameLoop(Grid grid) {
        this.grid = grid;
        continueGame = true;
    }
    @Override
    public synchronized void run() {
        while(continueGame) {
            grid.getSnake().updatePosition();
            try {
                wait(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeGameState() {
        continueGame = !continueGame;
    }
}
