package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;
import carsharing.service.UI;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class AbstractCommandPatternMenu {
    private final DatabaseManager databaseManager;
    private final UI ui;

    public AbstractCommandPatternMenu(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.ui = new UI();
    }

    public void showMenu() {
        while (true) {
            AtomicInteger counter = new AtomicInteger(1);
            getOptions().forEach(option -> System.out.printf("%d. %s%n", counter.getAndIncrement(), option.description()));
            System.out.printf("%d. %s%n", 0, getBackOption());

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

