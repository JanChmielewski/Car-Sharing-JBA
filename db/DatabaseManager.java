package carsharing.db;

import carsharing.db.entity.Company;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DatabaseManager implements CompanyDAO {

    private final DatabaseClient dbClient;

    private static final String CREATE_COMPANY = "CREATE TABLE IF NOT EXISTS COMPANY (" +
            "ID int AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "PRIMARY KEY (ID))";
    private static final String CREATE_CAR = "CREATE TABLE IF NOT EXISTS CAR (" +
            "ID int AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "COMPANY_ID int NOT NULL, " +
            "PRIMARY KEY (ID), " +
            "FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID))";
    private static final String SELECT_COMPANIES = "SELECT * FROM COMPANY";
    private static final String SELECT_COMPANY_BY_ID = "SELECT * FROM COMPANY WHERE ID = %d";
    private static final String UPDATE_COMPANY = "UPDATE COMPANY SET NAME = '%s' WHERE ID = %d";
    private static final String DELETE_COMPANY = "DELETE FROM COMPANY WHERE ID = %d";
    private static final String INSERT_COMPANY = "INSERT INTO COMPANY (NAME) VALUES ('%s')";

    public DatabaseManager(Connection connection) throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(connection.getMetaData().getURL());
        dbClient = new DatabaseClient(dataSource);
        try {
            dbClient.run(CREATE_COMPANY);
            dbClient.run(CREATE_CAR);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table." + e.getMessage());
        }
    }

    @Override
    public List<Company> getCompanies() {
        return dbClient.selectForList(SELECT_COMPANIES);
    }

    @Override
    public Company getCompanyById(int id) {
        Company company = dbClient.select(String.format(SELECT_COMPANY_BY_ID, id));

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
}

