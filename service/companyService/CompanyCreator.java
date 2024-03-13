package carsharing.service.companyService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Company;
import carsharing.service.UI;

public class CompanyCreator {
    public void createCompany(DatabaseManager databaseManager, UI ui) {
        ui.displayMessage("Enter the company name:");
        String companyName = ui.getAnswer();
        Company company = new Company(companyName);
        company.setId(databaseManager.getCompanies().size() + 1);
        databaseManager.addCompany(company);
    }
}
