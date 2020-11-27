package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActorsPage extends Application {
    static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ActorsPage.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
            stg = primaryStage;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) { launch(args); }
}
