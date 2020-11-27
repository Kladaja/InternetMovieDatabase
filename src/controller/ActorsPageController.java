package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ActorsPageController implements Initializable {
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
    private Button find_movies_for_actor_btn;
    @FXML
    private Button find_series_for_actor_btn;
    @FXML
    private TextField find_actor_id_txt;
    @FXML
    private Button add_movies_to_actor_btn;
    @FXML
    private Button add_series_to_actor_btn;
    @FXML
    private TextField find_actor_name_txt;
    @FXML
    private Button find_actor_btn;
    @FXML
    private TextField delete_actor_id_txt;
    @FXML
    private Button edit_actor_btn;
    @FXML
    private Button delete_movie_btn;
    @FXML
    private TextField add_actor_first_name_txt;
    @FXML
    private TextField add_actor_last_name_txt;
    @FXML
    private Button add_actor_btn;
    @FXML
    private TextField add_actor_birth_date_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}