package carsharing.db;

import carsharing.db.entity.Company;

import java.util.List;

public interface CompanyDAO {
    List<Company> getCompanies();
    Company getCompanyById(int id);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int id);
}
