package carsharing.service;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Company;

import java.util.List;

public class CompanyListViewer {
    public void showCompanyList(DatabaseManager companyManager) {
        List<Company> companies = companyManager.getCompanies();
        if (companyManager.getCompanies().isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Company list:");
            for (int i = 0; i < companies.size(); i++) {
                System.out.println((i + 1) + ". " + companies.get(i).getName());
            }
        }
    }
}
