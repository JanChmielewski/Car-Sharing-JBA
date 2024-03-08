package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.CreateCompanyOption;
import carsharing.menu.options.MenuOption;
import carsharing.menu.options.ShowCompanyListOption;
//import carsharing.menu.options.ShowCompanyListOption;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class ManagerMenu extends AbstractCommandPatternMenu {

    private final List<MenuOption> options;

    public ManagerMenu(DatabaseManager databaseManager) {
        super(databaseManager);
        this.options = new ArrayList<>();
        options.add(new ShowCompanyListOption());
        options.add(new CreateCompanyOption());
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
