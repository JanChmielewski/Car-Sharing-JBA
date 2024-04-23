package carsharing.menu.options.managerOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.ManagerMenu;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;

public class ManagerLoginOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new ManagerMenu(databaseManager).showMenu();
    }

    @Override
    public String description() {
        return "Log in as a manager";
    }
}
