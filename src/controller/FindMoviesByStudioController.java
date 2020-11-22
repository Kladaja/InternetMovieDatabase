package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FindMoviesByStudioController implements Initializable {
    @FXML
    private Label studio_name_label;
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
    private TextField find_movie_title_by_studio_txt;
    @FXML
    private Button find_movie_by_studio_btn;
    @FXML
    private TextField delete_movie_id_by_studio_txt;
    @FXML
    private Button edit_movie_by_studio_btn;
    @FXML
    private Button delete_movie_by_studio_btn;
    @FXML
    private TextField add_movie_title_by_studio_txt;
    @FXML
    private TextField add_movie_genre_by_studio_txt;
    @FXML
    private Button add_movie_by_studio_btn;
    @FXML
    private TextField add_movie_length_by_studio_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
