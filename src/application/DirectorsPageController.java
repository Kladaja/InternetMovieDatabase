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
import java.util.Date;
import java.util.ResourceBundle;

public class DirectorsPageController implements Initializable {
    @FXML private Button movies_btn;
    @FXML private Button series_btn;
    @FXML private Button actors_btn;
    @FXML private Button directors_btn;
    @FXML private Button studios_btn;
    @FXML private TableView<Director> director_table_view;
    @FXML private TableColumn<Director, Integer> director_id;
    @FXML private TableColumn<Director, String> director_first_name;
    @FXML private TableColumn<Director, String> director_last_name;
    @FXML private TableColumn<Director, Date> director_birth_date;
    @FXML private Button find_movies_for_director_btn;
    @FXML private Button find_series_for_director_btn;
    @FXML private TextField find_director_id_txt;
    @FXML private Button add_movies_to_director_btn;
    @FXML private Button add_series_to_director_btn;
    @FXML private TextField find_director_name_txt;
    @FXML private Button find_director_btn;
    @FXML private TextField delete_director_id_txt;
    @FXML private Button edit_director_btn;
    @FXML private Button delete_director_btn;
    @FXML private TextField add_director_first_name_txt;
    @FXML private TextField add_director_last_name_txt;
    @FXML private Button add_director_btn;
    @FXML private TextField add_director_birth_date_txt;

    private Connection connection;
    private ObservableList<Director> observableList;
    private DBConnector dbConnector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnector = new DBConnector();
        populateTableView();
    }

    private void populateTableView() {
        try {

            observableList = FXCollections.observableArrayList();
            String sql = "SELECT * FROM director";
            connection = dbConnector.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                Director director = new Director();
                director.setDirector_id(resultSet.getInt("director_id"));
                director.setDirector_first_name(resultSet.getString("director_first_nam"));
                director.setDirector_last_name(resultSet.getString("director_last_name"));
                director.setDirector_birth_date(resultSet.getDate("director_birth_date"));

                observableList.add(director);
            }

            director_id.setCellValueFactory(new PropertyValueFactory<>("director_idd"));
            director_first_name.setCellValueFactory(new PropertyValueFactory<>("director_first_name"));
            director_last_name.setCellValueFactory(new PropertyValueFactory<>("director_last_name"));
            director_birth_date.setCellValueFactory(new PropertyValueFactory<>("director_birth_date"));

            director_table_view.setItems(observableList);

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
            MoviesPage.stg.close();
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
            MoviesPage.stg.close();
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
            MoviesPage.stg.close();
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
            MoviesPage.stg.close();
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
            MoviesPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
