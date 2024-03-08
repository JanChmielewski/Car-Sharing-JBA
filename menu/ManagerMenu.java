package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.managerOptions.CreateCompanyOption;
import carsharing.menu.options.MenuOption;
import carsharing.menu.options.managerOptions.ShowAndChooseCompanyListOption;
//import carsharing.menu.options.managerOptions.ShowCompanyListOption;

import java.util.ArrayList;
import java.util.List;

public class ManagerMenu extends AbstractCommandPatternMenu {

    private final List<MenuOption> options;

    public ManagerMenu(DatabaseManager databaseManager) {
        super(databaseManager);
        this.options = new ArrayList<>();
        options.addAll(List.of(
                new ShowAndChooseCompanyListOption(),
                new CreateCompanyOption()
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
