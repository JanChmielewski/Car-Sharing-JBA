package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.managerOptions.ManagerLoginOption;
import carsharing.menu.options.MenuOption;
import carsharing.menu.options.customerOptions.CustomerCreateOption;
import carsharing.menu.options.customerOptions.CustomerLoginOption;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AbstractCommandPatternMenu {
    private final List<MenuOption> options;

    public MainMenu(DatabaseManager databaseManager) {
        super(databaseManager);
        this.options = new ArrayList<>();
        options.addAll(List.of(
                new ManagerLoginOption(),
                new CustomerLoginOption(),
                new CustomerCreateOption()
                ));
    }

    @Override
    protected List<MenuOption> getOptions() {
        return options;
    }

    @Override
    protected String getBackOption() {
        return "Exit";
    }
}
