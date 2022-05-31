package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        stage.setTitle("Will Hero");
        stage.getIcons().add(new Image("images\\logo.png"));  // anonymous object

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LaunchScene.fxml"));
        Parent root = loader.load();
        LaunchSceneController launchSceneController = loader.getController();

        Scene scene = new Scene(root,690,444);
        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case ENTER:
                    try{
                        launchSceneController.loading();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                default:
                    break;
            }
        });

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
