package carsharing.service.managerService;

import carsharing.db.DatabaseManager;
import carsharing.menu.CompanyMenu;
import carsharing.service.UI;


public class CompanyListViewer {
    public void showCompanyListAndChoose(DatabaseManager companyManager, UI ui) {
        if (companyManager.getCompanies().isEmpty()) {
            ui.displayMessage("The company list is empty!");
        } else {
            ui.displayList("Company list:", companyManager.getCompanies());
            ui.getUserChoice();
            new CompanyMenu(companyManager.getCompanyById(ui.getUserChoice() - 1).getName(), companyManager, ui).showMenu();
        }
    }
}
