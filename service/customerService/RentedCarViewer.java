package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Car;
import carsharing.db.entity.Customer;
import carsharing.service.UI;

public class RentedCarViewer {
    public void showRentedCar(DatabaseManager databaseManager, UI ui, Customer customer) {
        Car rentedCar = databaseManager.getCarById(customer.getRentedCarID());
        if (rentedCar != null) {
            ui.displayMessage("Your rented car:\n" + rentedCar.getName() + "\nCompany: \n" + databaseManager.getCompanyById(rentedCar.getCompanyId()).toString());
        } else {
            ui.displayMessage("You didn't rent a car!");
        }
    }
}
