package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector implements DAO {
    protected Connection connection;

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DB_URL,USER, PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
