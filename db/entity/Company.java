package carsharing.db.entity;
public class Company {
    private int id;
    private final String name;

    public Company(String name) {
        this.name = name;
    }

    public Company(int id, String name) {
        this.id = id;
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

    @Override
    public String toString() {
        return name;
    }
}
