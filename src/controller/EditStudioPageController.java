package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditStudioPageController implements Initializable{
    @FXML
    private TextField edit_studio_name_txt;
    @FXML
    private TextField edit_studio_country_txt;
    @FXML
    private TextField edit_studio_owner_txt;
    @FXML
    private Button finish_edit_studio_btn;
    @FXML
    private TextField edit_studio_founded_txt;
    @FXML
    private Label studio_id_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
