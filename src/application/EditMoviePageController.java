package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditMoviePageController implements Initializable {
    @FXML
    private Label movie_id_label;
    @FXML
    private TextField edit_movie_title_txt;
    @FXML
    private TextField edit_movie_genre_txt;
    @FXML
    private TextField edit_movie_length_txt;
    @FXML
    private Button finish_edit_movie_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
