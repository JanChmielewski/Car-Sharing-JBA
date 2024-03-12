package carsharing.service.companyService;

import carsharing.db.DatabaseManager;
import carsharing.service.UI;

public class CarCreator {
    public void createCar(DatabaseManager databaseManager, UI ui, String companyName) {
        ui.displayMessage("Enter the car name:");
        String carName = ui.getAnswer();
        int companyId = databaseManager.getCompanyIdByName(companyName);
        if (companyId != -1) {
            databaseManager.addCar(carName, companyId);
        } else {
            ui.displayMessage("The company does not exist!");
        }
    }
}
