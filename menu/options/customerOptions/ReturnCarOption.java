package carsharing.menu.options.customerOptions;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;
import carsharing.service.customerService.CarReturner;

public class ReturnCarOption implements MenuOption {
    private final Customer customer;
    public ReturnCarOption(Customer customer)  {
        this.customer = customer;
    }

    @Override
    public void execute(DatabaseManager databaseManager, UI ui) {
        new CarReturner().returnCar(databaseManager, ui, customer);
    }

    @Override
    public String description() {
        return "Return a rented car";
    }
}
