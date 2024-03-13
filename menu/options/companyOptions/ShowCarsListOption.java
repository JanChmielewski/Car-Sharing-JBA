package carsharing.menu.options.companyOptions;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.companyService.CarListViewer;

public class ShowCarsListOption implements MenuOption {
    private final int companyId;

    public ShowCarsListOption(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CarListViewer().showCarList(databaseManager, ui, companyId);
    }

    @Override
    public String description() {
        return "Car list";
    }
}