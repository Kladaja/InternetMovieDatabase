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
import java.sql.PreparedStatement;
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
    private PreparedStatement preparedStatement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnector = new DBConnector();

        String sql = "SELECT * FROM director";
        populateTableView(sql);
    }

    private void populateTableView(String sql) {
        try {
            observableList = FXCollections.observableArrayList();
            connection = dbConnector.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                Director director = new Director();
                director.setDirector_id(resultSet.getInt("director_id"));
                director.setDirector_first_name(resultSet.getString("director_first_name"));
                director.setDirector_last_name(resultSet.getString("director_last_name"));
                director.setDirector_birth_date(resultSet.getDate("director_birth_date"));

                observableList.add(director);
            }

            director_id.setCellValueFactory(new PropertyValueFactory<>("director_id"));
            director_first_name.setCellValueFactory(new PropertyValueFactory<>("director_first_name"));
            director_last_name.setCellValueFactory(new PropertyValueFactory<>("director_last_name"));
            director_birth_date.setCellValueFactory(new PropertyValueFactory<>("director_birth_date"));

            director_table_view.setItems(observableList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Menu buttons

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

    // Basic queries

    public void find_director_btn_action(ActionEvent event) {
        if (!find_director_name_txt.getText().isEmpty()) {
            String find = find_director_name_txt.getText();
            String sql = "SELECT * FROM director WHERE director_first_name LIKE '%" + find + "%' OR director_last_name LIKE '%" + find + "%'";
            populateTableView(sql);
        }
    }
    public void add_director_btn_action(ActionEvent event) {
        try {
            String first_name = add_director_first_name_txt.getText();
            String last_name = add_director_last_name_txt.getText();
            String birth_date = add_director_birth_date_txt.getText();

            String insert = "INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, '" + first_name + "', '" + last_name + "', '" + birth_date + "');\n";

            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.executeUpdate();

            add_director_first_name_txt.clear();
            add_director_last_name_txt.clear();
            add_director_birth_date_txt.clear();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql = "SELECT * FROM director";
        populateTableView(sql);
    }
//    public void delete_movie_btn_action(ActionEvent event) {
//        try {
//            String id = delete_movie_id_txt.getText();
//
//            String delete = "DELETE FROM movie WHERE movie_id = " + id;
//
//            connection = dbConnector.getConnection();
//            preparedStatement = connection.prepareStatement(delete);
//            preparedStatement.executeUpdate();
//
//            delete_movie_id_txt.clear();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        String sql = "SELECT * FROM movie";
//        populateTableView(sql);
//    }
//    public void edit_movie_btn_action(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EditMoviePage.fxml"));
//            Parent root = loader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//            MoviesPage.stg.close();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }

}
