package carsharing.db;

import carsharing.db.DAO.CarDAO;
import carsharing.db.DAO.CompanyDAO;
import carsharing.db.DAO.CustomerDAO;
import carsharing.db.entity.Car;
import carsharing.db.entity.Company;
import carsharing.db.entity.Customer;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DatabaseManager implements CompanyDAO, CarDAO, CustomerDAO {

    private final DatabaseClient dbClient;

    private static final String CREATE_COMPANY = "CREATE TABLE IF NOT EXISTS COMPANY (" +
            "ID int AUTO_INCREMENT(1) PRIMARY KEY, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL" +
            ");";
    private static final String CREATE_CAR = "CREATE TABLE IF NOT EXISTS CAR (" +
            "ID int AUTO_INCREMENT(1), " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "COMPANY_ID int NOT NULL, " +
            "PRIMARY KEY (ID), " +
            "FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID)" +
            ");";
    private static final String CREATE_CUSTOMER = "CREATE TABLE IF NOT EXISTS CUSTOMER (" +
            "ID int AUTO_INCREMENT(1) PRIMARY KEY, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "RENTED_CAR_ID int DEFAULT NULL, " +
            "FOREIGN KEY (RENTED_CAR_ID) REFERENCES CAR(ID)" +
            ");";

    private static final String SELECT_COMPANIES = "SELECT * FROM COMPANY";
    private static final String SELECT_COMPANY_BY_ID = "SELECT * FROM COMPANY WHERE ID = %d";
    private static final String UPDATE_COMPANY = "UPDATE COMPANY SET NAME = '%s' WHERE ID = %d";
    private static final String DELETE_COMPANY = "DELETE FROM COMPANY WHERE ID = %d";
    private static final String INSERT_COMPANY = "INSERT INTO COMPANY (NAME) VALUES ('%s')";
    private static final String SELECT_COMPANY_ID = "SELECT ID FROM COMPANY WHERE NAME = '%s'";
    private static final String SELECT_CARS = "SELECT * FROM CAR";
    private static final String SELECT_CAR_BY_ID = "SELECT * FROM CAR WHERE ID = %d";
    private static final String SELECT_CARS_BY_COMPANY_ID = "SELECT * FROM CAR WHERE COMPANY_ID = %d";
    private static final String RENT_CAR = "UPDATE CUSTOMER SET RENTED_CAR_ID = %d WHERE ID = %d";
    private static final String INSERT_CAR = "INSERT INTO CAR (NAME, COMPANY_ID) VALUES ('%s', %d)";
    private static final String RETURN_CAR = "UPDATE CUSTOMER SET RENTED_CAR_ID = NULL WHERE ID = %d";
    private static final String SELECT_RENTED_CARS = "SELECT * FROM CAR WHERE ID IN (SELECT RENTED_CAR_ID FROM CUSTOMER WHERE RENTED_CAR_ID IS NOT NULL)";
    private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER (NAME) VALUES ('%s')";
    private static final String SELECT_CUSTOMERS = "SELECT * FROM CUSTOMER";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM CUSTOMER WHERE ID = %d";
    private static final String UPDATE_CUSTOMERS_RENTED_CAR_ID = "UPDATE CUSTOMER SET RENTED_CAR_ID = %d WHERE ID = %d";

    public DatabaseManager(Connection connection) throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(connection.getMetaData().getURL());
        dbClient = new DatabaseClient(dataSource);
        try {
            dbClient.run(CREATE_COMPANY);
            dbClient.run(CREATE_CAR);
            dbClient.run(CREATE_CUSTOMER);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table." + e.getMessage());
        }
    }

    @Override
    public List<Company> getCompanies() {
        return dbClient.selectCompaniesForList(SELECT_COMPANIES);
    }

    @Override
    public Company getCompanyById(int id) {
        Company company;
        try {
            company = dbClient.selectName(String.format(SELECT_COMPANY_BY_ID, id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (company != null) {
            System.out.println("Company name: " + company.getName());
            return company;
        } else {
            System.out.println("The company with this ID does not exist.");
            return null;
        }
    }

    @Override
    public void addCompany(Company company) {
        try {
            dbClient.run(String.format(
                    INSERT_COMPANY, company.getName()));
            System.out.println("The company was created!");
        } catch (SQLException e) {
            System.out.println("Error adding company." + e.getMessage());
        }
    }

    @Override
    public void updateCompany(Company company) {
        try {
            dbClient.run(String.format(
                    UPDATE_COMPANY, company.getName(), company.getId()));
            System.out.println("Company: ID " + company.getId() + " name: " + company.getName() + " was updated.");
        } catch (SQLException e) {
            System.out.println("Error updating company." + e.getMessage());
        }

    }

    @Override
    public void deleteCompany(int id) {
        try {
            dbClient.run(String.format(DELETE_COMPANY, id));
            System.out.println("Company with ID " + id + " was deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting company." + e.getMessage());
        }
    }

    @Override
    public int getCompanyIdByName(String companyName) {
        try {
            return dbClient.selectID(String.format(SELECT_COMPANY_ID, companyName));
        } catch (SQLException e) {
            System.out.println("Error getting company ID." + e.getMessage());
            throw new RuntimeException("Error getting company ID." + e.getMessage());
        }
    }

    @Override
    public void addCar(Car car) {
        try {
            if (getCompanyById(car.getCompanyId()) != null) {
                dbClient.insert(String.format(
                        INSERT_CAR, car.getName(), car.getCompanyId()));
                System.out.println("The car was created!");
            } else {
                System.out.println("Error adding car. The company with ID " + car.getCompanyId() + " does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding car." + e.getMessage());
        }
    }

    public List<Car> getCarsById(int companyId) {
        return dbClient.selectCarsForList(String.format(SELECT_CARS_BY_COMPANY_ID, companyId));
    }

    @Override
    public List<Car> getAllCars() {
        return dbClient.selectCarsForList(SELECT_CARS);
    }

    @Override
    public List<Car> getRentedCars() {
        return dbClient.selectCarsForList(SELECT_RENTED_CARS);
    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public Company getCompanyByCarId(int carId) {
        try {
            return getCompanyById(dbClient.selectID(String.format(SELECT_CAR_BY_ID, carId)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car getCarById(int id) {
        Car car;
        try {
            car = dbClient.selectCar(String.format(SELECT_CAR_BY_ID, id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (car != null) {
            System.out.println("Car name: " + car.getName());
            return car;
        } else {
            System.out.println("The car with this ID does not exist.");
            return null;
        }
    }

    @Override
    public List<Customer> getCustomers() {
        return dbClient.selectCustomersForList(SELECT_CUSTOMERS);
    }

    @Override
    public Customer getCustomerById(int id) {
        try {
            return dbClient.selectCustomer(String.format(SELECT_CUSTOMER_BY_ID, id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addCustomer(String customerName) {
        try {
            dbClient.insert(String.format(INSERT_CUSTOMER, customerName));
        } catch (SQLException e) {
            System.out.println("Error adding customer." + e.getMessage());
        }
    }

    @Override
    public void updateCustomersRentedCarId(Customer customer) {
        String query = String.format(UPDATE_CUSTOMERS_RENTED_CAR_ID, customer.getRentedCarID(), customer.getId());
        try {
            dbClient.update(query);
        } catch (SQLException e) {
            System.out.println("Error updating customer." + e.getMessage());
        }
    }

    @Override
    public void deleteCustomer(int id) {

    }

    @Override
    public int getCustomerIdByName(String name) {
        return 0;
    }

    @Override
    public Car getRentedCarByCustomer(int rentedCarId) {
        return null;
    }
}

