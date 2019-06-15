package BusReservation;
public class User extends Item {
    private String username;


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String display() {
        return this.username;
    }

    // With this method, we will compare users with their username
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            User u = (User) obj;
            return this.username.equals(u.username);
        }

        return false;
    }
}
