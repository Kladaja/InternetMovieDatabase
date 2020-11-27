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

public class ActorsPageController implements Initializable {
    @FXML private Button movies_btn;
    @FXML private Button series_btn;
    @FXML private Button actors_btn;
    @FXML private Button directors_btn;
    @FXML private Button studios_btn;
    @FXML protected TableView<Actor> actor_table_view;
    @FXML private TableColumn<Actor, Integer> actor_id;
    @FXML private TableColumn<Actor, String> actor_first_name;
    @FXML private TableColumn<Actor, String> actor_last_name;
    @FXML private TableColumn<Actor, Date> actor_birth_date;
    @FXML private Button find_movies_for_actor_btn;
    @FXML private Button find_series_for_actor_btn;
    @FXML private TextField find_actor_id_txt;
    @FXML private Button add_movies_to_actor_btn;
    @FXML private Button add_series_to_actor_btn;
    @FXML private TextField find_actor_name_txt;
    @FXML private Button find_actor_btn;
    @FXML private TextField delete_actor_id_txt;
    @FXML private Button edit_actor_btn;
    @FXML private Button delete_movie_btn;
    @FXML private TextField add_actor_first_name_txt;
    @FXML private TextField add_actor_last_name_txt;
    @FXML private Button add_actor_btn;
    @FXML private TextField add_actor_birth_date_txt;

    private Connection connection;
    private ObservableList<Actor> observableList;
    private DBConnector dbConnector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnector = new DBConnector();
        populateTableView();
    }

    private void populateTableView() {
        try {

            observableList = FXCollections.observableArrayList();
            String sql = "SELECT * FROM actor";
            connection = dbConnector.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                Actor actor = new Actor();
                actor.setActor_id(resultSet.getInt("actor_id"));
                actor.setActor_first_name(resultSet.getString("actor_first_name"));
                actor.setActor_last_name(resultSet.getString("actor_last_name"));
                actor.setActor_birth_date(resultSet.getDate("actor_birth_date"));

                observableList.add(actor);
            }

            actor_id.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
            actor_first_name.setCellValueFactory(new PropertyValueFactory<>("actor_first_name"));
            actor_last_name.setCellValueFactory(new PropertyValueFactory<>("actor_last_name"));
            actor_birth_date.setCellValueFactory(new PropertyValueFactory<>("actor_birth_date"));

            actor_table_view.setItems(observableList);

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
            ActorsPage.stg.close();
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
            ActorsPage.stg.close();
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
            ActorsPage.stg.close();
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
            ActorsPage.stg.close();
            ActorsPage.stg = stage;
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
            ActorsPage.stg.close();
            ActorsPage.stg = stage;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
