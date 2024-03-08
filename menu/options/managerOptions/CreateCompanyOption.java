package carsharing.menu.options.managerOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.managerService.CompanyCreator;

public class CreateCompanyOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CompanyCreator().createCompany(databaseManager);
    }

    @Override
    public String description() {
        return "Create a company";
    }
}
