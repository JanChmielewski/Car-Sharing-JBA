package carsharing.db.DAO;

import carsharing.db.entity.Car;
import carsharing.db.entity.Company;
import carsharing.db.entity.Customer;

import java.util.List;

public interface CarDAO {
    void addCar(Car car);
    List<Car> getCarsById(int companyId);
    void rentCar(Customer customer, Car chosenCar);
    Car getCarById(int id);
}
