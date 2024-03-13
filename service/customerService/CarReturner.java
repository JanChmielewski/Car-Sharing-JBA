package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.service.UI;

public class CarReturner {
    public void returnCar(DatabaseManager databaseManager, UI ui, Customer customer) {
        Integer rentedCarID = customer.getRentedCarID();
        if (rentedCarID == null) {
            ui.displayMessage("You didn't rent a car!");
        } else {
            customer.setRentedCarID(null);
            databaseManager.updateCustomersRentedCarId(customer);
            ui.displayMessage("You've returned a rented car!");
        }
    }

}
