package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditActorPageController implements Initializable {
    @FXML
    private Label actor_id_label;
    @FXML
    private TextField edit_actor_first_name_txt;
    @FXML
    private TextField edit_actor_last_name_txt;
    @FXML
    private TextField edit_actor_birth_date_txt;
    @FXML
    private Button finish_edit_actor_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
