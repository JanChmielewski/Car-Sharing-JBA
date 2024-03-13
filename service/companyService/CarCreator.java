package carsharing.service.companyService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Car;
import carsharing.service.UI;

public class CarCreator {
    public void createCar(DatabaseManager databaseManager, UI ui, int companyId) {
        ui.displayMessage("Enter the car name:");
        String carName = ui.getAnswer();
        if (companyId != -1) {
            databaseManager.addCar(new Car(carName, companyId));
        } else {
            ui.displayMessage("The company does not exist!");
        }
    }
}