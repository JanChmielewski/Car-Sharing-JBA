package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.menu.options.companyOptions.CreateCarOption;
import carsharing.menu.options.companyOptions.ShowCarsListOption;
import carsharing.service.UI;

import java.util.ArrayList;
import java.util.List;

public class CompanyMenu extends AbstractCommandPatternMenu {

    private final List<MenuOption> options;

    public CompanyMenu(String companyName, DatabaseManager databaseManager, UI ui) {
        super(databaseManager);
        this.options = new ArrayList<>();
        ui.displayMessage(String.format("'%s' company:", companyName));
        options.addAll(List.of(
                new ShowCarsListOption(),
                new CreateCarOption()
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
