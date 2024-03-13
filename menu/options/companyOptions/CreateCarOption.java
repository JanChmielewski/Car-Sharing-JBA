package carsharing.menu.options.companyOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.companyService.CarCreator;

public class CreateCarOption implements MenuOption {

    private final int companyId;

    public CreateCarOption(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CarCreator().createCar(databaseManager, ui, companyId);
    }

    @Override
    public String description() {
        return "Create a car";
    }
}