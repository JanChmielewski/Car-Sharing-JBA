package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;

import java.util.List;

public class CustomerMenu extends AbstractCommandPatternMenu {

    private final List<MenuOption> options;

    public CustomerMenu(DatabaseManager databaseManager) {
        super(databaseManager);
        this.options = List.of(
                new RentCarOption(), // TODO: add rent car option
                new ReturnCarOption(), // TODO: add return car option
                new MyRentedCarOption() // TODO: add my rented car option
        );
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
