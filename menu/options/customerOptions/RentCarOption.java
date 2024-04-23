package carsharing.menu.options.customerOptions;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.customerService.CarRentingService;

public class RentCarOption implements MenuOption {
    private final Customer customer;
    public RentCarOption(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CarRentingService().rentCar(databaseManager, ui, customer);
    }

    @Override
    public String description() {
        return "Rent a car";
    }
}
