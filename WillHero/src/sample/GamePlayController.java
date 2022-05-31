package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {

    @FXML
    private Rectangle dummy1;

    @FXML
    private ImageView dummy2;

    @FXML
    private ImageView dummy3;

    @FXML
    private ImageView dummy4;

    @FXML
    private Label dummy5;

    @FXML
    private Rectangle dummy6;

    @FXML
    private ImageView myChest;

    @FXML
    private Label myCoinCount;

    @FXML
    private ImageView myHero;

    @FXML
    private ImageView myIslandView1;

    @FXML
    private ImageView myIslandView2;

    @FXML
    private ImageView myIslandView3;

    @FXML
    private ImageView myOrc;

    @FXML
    private Label myScore;

    @FXML
    private ImageView myTNT;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private final ArrayList<Image> islands = new ArrayList<>();   // all 4 island images
    private final ArrayList<ImageView> islandViews = new ArrayList<>();   // total three image views
    private final ArrayList<Timeline> timelines = new ArrayList<>();
    private final ArrayList<Node> moveablesOnScreen = new ArrayList<>();


//    Media media = new Media(new File("..\\audios\\introSound.mp3").toURI().toString());
//    MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        islands.add(new Image(getClass().getResourceAsStream("..\\images\\Island1.png")));
//        islands.add(new Image(getClass().getResourceAsStream("..\\images\\Island2.png")));
        islands.add(new Image(getClass().getResourceAsStream("..\\images\\Island3.png")));
        islands.add(new Image(getClass().getResourceAsStream("..\\images\\Island4.png")));

        islandViews.add(myIslandView1);
        islandViews.add(myIslandView2);
        islandViews.add(myIslandView3);

        moveablesOnScreen.add(myIslandView1);
        moveablesOnScreen.add(myIslandView2);
        moveablesOnScreen.add(myIslandView3);
        moveablesOnScreen.add(myTNT);
        moveablesOnScreen.add(myOrc);
        moveablesOnScreen.add(myChest);

        MyHelper.myFade(dummy5,1,0.5,650,-1).play();
        MyHelper.myFade(dummy3,1,0.8,400,-1).play();
        MyHelper.myTranslation(dummy3,10,0,0,1000,-1,true).play();
    }

    public void onClickStartGame(){
        dummy1.setOpacity(0);
        dummy2.setOpacity(0);
        dummy3.setVisible(false);   // opacity won't 'set' as fade transition
        dummy4.setOpacity(0);
        dummy5.setVisible(false);
        dummy6.setOpacity(0);
        dummy6.setDisable(true);
        dummy2.setDisable(true);
        dummy3.setDisable(true);
        dummy4.setDisable(true);
        dummy5.setDisable(true);
        dummy1.setDisable(true);

//        Timeline heroJumpingTimeline = new Timeline(new KeyFrame(Duration.millis(400), (event) -> {
                TranslateTransition t1 = MyHelper.myTranslation(myHero, 0,-50,0,600,-1,true);
                TranslateTransition t2 = MyHelper.myTranslation(myOrc, 0,-50,0,1100,-1,true);
                ParallelTransition pt = new ParallelTransition(t1,t2);
                pt.play();
//        }));
//        heroJumpingTimeline.setCycleCount(1);
//        heroJumpingTimeline.play();

        scene = myHero.getScene();
        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case RIGHT:
                    pt.pause();
                    for(ImageView islandImageView: islandViews){
                        Timeline currTimeline = new Timeline(new KeyFrame(Duration.millis(30), (event) -> {
                            islandImageView.setLayoutX(islandImageView.getLayoutX() - 50);
                            if(islandImageView.getLayoutX()<=0-islandImageView.getImage().getWidth()){
                                Image currImage = islands.get((int)(100*Math.random()) % islands.size());
                                islandImageView.setImage(currImage);
                                islandImageView.setX(0);
                                islandImageView.setY(0);

                                if(currImage == islands.get(0)){
//                                    islandImageView.setLayoutX(-25);
                                    islandImageView.setLayoutX(690 - (islandImageView.getFitWidth()-islandImageView.getImage().getWidth())/2 );
                                    islandImageView.setLayoutY(256);
                                    islandImageView.setFitWidth(222);
                                    islandImageView.setFitHeight(159);
//                                    myOrc.setLayoutX();
//                                    myOrc.setLayoutY();
//                                    myOrc.setFitWidth();
//                                    myOrc.setFitHeight();
                                }
//                                else if(currImage == islands.get(1)){
//            //                        islandImageView.setLayoutX(170);
//                                    islandImageView.setLayoutX(690 - (islandImageView.getFitWidth()-islandImageView.getImage().getWidth())/2 );
//                                    islandImageView.setLayoutY(189);
//                                    islandImageView.setFitWidth(177);
//                                    islandImageView.setFitHeight(220);
//                                }
                                else if(currImage == islands.get(1)){
//                                    islandImageView.setLayoutX(492);
                                    islandImageView.setLayoutX(690 - (islandImageView.getFitWidth()-islandImageView.getImage().getWidth())/2 );
                                    islandImageView.setLayoutY(135);
                                    islandImageView.setFitWidth(294);
                                    islandImageView.setFitHeight(296);
                                    if(Math.random() < 0.5){   // new chest
//                                        myChest.setLayoutX();
//                                        myChest.setLayoutY();
//                                        myChest.setFitWidth();
//                                        myChest.setFitHeight();
                                    }else{   // new TNT
//                                        myTNT.setLayoutX();
//                                        myTNT.setLayoutY();
//                                        myTNT.setFitWidth();
//                                        myTNT.setFitHeight();
                                    }
                                }
                                else{
//                                    islandImageView.setLayoutX(286);
                                    islandImageView.setLayoutX(690 - (islandImageView.getFitWidth()-islandImageView.getImage().getWidth())/2 );
                                    islandImageView.setLayoutY(182);
                                    islandImageView.setFitWidth(247);
                                    islandImageView.setFitHeight(250);
//                                    myOrc.setLayoutX();
//                                    myOrc.setLayoutY();
//                                    myOrc.setFitWidth();
//                                    myOrc.setFitHeight();
                                }
                            }
                        }));
                        currTimeline.setCycleCount(1);
                        timelines.add(currTimeline);
                    }

                    Timeline currTimeline1 = new Timeline(new KeyFrame(Duration.millis(30), (event) -> {
                        myOrc.setLayoutX(myOrc.getLayoutX() - 50);
                        if(myOrc.getLayoutX()<=0-myOrc.getImage().getWidth()){
                            if(Math.random() > 0.5){
                                myOrc.setImage(new Image(getClass().getResourceAsStream("..\\images\\greenOrc.png")));
                                myOrc.setFitWidth(46);
                                myOrc.setFitHeight(36);
                                myOrc.setLayoutX(551);
                                myOrc.setLayoutY(238);
                            }
                            else{
                                myOrc.setImage(new Image(getClass().getResourceAsStream("..\\images\\redOrc.png")));
                                myOrc.setFitWidth(80);
                                myOrc.setFitHeight(76);
                                myOrc.setLayoutX(551);
                                myOrc.setLayoutY(198);
                            }
                            myOrc.setLayoutX(690);
                        }
                    }));
                    currTimeline1.setCycleCount(1);
                    timelines.add(currTimeline1);

                    Timeline currTimeline2 = new Timeline(new KeyFrame(Duration.millis(30), (event) -> {
                        myTNT.setLayoutX(myTNT.getLayoutX() - 50);
                        if(myTNT.getLayoutX()<=0-myTNT.getImage().getWidth()){
                            myTNT.setLayoutX(690);
                        }
                    }));
                    currTimeline2.setCycleCount(1);
                    timelines.add(currTimeline2);

                    Timeline currTimeline3 = new Timeline(new KeyFrame(Duration.millis(30), (event) -> {
                        myChest.setLayoutX(myChest.getLayoutX() - 50);
                        if(myChest.getLayoutX()<=0-myChest.getImage().getWidth()){
                            myChest.setLayoutX(690);
                        }
                    }));
                    currTimeline3.setCycleCount(1);
                    timelines.add(currTimeline3);

                    ParallelTransition parallelTransition = new ParallelTransition(timelines.get(0),timelines.get(1),timelines.get(2),timelines.get(3),timelines.get(4),timelines.get(5));
                    parallelTransition.play();
                    pt.play();
                    break;
                default:
                    break;
            }
        });
    }

    public boolean isAbyss(){

        ImageView cloneHero = new ImageView();
        cloneHero.setOpacity(0);
        cloneHero.setFitHeight(myHero.getFitHeight());
        cloneHero.setFitWidth(myHero.getFitWidth());
        cloneHero.setX(myHero.getX());
        cloneHero.setY(myHero.getY());
        cloneHero.setLayoutX(myHero.getLayoutX());
        cloneHero.setLayoutY(myHero.getLayoutY());


        return false;
    }
}
