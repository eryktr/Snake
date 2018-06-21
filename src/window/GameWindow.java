package window;

import graphics.Blinker;
import graphics.Food;
import graphics.GridPainter;
import graphics.Snake;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GameLoop;
import model.GameMode;
import model.Grid;
import model.MovingBehavior.MovingDown;
import model.MovingBehavior.MovingLeft;
import model.MovingBehavior.MovingRight;
import model.MovingBehavior.MovingUp;

import static model.GameMode.DEAD;
import static model.GameMode.MENU;
import static model.GameMode.RUNNING;

public class GameWindow extends Application {

    private GraphicsContext context;
    private GridPainter painter;
    private GameMode gameMode = MENU;

    private Scene scene;
    private Canvas gameCanvas;
    private Label  stateLabel, scoreLabel;

    private Grid grid;
    private GameLoop loop;

    private Blinker blinker;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane= new Pane();

        stateLabel = new Label("Press SPACE to start the game");
        stateLabel.setStyle("-fx-font-size: 20");
        stateLabel.setTextFill(Color.RED);
        scoreLabel = new Label("Score: ");
        scoreLabel.setStyle("-fx-font-size: 20");
        scoreLabel.setTextFill(Color.RED);
        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(stateLabel, scoreLabel);
        blinker = new Blinker(stateLabel);
        (new Thread(blinker)).start();

        Canvas gameCanvas = new Canvas(600, 600);
        pane.setStyle("-fx-background-color: black");

        pane.getChildren().addAll(gameCanvas, labelVBox);
        context = gameCanvas.getGraphicsContext2D();
        painter = new GridPainter(context);
        scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed( event ->  {
            if(gameMode == MENU) {
                switch (event.getCode()) {
                    case SPACE:
                        blinker.stop();
                        startGame();
                        break;
                }
            }
            else if(gameMode == RUNNING) {
                switch (event.getCode()) {
                    case UP:
                        grid.getSnake().setMovingBehavior(new MovingUp());
                        break;

                    case DOWN:
                        grid.getSnake().setMovingBehavior(new MovingDown());
                        break;

                    case LEFT:
                        grid.getSnake().setMovingBehavior(new MovingLeft());
                        break;

                    case RIGHT:
                        grid.getSnake().setMovingBehavior(new MovingRight());
                        break;
                }
            }
            else if(gameMode == DEAD) {
                switch (event.getCode()) {
                    case SPACE:
                        startGame();
                        blinker.stop();
                        break;
                }
            }
        });
    }

    public void startGame() {
        if(painter != null && grid != null) {
            painter.getGraphicsContext().clearRect(0, 0, 600, 600);
            scoreLabel.setText("Score: ");
        }
        grid = new Grid(this);
        painter.drawRectangle(grid.getSnake().getHead(), grid.getSnake().aliveColor);
        painter.drawRectangle(grid.getFood().getPoint(), Food.color);
        gameMode = GameMode.RUNNING;
        loop = new GameLoop(grid);
        (new Thread(loop)).start();

    }
    public GraphicsContext getContext()  { return context; }
    public double getWidth()             { return scene.getWidth(); }
    public double getHeight()            { return scene.getHeight(); }
    public GameMode getGameMode()        { return gameMode; }
    public GridPainter getPainter()      { return painter; }
    public GameLoop getGameLoop()        { return loop;}
    public Label getStateLabel()         { return stateLabel; }
    public void  setGameOver()           { gameMode = DEAD;}
    public Blinker getBlinker()          { return blinker;}
    public Label getScoreLabel()           { return scoreLabel;}

}
