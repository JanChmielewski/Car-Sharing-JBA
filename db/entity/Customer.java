package carsharing.db.entity;

public class Customer {
    private int id;
    private String name;
    private Integer rentedCarID;

    public Customer(int id, String name, int rentedCarID) {
        this.id = id;
        this.name = name;
        this.rentedCarID = rentedCarID;
    }

    public Customer(String name) {
        this.name = name;
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

    public Integer getRentedCarID() {
        return rentedCarID;
    }

    public void setRentedCarID(Integer rentedCarID) {
        this.rentedCarID = rentedCarID;
    }

}
