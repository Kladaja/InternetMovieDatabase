package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FindStudiosForSeriesController implements Initializable {
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
    private TableColumn<?, ?> studio_id;
    @FXML
    private TableColumn<?, ?> studio_name;
    @FXML
    private TableColumn<?, ?> studio_country;
    @FXML
    private TableColumn<?, ?> studio_owner;
    @FXML
    private TableColumn<?, ?> studio_founded;
    @FXML
    private Label series_title_label;
    @FXML
    private TextField find_studio_name_for_series_txt;
    @FXML
    private Button find_studio_for_series_btn;
    @FXML
    private TextField delete_studio_id_for_series_txt;
    @FXML
    private Button edit_studio_for_series_btn;
    @FXML
    private Button delete_studio_for_series_btn;
    @FXML
    private TextField add_studio_name_for_series_txt;
    @FXML
    private TextField add_studio_country_for_series_txt;
    @FXML
    private Button add_studio_for_series_btn;
    @FXML
    private TextField add_studio_owner_for_series_txt;
    @FXML
    private TextField add_studio_founded_for_series_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
