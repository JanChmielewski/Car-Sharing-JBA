package carsharing.db.entity;

public class Customer {
    int id;
    String name;
    int rentedCarId;

    public Customer(String name) {
        this.name = name;
    } //

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

    public int getRentedCarId() {
        return rentedCarId;
    }

    public void setRentedCarId(int rentedCarId) {
        this.rentedCarId = rentedCarId;
    }
}
