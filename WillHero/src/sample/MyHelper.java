package sample;

import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MyHelper implements Runnable{

    public static TranslateTransition myTranslation(Node node, double inX, double inY, double inZ, double duration, int cycleCount, Boolean autoReverse){
        TranslateTransition translator = new TranslateTransition();
        translator.setNode(node);
        translator.setByX(inX);
        translator.setByY(inY);
        translator.setByZ(inZ);
        translator.setDuration(Duration.millis(duration));
        translator.setInterpolator(Interpolator.LINEAR);
        translator.setCycleCount(cycleCount);
        translator.setAutoReverse(autoReverse);
        return translator;
    }

    public static FadeTransition myFade(Node node,double from, double to, double duration, int cycleCount){
        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setCycleCount(cycleCount);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(from);
        fade.setToValue(to);
        return fade;
    }

    public static Timeline myDelay(double duration, int cycleCount){
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(duration),
                (event) -> { }
        ));
        timeline.setCycleCount(cycleCount);
        return timeline;
    }

    private ProgressBar progressBar;
    private Label label;

    public MyHelper(ProgressBar progressBar, Label label){
        this.progressBar = progressBar;
        this.label = label;
    }

    @Override
    public void run() {
        double progress = 0.0;
        while(progress <= 1.0){
            label.setText("Loading ... " );
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            progressBar.setProgress(Math.min(progress+0.1, 1.0));
            progress += 0.1;
        }
    }
}
