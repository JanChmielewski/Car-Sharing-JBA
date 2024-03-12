package carsharing.menu.options.companyOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.companyService.CarListViewer;

public class ShowCarsListOption implements MenuOption {

    private final String companyName;
    public ShowCarsListOption(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CarListViewer().showCarList(databaseManager, ui, companyName);
    }

    @Override
    public String description() {
        return "Car list";
    }
}
