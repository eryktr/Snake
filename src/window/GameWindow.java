package window;

import graphics.Blinker;
import graphics.GridPainter;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Grid;

public class GameWindow extends Application {

    private GraphicsContext context;
    private Grid grid;

    private Scene scene;
    private Canvas gameCanvas;
    private Label  stateLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane= new Pane();

        stateLabel = new Label("Press SPACE to start the game");
        stateLabel.setStyle("-fx-font-size: 20");
        stateLabel.setTextFill(Color.RED);
        Blinker blinker = new Blinker(stateLabel);
        (new Thread(blinker)).start();

        Canvas gameCanvas = new Canvas(600, 600);
        pane.setStyle("-fx-background-color: black");

        pane.getChildren().addAll(gameCanvas, stateLabel);
        context = gameCanvas.getGraphicsContext2D();
        scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GraphicsContext getContext() {
        return context;
    }

    public double getWidth() {
        return scene.getWidth();
    }

    public double getHeight() {
        return scene.getHeight();
    }
}
