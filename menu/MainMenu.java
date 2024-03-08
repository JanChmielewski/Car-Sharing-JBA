package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.ManagerLoginOption;
import carsharing.menu.options.MenuOption;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AbstractCommandPatternMenu {

    private final List<MenuOption> options;

    public MainMenu(DatabaseManager databaseManager) {
        super(databaseManager);
        this.options = new ArrayList<>();
        options.add(new ManagerLoginOption());
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
