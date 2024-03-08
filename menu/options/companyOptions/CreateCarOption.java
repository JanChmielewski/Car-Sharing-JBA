package carsharing.menu.options.companyOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;

public class CreateCarOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        // TODO: implement
        new CarCreator().createCar(databaseManager);
    }

    @Override
    public String description() {
        return "Create a car";
    }
}
