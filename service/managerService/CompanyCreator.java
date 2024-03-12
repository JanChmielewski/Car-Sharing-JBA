package carsharing.service.managerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Company;
import carsharing.service.UI;

public class CompanyCreator {
    public void createCompany(DatabaseManager databaseManager, UI ui) {
        ui.displayMessage("Enter the company name:");
        String companyName = ui.getAnswer();
        databaseManager.addCompany(new Company(companyName));
    }
}
