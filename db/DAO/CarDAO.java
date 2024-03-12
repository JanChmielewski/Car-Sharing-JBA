package carsharing.db.DAO;

import carsharing.db.entity.Car;

import java.util.List;

public interface CarDAO {
    void addCar(String carName, int companyId);
    void deleteCar(int id);
    List<Car> getCars();
    Car getCarById(int id);
    List<Car> getCarsByCompanyId(int companyId);
    void updateCar(Car car);
}
