package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FindSeriesByStudioController implements Initializable {
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
    private Label studio_name_label;
    @FXML
    private TextField find_series_title_by_studio_txt;
    @FXML
    private Button find_series_by_studio_btn;
    @FXML
    private TextField delete_series_id_by_studio_txt;
    @FXML
    private Button edit_series_by_studio_btn;
    @FXML
    private Button delete_series_by_studio_btn;
    @FXML
    private TextField add_series_title_by_studio_txt;
    @FXML
    private TextField add_series_genre_by_studio_txt;
    @FXML
    private Button add_series_by_studio_btn;
    @FXML
    private TextField add_series_seasons_by_studio_txt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
