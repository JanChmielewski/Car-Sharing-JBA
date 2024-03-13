package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.service.UI;

public class CustomerCreator {
    public void createCustomer(DatabaseManager databaseManager, UI ui) {
        ui.displayMessage("Enter the customer name:");
        String customerName = ui.getAnswer();
        databaseManager.addCustomer(new Customer(customerName));
    }
}
