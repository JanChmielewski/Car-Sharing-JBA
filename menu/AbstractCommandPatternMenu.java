package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;

import java.util.List;


public abstract class AbstractCommandPatternMenu {
    private final DatabaseManager databaseManager;
    private final UI ui;

    public AbstractCommandPatternMenu(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.ui = new UI();
    }

    public void showMenu() {
        while (true) {
            List<String> options = new java.util.ArrayList<>(getOptions().stream()
                    .map(MenuOption::description)
                    .toList());
            options.add(getBackOption());
            ui.displayMenu(options);

            int choice = ui.getUserChoice();
            if (choice == 0) {
                break;
            } else {
                getOptions().get(choice - 1).execute(databaseManager, ui);
            }
        }
    }

    protected abstract List<MenuOption> getOptions();

    protected abstract String getBackOption();

}

