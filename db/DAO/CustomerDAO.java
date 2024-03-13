package carsharing.db.DAO;

import carsharing.db.entity.Car;
import carsharing.db.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public Customer getCustomerById(int id);
    public void addCustomer(String customerName);
    public void updateCustomersRentedCarId(Customer customer);
    public void deleteCustomer(int id);
    public int getCustomerIdByName(String name);
    public Car getRentedCarByCustomer(int rentedCarId);
}
