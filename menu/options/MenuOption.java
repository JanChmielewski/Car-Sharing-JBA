package carsharing.menu.options;

import carsharing.db.DatabaseManager;
import carsharing.service.UI;

public interface MenuOption {

    void execute(DatabaseManager databaseManager, UI ui);
    String description();

}
