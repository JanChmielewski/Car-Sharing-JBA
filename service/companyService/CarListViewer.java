package carsharing.service.companyService;

import carsharing.db.DatabaseManager;
import carsharing.db.entity.Car;
import carsharing.service.UI;

import java.util.List;

public class CarListViewer {
    public void showCarList(DatabaseManager carManager, UI ui, String companyName) {
        List<Car> cars = carManager.getCarsByCompanyId(carManager.getCompanyIdByName(companyName));
        if (cars == null || cars.isEmpty()) {
            ui.displayMessage("The car list is empty!");
        } else {
            ui.displayList("Car list:", cars);
        }
    }
}
