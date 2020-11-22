package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SeriesPageController implements Initializable {
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
    private TableColumn<?, ?> series_id;
    @FXML
    private TableColumn<?, ?> series_title;
    @FXML
    private TableColumn<?, ?> series_genre;
    @FXML
    private TableColumn<?, ?> series_seasons;
    @FXML
    private Button find_actors_in_series_btn;
    @FXML
    private Button find_directors_for_series_btn;
    @FXML
    private Button find_studios_for_series_btn;
    @FXML
    private TextField find_series_id_txt;
    @FXML
    private Button add_actors_to_series_btn;
    @FXML
    private TextField find_series_title_txt;
    @FXML
    private Button find_series_btn;
    @FXML
    private TextField delete_series_id_text;
    @FXML
    private Button edit_series_btn;
    @FXML
    private Button delete_series_btn;
    @FXML
    private TextField add_series_title_text;
    @FXML
    private TextField add_series_genre_text;
    @FXML
    private Button add_series_btn;
    @FXML
    private TextField add_series_seasons_text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
