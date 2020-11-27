package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudiosPageController implements Initializable {
    @FXML private Button movies_btn;
    @FXML private Button series_btn;
    @FXML private Button actors_btn;
    @FXML private Button directors_btn;
    @FXML private Button studios_btn;
    @FXML private TableView<Studio> studio_table_view;
    @FXML private TableColumn<Studio, Integer> studio_id;
    @FXML private TableColumn<Studio, String> studio_name;
    @FXML private TableColumn<Studio, String> studio_country;
    @FXML private TableColumn<Studio, String> studio_owner;
    @FXML private TableColumn<Studio, Integer> studio_founded;
    @FXML private Button find_movies_for_studio_btn;
    @FXML private Button find_series_for_studio_btn;
    @FXML private TextField find_studio_id_txt;
    @FXML private Button add_movies_to_studio_btn;
    @FXML private TextField find_studio_name_txt;
    @FXML private Button find_studio_btn;
    @FXML private TextField delete_studio_id_txt;
    @FXML private Button edit_studio_btn;
    @FXML private Button delete_studio_btn;
    @FXML private TextField add_studio_name_txt;
    @FXML private TextField add_studio_country_txt;
    @FXML private Button add_studio_btn;
    @FXML private TextField add_studio_owner_txt;
    @FXML private TextField add_studio_founded_txt;

    private Connection connection;
    private ObservableList<Studio> observableList;
    private DBConnector dbConnector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnector = new DBConnector();
        populateTableView();
    }

    private void populateTableView() {
        try {

            observableList = FXCollections.observableArrayList();
            String sql = "SELECT * FROM studio";
            connection = dbConnector.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                Studio studio = new Studio();
                studio.setStudio_id(resultSet.getInt("studio_id"));
                studio.setStudio_name(resultSet.getString("studio_name"));
                studio.setStudio_country(resultSet.getString("studio_country"));
                studio.setStudio_owner(resultSet.getString("studio_owner"));
                studio.setStudio_founded(resultSet.getInt("studio_founded"));

                observableList.add(studio);
            }

            studio_id.setCellValueFactory(new PropertyValueFactory<>("studio_id"));
            studio_name.setCellValueFactory(new PropertyValueFactory<>("studio_name"));
            studio_country.setCellValueFactory(new PropertyValueFactory<>("studio_country"));
            studio_owner.setCellValueFactory(new PropertyValueFactory<>("studio_owner"));
            studio_founded.setCellValueFactory(new PropertyValueFactory<>("studio_founded"));

            studio_table_view.setItems(observableList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void movies_btn_action(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoviesPage.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            StudiosPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void series_btn_action(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SeriesPage.fxml"));;
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            StudiosPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void actors_btn_action(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ActorsPage.fxml"));;
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            StudiosPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void directors_btn_action(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DirectorsPage.fxml"));;
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            StudiosPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void studios_btn_action(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/StudiosPage.fxml"));;
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            StudiosPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
