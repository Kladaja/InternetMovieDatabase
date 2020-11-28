package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class EditMoviePageController implements Initializable {
    @FXML private TextField edit_movie_id_txt;
    @FXML private TextField edit_movie_title_txt;
    @FXML private TextField edit_movie_genre_txt;
    @FXML private TextField edit_movie_length_txt;
    @FXML private Button finish_edit_movie_btn;

    private Connection connection;
    private ObservableList<Movie> observableList;
    private DBConnector dbConnector;
    private PreparedStatement preparedStatement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnector = new DBConnector();
    }

    public void setEdit_movie_id_txt(String edit_movie_id_txt) {
        this.edit_movie_id_txt.setText(edit_movie_id_txt);
    }

    public void finish_edit_movie_btn_action(ActionEvent event) {
        try {


            if (edit_movie_id_txt.getText().equals("") || edit_movie_id_txt.getText().isEmpty() || edit_movie_title_txt.getText().equals("") || edit_movie_title_txt.getText().isEmpty() || edit_movie_genre_txt.getText().equals("") || edit_movie_genre_txt.getText().isEmpty() || edit_movie_length_txt.getText().equals("") || edit_movie_length_txt.getText().isEmpty()) {
                System.out.println("Error");

                Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoviesPage.fxml"));;
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                String id = edit_movie_id_txt.getText();
                String title = edit_movie_title_txt.getText();
                String genre = edit_movie_genre_txt.getText();
                String length = edit_movie_length_txt.getText();

                String insert = "UPDATE movie SET movie_title = '" + title + "', movie_genre = '" + genre + "', movie_length = '" + length + "' WHERE movie_id = " + id;

                connection = dbConnector.getConnection();
                preparedStatement = connection.prepareStatement(insert);
                preparedStatement.executeUpdate();

                Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoviesPage.fxml"));;
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
