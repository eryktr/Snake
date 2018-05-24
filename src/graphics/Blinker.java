package graphics;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Blinker implements Runnable {
    private Label label;
    private boolean continueThread = true;

    public Blinker(Label label) {
        this.label = label;
    }

    public synchronized void run() {
        while(continueThread) {
            Color currentColor = (Color) label.getTextFill();
            int red =  (int) ( currentColor.getRed() * 255);
            int green = (int)( currentColor.getGreen() * 255);
            int blue = (int) (currentColor.getBlue() * 255);

            int newRed = (red+1) % 255;
            int newGreen = (green+1) % 255;
            int newBlue = (blue+1) % 255;

            Color newColor = Color.rgb(newRed, newGreen, newBlue);
            Platform.runLater( () -> label.setTextFill(newColor));
            try {
                wait(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
