package carsharing.service;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Company;

import java.util.Scanner;

public class CompanyCreator {
    public void createCompany(DatabaseManager databaseManager) {
        System.out.println("Enter the company name:");
        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.nextLine();
        databaseManager.addCompany(new Company(companyName));
    }
}
