package carsharing;

import carsharing.db.DatabaseConnection;
import carsharing.db.DatabaseManager;
import carsharing.menu.MainMenu;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbPath = args.length > 1 ? "./src/carsharing/db/" + args[1] : "./src/carsharing/db/carsharing";
        DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:h2:" + dbPath);
        DatabaseManager databaseManager;
        try {
            databaseManager = new DatabaseManager(databaseConnection.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new MainMenu(databaseManager).showMenu();
        databaseConnection.closeConnection();

        // Check if the database file was created
        if (Files.exists(Paths.get(dbPath + ".mv.db"))) {
            System.out.println("Database file was created successfully.");
        } else {
            System.out.println("Database file was not created.");
        }
    }
}