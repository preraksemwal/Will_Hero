package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    private Stage stage;

    @FXML
    private AnchorPane scenePane;
    @FXML
    private ImageView newGameImageView;
    @FXML
    private ImageView loadSavedGameImageView;
    @FXML
    private ImageView exitGameImageView;
    @FXML
    private ImageView movingImage;
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
    private Line line7;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MyHelper.myFade(newGameImageView,0,1,500,1).play();
        MyHelper.myFade(loadSavedGameImageView,0,1,700,1).play();
        MyHelper.myFade(exitGameImageView,0,1,900,1).play();

        FadeTransition ft = MyHelper.myFade(movingImage,0.5,1,700,-1);
        TranslateTransition tt1 = MyHelper.myTranslation(movingImage,0,150,0,1500,-1,true);
        TranslateTransition tt2 = MyHelper.myTranslation(movingImage,20,0,0,3000,-1,true);
        TranslateTransition tt3 = MyHelper.myTranslation(movingImage,50,0,0,500,-1,true);
        ParallelTransition parallelTransition = new ParallelTransition(movingImage,ft,tt1,tt3);
        parallelTransition.play();

        MyHelper.myTranslation(line1,-400,0,0,30,-1,false).play();
        MyHelper.myTranslation(line2,-400,0,0,30,-1,false).play();
        MyHelper.myTranslation(line3,-400,0,0,50,-1,false).play();
        MyHelper.myTranslation(line4,-400,0,0,10,-1,false).play();
        MyHelper.myTranslation(line5,-400,0,0,100,-1,false).play();
        MyHelper.myTranslation(line6,-400,0,0,70,-1,false).play();
        MyHelper.myTranslation(line7,-400,0,0,80,-1,false).play();

    }

    public void exitGame(){
        MyHelper.myFade(exitGameImageView,1,0,250,1).play();
        MyHelper.myFade(exitGameImageView,0,1,250,1).play();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Game");
        alert.setHeaderText("Sure you want to Exit ?");
        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage)scenePane.getScene().getWindow();
            System.out.println("logged out");
            stage.close();
        }
    }

    public void loadGame(){
        MyHelper.myFade(loadSavedGameImageView,1,0,200,1).play();
        MyHelper.myFade(loadSavedGameImageView,0,1,200,1).play();

    }

    public void newGame(){
        MyHelper.myFade(newGameImageView,1,0,250,1).play();
        MyHelper.myFade(newGameImageView,0,1,250,1).play();

        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        }catch (IOException e){
            e.printStackTrace();
        }
        stage = (Stage)((Node)newGameImageView).getScene().getWindow();
        Scene scene = new Scene(root,690,444);
        stage.setScene(scene);
        stage.show();

    }

}
