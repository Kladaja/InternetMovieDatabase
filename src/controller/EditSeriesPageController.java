package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditSeriesPageController implements Initializable{
    @FXML
    private Label series_id_label;
    @FXML
    private TextField edit_series_title_txt;
    @FXML
    private TextField edit_series_genre_txt;
    @FXML
    private TextField edit_series_seasons_txt;
    @FXML
    private Button finish_edit_series_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
