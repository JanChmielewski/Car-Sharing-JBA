package carsharing.service.managerService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Company;
import carsharing.menu.CompanyMenu;
import carsharing.service.UI;


public class CompanyListViewer {
    public void showCompanyListAndChoose(DatabaseManager companyManager, UI ui) {
        if (companyManager.getCompanies().isEmpty()) {
            ui.displayMessage("The company list is empty!");
        } else {
            ui.displayList("Company list:", companyManager.getCompanies());
            ui.displayMessage("0. Back");
            int choice = ui.getUserChoice();
            if (choice == 0) {
                return;
            }
            Company chosenCompany = companyManager.getCompanyById(choice);
            if (chosenCompany != null) {
                new CompanyMenu(chosenCompany.getName(), companyManager, ui).showMenu();
            } else {
                ui.displayMessage("No such company!");
            }
        }
    }
}
