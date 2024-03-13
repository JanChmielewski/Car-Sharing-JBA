package carsharing.menu.options.customerOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.customerService.CustomerCreator;

public class CustomerCreateOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CustomerCreator().createCustomer(databaseManager, ui);
    }

    @Override
    public String description() {
        return "Create a customer";
    }
}
