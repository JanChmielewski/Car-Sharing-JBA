package carsharing.db;

import carsharing.db.entity.Car;
import carsharing.db.entity.Company;
import carsharing.db.entity.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClient {
    private final DataSource dataSource;

    public DatabaseClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(String query) throws SQLException {
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void update(String querry) throws SQLException {
        try (Statement stmt = dataSource.getConnection().createStatement()) {
            stmt.executeUpdate(querry);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void run(String str) throws SQLException {
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement()) {
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Company selectName(String query) throws SQLException {
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement(); ResultSet resultSetItem = statement.executeQuery(query)) {
            if (resultSetItem.next()) {
                return new Company(resultSetItem.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public List<Company> selectCompaniesForList(String query) {
        List<Company> companies = new ArrayList<>();
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement(); ResultSet resultSetItem = statement.executeQuery(query)) {
            while (resultSetItem.next()) {
                companies.add(new Company(resultSetItem.getString("NAME")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public List<Car> selectCarsForList(String query) {
        List<Car> cars = new ArrayList<>();
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement(); ResultSet resultSetItem = statement.executeQuery(query)) {
            while (resultSetItem.next()) {
                cars.add(new Car(resultSetItem.getInt("ID"), resultSetItem.getString("NAME"), resultSetItem.getInt("COMPANY_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public int selectID(String query) throws SQLException {
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement(); ResultSet resultSetItem = statement.executeQuery(query)) {
            if (resultSetItem.next()) {
                return resultSetItem.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return -1;
    }

    public List<Customer> selectCustomersForList(String selectCustomers) {
        List<Customer> customers = new ArrayList<>();
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement(); ResultSet resultSetItem = statement.executeQuery(selectCustomers)) {
            while (resultSetItem.next()) {
                customers.add(new Customer(resultSetItem.getString("NAME")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer selectCustomer(String query) throws SQLException {
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new Customer(resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getInt("RENTED_CAR_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public Car selectCar(String query) throws SQLException {
        try (Connection con = dataSource.getConnection(); Statement statement = con.createStatement(); ResultSet resultSetItem = statement.executeQuery(query)) {
            if (resultSetItem.next()) {
                return new Car(resultSetItem.getInt("ID"), resultSetItem.getString("NAME"), resultSetItem.getInt("COMPANY_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
}