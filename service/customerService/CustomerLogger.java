package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.menu.CustomerMenu;
import carsharing.service.UI;

import java.util.List;

public class CustomerLogger {
    public void login(DatabaseManager databaseManager, UI ui) {
        List<Customer> customers = databaseManager.getCustomers();
        if (customers.isEmpty()) {
            ui.displayMessage("The customer list is empty!");
            return;
        }
        ui.displayList("Choose a customer:", customers);
        ui.displayMessage("0. Back");
        int choice = ui.getUserChoice();
        if (choice == 0) {
            return;
        }
        Customer customer = customers.get(choice - 1);
        new CustomerMenu(databaseManager, customer).showMenu();
    }
}
