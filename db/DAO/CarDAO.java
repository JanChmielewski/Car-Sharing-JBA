package carsharing.db.DAO;

import carsharing.db.entity.Car;
import carsharing.db.entity.Company;

import java.util.List;

public interface CarDAO {
    void addCar(Car car);
    List<Car> getCarsById(int companyId);
    List<Car> getAllCars();
    List<Car> getRentedCars();
    void updateCar(Car car);
    Company getCompanyByCarId(int carId);
    Car getCarById(int id);
}
