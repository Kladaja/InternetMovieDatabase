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
import java.util.ResourceBundle;

public class AdvancedMoviesPageController implements DAO, Initializable {
    @FXML private Button movies_btn;
    @FXML private Button series_btn;
    @FXML private Button actors_btn;
    @FXML private Button directors_btn;
    @FXML private Button studios_btn;
    @FXML private TableView<Movie> movie_table_view;
    @FXML private TableColumn<Movie, Integer> movie_id;
    @FXML private TableColumn<Movie, String> movie_title;
    @FXML private TableColumn<Movie, String> movie_genre;
    @FXML private TableColumn<Movie, Integer> movie_length;
    @FXML private TextField find_movie_title_txt;
    @FXML private Button find_movie_btn;
    @FXML private TextField delete_movie_id_txt;
    @FXML private Button edit_movie_btn;
    @FXML private Button delete_movie_btn;
    @FXML private TextField find_movie_genre_txt;
    @FXML private TextField find_movie_min_length_txt;
    @FXML private TextField find_movie_actor_txt;
    @FXML private TextField find_movie_max_length_txt;
    @FXML private TextField find_movie_director_txt;
    @FXML private TextField find_movie_studio_txt;

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
        String sql = "SELECT * FROM movie";
        boolean where = false;
        if (!find_movie_title_txt.getText().isEmpty()) {
            sql += where ? "" : " WHERE";
            where = true;
            sql += " movie_title LIKE '%" + find_movie_title_txt.getText() + "%'";
        }
        if (!find_movie_genre_txt.getText().isEmpty()) {
            sql += where ? " AND" : " WHERE";
            where = true;
            sql += " movie_genre LIKE '%" + find_movie_genre_txt.getText() + "%'";

        }
        if (!find_movie_min_length_txt.getText().isEmpty()) {
            sql += where ? " AND" : " WHERE";
            where = true;
            sql += " movie_length > " + find_movie_min_length_txt.getText();
        }
        if (!find_movie_max_length_txt.getText().isEmpty()) {
            sql += where ? " AND" : " WHERE";
            where = true;
            sql += " movie_length < " + find_movie_max_length_txt.getText();
        }
        if (!find_movie_actor_txt.getText().isEmpty()) {
            sql += where ? " AND" : " WHERE";
            where = true;
            sql += " movie_id IN ( SELECT movie_id FROM movie_acting WHERE actor_id = ( SELECT actor_id FROM actor WHERE actor_first_name LIKE '%" + find_movie_actor_txt.getText() + "%' OR actor_last_name LIKE '%" + find_movie_actor_txt.getText() + "%' GROUP BY actor_first_name) GROUP BY movie_title)";
        }
        if (!find_movie_director_txt.getText().isEmpty()) {
            sql += where ? " AND" : " WHERE";
            where = true;
            sql += " movie_id IN ( SELECT movie_id FROM movie_directing WHERE director_id = ( SELECT director_id FROM director WHERE director_first_name LIKE '%" + find_movie_director_txt.getText() + "%' OR director_last_name LIKE '%" + find_movie_director_txt.getText() + "%' GROUP BY director_first_name) GROUP BY movie_title)";
        }
        if (!find_movie_studio_txt.getText().isEmpty()) {
            sql += where ? " AND" : " WHERE";
            where = true;
            sql += " movie_id IN ( SELECT movie_id FROM movie_producing WHERE studio_id = ( SELECT studio_id FROM studio WHERE studio_name LIKE '%" + find_movie_studio_txt.getText() + "%' GROUP BY studio_name) GROUP BY movie_title)";
        }

        System.out.println(sql);
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

}
