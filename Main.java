package carsharing;

import carsharing.db.DatabaseConnection;
import carsharing.db.DatabaseManager;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        DatabaseConnection databaseConnection = new DatabaseConnection(Optional.of("jdbc:h2:./src/carsharing/db/" + args[1]).orElse("jdbc:h2:./src/carsharing/db/carsharing"));
        DatabaseManager databaseManager = new DatabaseManager(databaseConnection);
        databaseManager.createTable("COMPANY");
        databaseConnection.closeConnection();

    }
}