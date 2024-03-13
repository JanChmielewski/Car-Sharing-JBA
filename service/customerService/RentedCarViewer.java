package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.service.UI;

public class RentedCarViewer {
    public void showRentedCar(DatabaseManager databaseManager, UI ui, Customer customer)  {
        int carId = customer.getRentedCarID();
        if (carId != 0) {
            ui.displayMessage("Your rented car:\n" + databaseManager.getCarById(carId).getName()
                    + "\nCompany:\n" + databaseManager.getCompanyById(databaseManager.getCarById(carId).getCompanyId()).getName());
        } else {
            ui.displayMessage("You didn't rent a car!");
        }
    }
}
