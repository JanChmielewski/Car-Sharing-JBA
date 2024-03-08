package carsharing.menu.options;

import carsharing.db.DatabaseManager;

public interface MenuOption {

    void execute(DatabaseManager databaseManager);
    String description();

}
