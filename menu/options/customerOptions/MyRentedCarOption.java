package carsharing.menu.options.customerOptions;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.customerService.RentedCarViewer;

public class MyRentedCarOption implements MenuOption {
    private final Customer customer;
    public MyRentedCarOption(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new RentedCarViewer().showRentedCar(databaseManager, ui, customer);
    }

    @Override
    public String description() {
        return "My rented car";
    }
}
