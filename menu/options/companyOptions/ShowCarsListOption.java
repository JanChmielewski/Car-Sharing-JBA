package carsharing.menu.options.companyOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;

public class ShowCarsListOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        // TODO: implement
        new CarListViewer().showCarList(databaseManager);
    }

    @Override
    public String description() {
        return "Car list";
    }
}
