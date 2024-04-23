package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Customer;
import carsharing.menu.options.MenuOption;
import carsharing.menu.options.customerOptions.MyRentedCarOption;
import carsharing.menu.options.customerOptions.RentCarOption;
import carsharing.menu.options.customerOptions.ReturnCarOption;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenu extends AbstractCommandPatternMenu {
    private final List<MenuOption> options;
    public CustomerMenu(DatabaseManager databaseManager, Customer customer) {
        super(databaseManager);
        this.options = new ArrayList<>();
        options.addAll(List.of(
                new RentCarOption(customer),
                new ReturnCarOption(customer),
                new MyRentedCarOption(customer)
        ));
    }

    @Override
    protected List<MenuOption> getOptions() {
        return options;
    }

    @Override
    protected String getBackOption() {
        return "Back";
    }
}
