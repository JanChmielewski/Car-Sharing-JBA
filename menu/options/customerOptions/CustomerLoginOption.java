package carsharing.menu.options.customerOptions;


import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.customerService.CustomerLogger;

public class CustomerLoginOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CustomerLogger().login(databaseManager, ui);
    }

    @Override
    public String description() {
        return "Log in as a customer";
    }
}
