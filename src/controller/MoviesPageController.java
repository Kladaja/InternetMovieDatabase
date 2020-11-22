package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MoviesPageController implements Initializable {
    @FXML
    private Button movies_btn;
    @FXML
    private Button series_btn;
    @FXML
    private Button actors_btn;
    @FXML
    private Button directors_btn;
    @FXML
    private Button studios_btn;
    @FXML
    private TableColumn<?, ?> movie_id;
    @FXML
    private TableColumn<?, ?> movie_title;
    @FXML
    private TableColumn<?, ?> movie_genre;
    @FXML
    private TableColumn<?, ?> movie_length;
    @FXML
    private Button find_actors_in_movie_btn;
    @FXML
    private Button find_directors_for_movie_btn;
    @FXML
    private Button find_studios_for_movie_btn;
    @FXML
    private TextField find_movie_id_txt;
    @FXML
    private Button add_actors_to_movie_btn;
    @FXML
    private TextField find_movie_title_txt;
    @FXML
    private Button find_movie_btn;
    @FXML
    private TextField delete_movie_id_txt;
    @FXML
    private Button edit_movie_btn;
    @FXML
    private Button delete_movie_btn;
    @FXML
    private TextField add_movie_title_txt;
    @FXML
    private TextField add_movie_genre_txt;
    @FXML
    private Button add_movies_btn;
    @FXML
    private TextField add_movie_length_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
