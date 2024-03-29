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
import java.sql.*;
import java.util.ResourceBundle;

public class MoviesPageController implements DAO, Initializable {
    @FXML private Button movies_btn;
    @FXML private Button series_btn;
    @FXML private Button actors_btn;
    @FXML private Button directors_btn;
    @FXML private Button studios_btn;
    @FXML protected TableView<Movie> movie_table_view;
    @FXML protected TableColumn<Movie, Integer> movie_id;
    @FXML protected TableColumn<Movie, String> movie_title;
    @FXML protected TableColumn<Movie, String> movie_genre;
    @FXML protected TableColumn<Movie, Integer> movie_length;
    @FXML private Button add_actors_to_movie_btn;
    @FXML private TextField find_movie_title_txt;
    @FXML private Button find_movie_btn;
    @FXML private TextField delete_movie_id_txt;
    @FXML private Button edit_movie_btn;
    @FXML private Button delete_movie_btn;
    @FXML private TextField add_movie_title_txt;
    @FXML private TextField add_movie_genre_txt;
    @FXML private Button add_movie_btn;
    @FXML private TextField add_movie_length_txt;

    private Connection connection;
    private ObservableList<Movie> observableList;
    private DBConnector dbConnector;
    private PreparedStatement preparedStatement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnector = new DBConnector();

        String sql = "SELECT * FROM movie";
        populateTableView(sql);
    }

    private void populateTableView(String sql) {
        try {
            observableList = FXCollections.observableArrayList();
            connection = dbConnector.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovie_id(resultSet.getInt("movie_id"));
                movie.setMovie_title(resultSet.getString("movie_title"));
                movie.setMovie_genre(resultSet.getString("movie_genre"));
                movie.setMovie_length(resultSet.getInt("movie_length"));

                observableList.add(movie);
            }

            movie_id.setCellValueFactory(new PropertyValueFactory<>("movie_id"));
            movie_title.setCellValueFactory(new PropertyValueFactory<>("movie_title"));
            movie_genre.setCellValueFactory(new PropertyValueFactory<>("movie_genre"));
            movie_length.setCellValueFactory(new PropertyValueFactory<>("movie_length"));

            movie_table_view.setItems(observableList);
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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SeriesPage.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ActorsPage.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DirectorsPage.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/StudiosPage.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            MoviesPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Basic queries

    public void find_movie_btn_action(ActionEvent event) {
        if (!find_movie_title_txt.getText().isEmpty()) {
            String find = find_movie_title_txt.getText();
            String sql = "SELECT * FROM movie WHERE movie_title LIKE '%" + find + "%'";
            populateTableView(sql);
        }
    }
    public void add_movie_btn_action(ActionEvent event) {
        try {
            String title = add_movie_title_txt.getText();
            String genre = add_movie_genre_txt.getText();
            String length = add_movie_length_txt.getText();

            String insert = "INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, '" + title + "', '" + genre + "', '" + length + "');";

            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.executeUpdate();

            add_movie_title_txt.clear();
            add_movie_genre_txt.clear();
            add_movie_length_txt.clear();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql = "SELECT * FROM movie";
        populateTableView(sql);
    }
    public void delete_movie_btn_action(ActionEvent event) {
        try {
            String id = delete_movie_id_txt.getText();

            String delete = "DELETE FROM movie WHERE movie_id = " + id;

            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.executeUpdate();

            delete_movie_id_txt.clear();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql = "SELECT * FROM movie";
        populateTableView(sql);
    }
    public void edit_movie_btn_action(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EditMoviePage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            MoviesPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void advanced_search_btn_action(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdvancedMoviesPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            MoviesPage.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}