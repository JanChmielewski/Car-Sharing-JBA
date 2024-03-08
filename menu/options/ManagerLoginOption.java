package carsharing.menu.options;

import carsharing.db.DatabaseManager;
import carsharing.menu.ManagerMenu;

public class ManagerLoginOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager) {
        new ManagerMenu(databaseManager).showMenu();
    }

    @Override
    public String description() {
        return "Log in as a manager";
    }
}
