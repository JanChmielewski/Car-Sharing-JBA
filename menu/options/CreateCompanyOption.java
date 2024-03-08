package carsharing.menu.options;

import carsharing.db.DatabaseManager;
import carsharing.service.CompanyCreator;

public class CreateCompanyOption implements MenuOption {
    @Override
    public void execute(DatabaseManager databaseManager) {
        new CompanyCreator().createCompany(databaseManager);
    }

    @Override
    public String description() {
        return "Create a company";
    }
}
