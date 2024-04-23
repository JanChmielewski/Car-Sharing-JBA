package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Car;
import carsharing.db.entity.Company;
import carsharing.db.entity.Customer;
import carsharing.service.UI;

import java.util.List;

public class CarRentingService {

    public void rentCar(DatabaseManager databaseManager, UI ui, Customer customer) {
        List<Company> companies = databaseManager.getCompanies();
        if (companies.isEmpty()) {
            ui.displayMessage("The company list is empty!");
            return;
        }
        if (customer.getRentedCarID() != 0) {
            ui.displayMessage("You've already rented a car!");
            return;
        }
        ui.displayList("Choose a company:", companies);
        ui.displayMessage("0. Back");
        int companyChoice = ui.getUserChoice();
        if (companyChoice == 0) {
            return;
        }
        Company chosenCompany = databaseManager.getCompanyById(companyChoice);
        if (databaseManager.getAvailableCars(chosenCompany.getId()).isEmpty()) {
            ui.displayMessage("No available cars in this company!");
            return;
        }
        ui.displayList("Choose a car:", databaseManager.getAvailableCars(chosenCompany.getId()));
        int carChoice = ui.getUserChoice();
        ui.displayMessage("0. Back");
        if (carChoice == 0) {
            return;
        }
        Car chosenCar = databaseManager.getCarById(carChoice);
        databaseManager.rentCar(customer, chosenCar);

        ui.displayMessage("You rented '" + chosenCar.getName() + "'");


    }
}
