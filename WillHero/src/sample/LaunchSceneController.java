package sample;

import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LaunchSceneController implements Initializable {

    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private ImageView myLogo;
    @FXML
    private Label myStatusLabel;
    @FXML
    private Label myLabel;
    @FXML
    private Rectangle myBackground;
    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private Circle yellowBall;
    @FXML
    private Circle blueBall;
    @FXML
    private Circle redBall;
    @FXML
    private Circle whiteBall;
    @FXML
    private Circle greenBall;
    @FXML
    private Circle purpleBall;

    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Line line5;
    @FXML
    private Line line6;

    @FXML
    private Rectangle myDummyRectangle;

    private Parent root;
    private Stage stage;
    private Scene scene;

    private final ArrayList<TranslateTransition> circleTranslators = new ArrayList<>();
    private double progress = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Hero
        MyHelper.myTranslation(myLogo,150,0,0,2000,-1,true).play();

        // Balls
        MyHelper.myTranslation(redBall,-525,0,0,200,-1,false).play();
        MyHelper.myTranslation(blueBall,-525,0,0,200,-1,false).play();
        MyHelper.myTranslation(yellowBall,-525,0,0,200,-1,false).play();
        MyHelper.myTranslation(purpleBall,-525,0,0,200,-1,false).play();
        MyHelper.myTranslation(greenBall,-525,0,0,200,-1,false).play();
        MyHelper.myTranslation(whiteBall,-525,0,0,200,-1,false).play();

        // Lines
        MyHelper.myTranslation(line1,-400,0,0,200,-1,false).play();
        MyHelper.myTranslation(line2,-400,0,0,200,-1,false).play();
        MyHelper.myTranslation(line3,-400,0,0,200,-1,false).play();
        MyHelper.myTranslation(line4,-400,0,0,200,-1,false).play();
        MyHelper.myTranslation(line5,-400,0,0,200,-1,false).play();
        MyHelper.myTranslation(line6,-400,0,0,200,-1,false).play();
    }

    public void loading() throws InterruptedException{
        myProgressBar.setStyle("-fx-accent: #c41b35;");
        myProgressBar.setOpacity(1.0);
        myLabel.setOpacity(0.0);
        myStatusLabel.setOpacity(1.0);

        MyHelper myHelper = new MyHelper(myProgressBar, myStatusLabel);
        Thread myProgressThread = new Thread(myHelper);
        myProgressThread.start();

        gotoMenu();
    }

    public void gotoMenu(){

        myDummyRectangle.setOnMouseMoved((mouseEvent -> {
                try{
                    root = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
                }catch (IOException e){
                    e.printStackTrace();
                }
                stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                scene = new Scene(root,690,444);
                stage.setScene(scene);
                stage.show();
        }));
    }
}