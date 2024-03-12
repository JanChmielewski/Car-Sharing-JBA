package carsharing.service;

import java.util.List;
import java.util.Scanner;

public class UI {
    private final Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public String getAnswer() {
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            input = scanner.nextLine().trim();
        }
        return input;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.err.println(error);
    }

    public void displayMenu(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public void displayList(String message, List<?> listToDisplay) {
        System.out.println(message);
        for (int i = 0; i < listToDisplay.size(); i++) {
            System.out.println((i + 1) + ". " + listToDisplay.get(i));
        }
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }
}
