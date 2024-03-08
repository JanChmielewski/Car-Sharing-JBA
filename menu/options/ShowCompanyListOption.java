package carsharing.menu.options;

import carsharing.db.DatabaseManager;
import carsharing.service.CompanyListViewer;

public class ShowCompanyListOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager) {
        new CompanyListViewer().showCompanyList(databaseManager);
    }

    @Override
    public String description() {
        return "Company list";
    }
}
