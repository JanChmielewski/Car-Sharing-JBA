package carsharing.db.entity;

public class Car {
    private int id;
    private String name;
    private int companyId;

    public Car(String name, int companyId) {
        this.name = name;
        this.companyId = companyId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return name;
    }
}
