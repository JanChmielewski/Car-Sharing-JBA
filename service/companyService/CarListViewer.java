package carsharing.service.companyService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Car;
import carsharing.service.UI;

import java.util.List;

public class CarListViewer {

    public void showCarList(DatabaseManager databaseManager, UI ui, int companyId) {
        List<Car> cars = databaseManager.getCarsById(companyId);
        if (cars.isEmpty()) {
            ui.displayMessage("The car list is empty!");
            return;
        }
        ui.displayList("Car list:", cars);
    }
}