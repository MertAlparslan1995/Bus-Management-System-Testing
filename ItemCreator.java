package BusReservation;
import java.util.ArrayList;

public class ItemCreator {
    // These are lists for users, buses and tickets
    private ArrayList<User> users;


    // This is constructor method
    public ItemCreator() {
        users = new ArrayList<User>();
        buses = new ArrayList<Bus>();
        tickets = new ArrayList<Ticket>();
    }

    // Creating user with their username
    public String createUser(String username) {
        User user = new User();
        user.setUsername(username);

        // Checking user if not exist
        if(isUserExist(user)) {
            System.out.println("This user exist!");
            return "this user exist!";
        } else {
            users.add(user);
            System.out.println("Added");
            return"added";
        }
       

    }

   
    // Checking user
    public boolean isUserExist(User user) {
        return users.contains(user);
    }

    // Finding user in users
    public User findUser(User user) {
        int indexOfUser = users.indexOf(user);
        user = users.get(indexOfUser);

        return user;
    }

    
}
