package carsharing.menu;

import carsharing.db.DatabaseManager;
import carsharing.menu.options.MenuOption;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractCommandPatternMenu {
    private final DatabaseManager databaseManager;

    public AbstractCommandPatternMenu(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void showMenu() {
        while (true) {
            AtomicInteger counter = new AtomicInteger(1);
            getOptions().forEach(option -> System.out.printf("%d. %s%n", counter.getAndIncrement(), option.description()));
            System.out.printf("%d. %s%n", 0, getBackOption());

            int choice = new Scanner(System.in).nextInt();
            if (choice == 0) {
                break;
            } else {
                getOptions().get(choice - 1).execute(databaseManager);
            }
        }
    }

    protected abstract List<MenuOption> getOptions();

    protected abstract String getBackOption();

}

