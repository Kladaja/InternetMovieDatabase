package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FindSeriesForActorController implements Initializable {
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
    private Label actor_name_label;
    @FXML
    private TextField find_series_title_for_actor_txt;
    @FXML
    private Button find_series_for_actor_btn;
    @FXML
    private TextField delete_series_id_for_actor_txt;
    @FXML
    private Button edit_series_for_actor_btn;
    @FXML
    private Button delete_series_for_actor_btn;
    @FXML
    private TextField add_series_title_for_actor_txt;
    @FXML
    private TextField add_series_genre_for_actor_txt;
    @FXML
    private Button add_series_for_actor_btn;
    @FXML
    private TextField add_series_length_for_actor_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
