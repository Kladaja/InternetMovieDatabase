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

public class SeriesPageController implements Initializable {
    @FXML private Button movies_btn;
    @FXML private Button series_btn;
    @FXML private Button actors_btn;
    @FXML private Button directors_btn;
    @FXML private Button studios_btn;
    @FXML protected TableView<Series> series_table_view;
    @FXML private TableColumn<Series, Integer> series_id;
    @FXML private TableColumn<Series, String> series_title;
    @FXML private TableColumn<Series, String> series_genre;
    @FXML private TableColumn<Series, Integer> series_seasons;
    @FXML private Button find_actors_in_series_btn;
    @FXML private Button find_directors_for_series_btn;
    @FXML private Button find_studios_for_series_btn;
    @FXML private TextField find_series_id_txt;
    @FXML private Button add_actors_to_series_btn;
    @FXML private TextField find_series_title_txt;
    @FXML private Button find_series_btn;
    @FXML private TextField delete_series_id_text;
    @FXML private Button edit_series_btn;
    @FXML private Button delete_series_btn;
    @FXML private TextField add_series_title_text;
    @FXML private TextField add_series_genre_text;
    @FXML private Button add_series_btn;
    @FXML private TextField add_series_seasons_text;

    private Connection connection;
    private ObservableList<Series> observableList;
    private DBConnector dbConnector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnector = new DBConnector();
        populateTableView();
    }

    private void populateTableView() {
        try {

            observableList = FXCollections.observableArrayList();
            String sql = "SELECT * FROM series";
            connection = dbConnector.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                Series series = new Series();
                series.setSeries_id(resultSet.getInt("series_id"));
                series.setSeries_title(resultSet.getString("series_title"));
                series.setSeries_genre(resultSet.getString("series_genre"));
                series.setSeries_seasons(resultSet.getInt("series_seasons"));

                observableList.add(series);
            }

            series_id.setCellValueFactory(new PropertyValueFactory<>("series_id"));
            series_title.setCellValueFactory(new PropertyValueFactory<>("series_title"));
            series_genre.setCellValueFactory(new PropertyValueFactory<>("series_genre"));
            series_seasons.setCellValueFactory(new PropertyValueFactory<>("series_seasons"));

            series_table_view.setItems(observableList);

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
            SeriesPage.stg.close();
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
            SeriesPage.stg.close();
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
            SeriesPage.stg.close();
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
            SeriesPage.stg.close();
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
            SeriesPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
