package carsharing.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private final DatabaseConnection databaseConnection;

    public DatabaseManager(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createTable(String tableName) {
        try {
            Connection connection = databaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS \"" + tableName + "\" (" +
                    "ID INT PRIMARY KEY, " +
                    "NAME VARCHAR(255))";

            statement.executeUpdate(createTableSQL);
            statement.close();

            System.out.println(tableName + " table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
