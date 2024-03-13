package carsharing.service.customerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.menu.CustomerMenu;
import carsharing.service.UI;

public class CustomerListViewer {
    public void showCustomerListAndChoose(DatabaseManager customerManager, UI ui) {
        if (customerManager.getCustomers().isEmpty()) {
            ui.displayMessage("The customer list is empty!");
        } else {
            ui.displayList("Choose a customer: ", customerManager.getCustomers());
            ui.displayMessage("0. Back");
            int choice = ui.getUserChoice();
            if (choice == 0) {
                return;
            }
            Customer chosenCustomer = customerManager.getCustomerById(choice);
            if (chosenCustomer != null) {
                new CustomerMenu(customerManager).showMenu();
            } else {
                ui.displayMessage("No such customer!");
            }
        }
    }
}
