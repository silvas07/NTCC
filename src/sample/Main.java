package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Visao/Principal.fxml"));
        primaryStage.setTitle("NTCC");
        primaryStage.setScene(new Scene(root, 830, 680));
        primaryStage.setMaxWidth(830);
        primaryStage.setMinHeight(680);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
