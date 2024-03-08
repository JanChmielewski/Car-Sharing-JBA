package carsharing.db.entity;
public class Company {
    private int id;
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
