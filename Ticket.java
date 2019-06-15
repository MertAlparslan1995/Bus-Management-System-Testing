package BusReservation;
public class Ticket extends Item {
    private String id;
    private double price;
    private User user;
    private Bus bus;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    // This will implement in final version!
    public String display() {
        return this.id;
    }

}
