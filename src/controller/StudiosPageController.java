package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudiosPageController implements Initializable {
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
    private Button find_movies_for_studio_btn;
    @FXML
    private Button find_series_for_studio_btn;
    @FXML
    private TextField find_studio_id_txt;
    @FXML
    private Button add_movies_to_studio_btn;
    @FXML
    private TextField find_studio_name_txt;
    @FXML
    private Button find_studio_btn;
    @FXML
    private TextField delete_studio_id_txt;
    @FXML
    private Button edit_studio_btn;
    @FXML
    private Button delete_studio_btn;
    @FXML
    private TextField add_studio_name_txt;
    @FXML
    private TextField add_studio_country_txt;
    @FXML
    private Button add_studio_btn;
    @FXML
    private TextField add_studio_owner_txt;
    @FXML
    private TextField add_studio_founded_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
