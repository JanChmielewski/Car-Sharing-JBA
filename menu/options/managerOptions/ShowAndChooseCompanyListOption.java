package carsharing.menu.options.managerOptions;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.companyService.CompanyListViewer;

public class ShowAndChooseCompanyListOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CompanyListViewer().showCompanyListAndChoose(databaseManager, ui);
    }

    @Override
    public String description() {
        return "Company list";
    }
}
