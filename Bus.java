package BusReservation;

public class Bus extends Item {
    private int id;
    private String plate;
    private int capacity;
    private String start;
    private String end;

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String display() {
        return this.id + "\t\t" + this.plate + "\t\t" + this.capacity + "\t\t" + this.start + "\t\t" + this.end;
    }

    // With this method, we will compare buses with their id
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bus) {
            Bus b = (Bus) obj;
            return this.id == b.id;
        }

        return false;
    }
}
