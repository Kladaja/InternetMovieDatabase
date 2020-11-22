package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DirectorsPageController implements Initializable {
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
    private TableColumn<?, ?> director_id;
    @FXML
    private TableColumn<?, ?> director_first_name;
    @FXML
    private TableColumn<?, ?> director_last_name;
    @FXML
    private TableColumn<?, ?> director_birth_date;
    @FXML
    private Button find_movies_for_director_btn;
    @FXML
    private Button find_series_for_director_btn;
    @FXML
    private TextField find_director_id_txt;
    @FXML
    private Button add_movies_to_director_btn;
    @FXML
    private Button add_series_to_director_btn;
    @FXML
    private TextField find_director_name_txt;
    @FXML
    private Button find_director_btn;
    @FXML
    private TextField delete_director_id_txt;
    @FXML
    private Button edit_director_btn;
    @FXML
    private Button delete_director_btn;
    @FXML
    private TextField add_director_first_name_txt;

    @FXML
    private TextField add_director_last_name_txt;

    @FXML
    private Button add_director_btn;

    @FXML
    private TextField add_director_birth_date_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
