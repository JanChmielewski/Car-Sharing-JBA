package carsharing.db;

import carsharing.db.entity.Company;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClient {
    private final DataSource dataSource;

    public DatabaseClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void run(String str) throws SQLException {
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()) {
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Company select(String query) {
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSetItem = statement.executeQuery(query)) {
            if (resultSetItem.next()) {
                return new Company(resultSetItem.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Company> selectForList(String query) {
        List<Company> companies = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSetItem = statement.executeQuery(query)) {
            while (resultSetItem.next()) {
                companies.add(new Company(resultSetItem.getString("NAME")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }
}