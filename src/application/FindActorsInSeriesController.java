package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FindActorsInSeriesController implements Initializable{
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
    private TableColumn<?, ?> actor_id;
    @FXML
    private TableColumn<?, ?> actor_first_name;
    @FXML
    private TableColumn<?, ?> actor_last_name;
    @FXML
    private TableColumn<?, ?> actor_birth_date;
    @FXML
    private Label series_title_label;
    @FXML
    private TextField find_actor_name_in_series_txt;
    @FXML
    private Button find_actor_in_series_btn;
    @FXML
    private TextField delete_actor_id_in_series_txt;
    @FXML
    private Button edit_actor_in_series_btn;
    @FXML
    private Button delete_actor_in_series_btn;
    @FXML
    private TextField add_actor_first_name_to_series_txt;
    @FXML
    private TextField add_actor_last_name_to_series_txt;
    @FXML
    private Button add_actor_to_series_btn;
    @FXML
    private TextField add_actor_birth_date_to_series_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
