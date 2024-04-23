package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.service.UI;


public class CarReturner {
    public void returnCar(DatabaseManager databaseManager, UI ui, Customer customer) {
        if (customer.getRentedCarID() == 0) {
            ui.displayMessage("You didn't rent a car!");
            return;
        }
        databaseManager.returnCar(customer);
        ui.displayMessage("You've returned a rented car!");
    }
}