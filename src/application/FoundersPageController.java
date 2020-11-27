package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FoundersPageController implements Initializable {
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
    private TableColumn<?, ?> founders_id;
    @FXML
    private TableColumn<?, ?> founders_first_name;
    @FXML
    private TableColumn<?, ?> founders_last_name;
    @FXML
    private TableColumn<?, ?> studio_name;
    @FXML
    private TextField find_founder_name_txt;
    @FXML
    private Button find_founder_btn;
    @FXML
    private TextField delete_founder_id_txt;
    @FXML
    private Button edit_founder_btn;
    @FXML
    private Button delete_founder_btn;
    @FXML
    private TextField add_founder_first_name_txt;
    @FXML
    private TextField add_founder_last_name_txt;
    @FXML
    private Button add_founder_btn;
    @FXML
    private TextField add_founder_studio_name_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
