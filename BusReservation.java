package BusReservation;

import java.util.Scanner;


public class BusReservation {

    public static String[] cities = {"izmir", "istanbul", "Ankara"};
    //Prices of the tickets
    public static int singleSeatPriceIzmirToIstanbul = 90;
    public static int singleSeatPriceIzmirToAnkara = 85;
    public static int singleSeatPriceIstanbulToIzmir = 90;
    public static int singleSeatPricePriceIstanbulToAnkara = 65;
    public static int singleSeatPriceAnkaraToIzmir = 85;
    public static int singleSeatPriceAnkaraToIstanbul = 65;
    public static int[] singleSeatNumberAvailability = new int[30]; //availability checking array
    public static int[] singleSeatNumber = new int[30]; //total seats

    //Prices of the tickets
    public static int regularPriceIzmirToIstanbul = 85;
    public static int regularPriceIzmirToAnkara = 80;
    public static int regularPriceIstanbulToIzmir = 85;
    public static int regularPriceIstanbulToAnkara = 60;
    public static int regularPriceAnkaraToIzmir = 80;
    public static int regularPriceAnkaraToIstanbul = 60;
    public static int[] regularSeatNumberAvailability = new int[40]; //availability checking array
    public static int[] regularSeatNumber = new int[40]; //total seats

    public static int minuteIzmirToIstanbul = 390;
    public static int minuteIzmirToAnkara = 330;
    public static int minuteIstanbulToAnkara = 270;

    public int ticketNumber = 1000;
    public int choice;

    public int currentTicketPrice;
    public String busType = "";

    public String currentCity;
    public String destinationCity;

    public BusReservation() {};

    //param ctor
    BusReservation(int i,String busType,String currentCity,String destinationCity,int currentTicketPrice){
    	i = 0;
    	busType = "";
    	currentCity = "";
    	destinationCity = "";
    	currentTicketPrice = 0;
    };

    //checks if the given parameter is in bound and available if it is, the chosen seat become unavailable
    public static boolean checkRegularSeatNumber(int i) {
        if (i > 0 && i < 41 && regularSeatNumberAvailability[i] != 1) {
            regularSeatNumberAvailability[i] = 1;
            System.out.println("Desired seat is available.");
            setRegularSeat(i);
            return true;
        } 
        else if (i < 1 || i > 40) {
            System.out.println("You can't choose this seat.");
        } 
        else if (regularSeatNumberAvailability[i] == 1) {
            System.out.println("Desired seat is already taken, you can choose following seats for the bus.");
            for (i = 1; i < 41; i++) {
                while (regularSeatNumber[i] != 1) {
                    System.out.printf("%d \n", i);
                }
            }
        }
        return false;
    }

    public static void setRegularSeat(int i) {
        regularSeatNumber[i] = i;
    }

    public static void setSingleSeat(int i) {
        singleSeatNumber[i] = i;
    }

    //checks if the given parameter is in bound and available if it is, the chosen seat become unavailable
    public static boolean checkSingleSeatNumber(int i) {
        if (i > 0 && i < 31 && singleSeatNumberAvailability[i] != 1) {
            singleSeatNumberAvailability[i] = 1;
            System.out.println("Desired seat is available.");
            setSingleSeat(i);
            return true;
        }
        else if (i < 1 || i > 30) {
            System.out.println("You can't choose this seat.");
        }
        else if (singleSeatNumberAvailability[i] == 1) {
            System.out.println("Desired seat is already taken, you can choose following seats for the bus.");
            for (i = 1; i < 31; i++) {
                while (singleSeatNumber[i] != 1) {
                    System.out.printf("%d \n", i);
                }
            }
        }
        return false;
    }

    //Generates ticket number, for the ticket number to be unique, every ticket number is given incrementally
    public int generateTicketNumber() {
        System.out.print("Your ticket number is ");
        ticketNumber++;
        return ticketNumber;
    }

    
    //Sets current city, used mainly for pricing purposes.
    public void setCurrentCity(String current) {
        if (current == "izmir" || current == "istanbul" || current == "ankara") {
            System.out.printf("Your current city is %s \n", current);
            currentCity = current;
        } else {
            System.out.println("We only have service amongst izmir, istanbul and ankara, please choose accordingly.");
        }
    }

    public String getCurrentCity() {
        return currentCity;
    }

    //Sets current city, used mainly for pricing purposes
    public void setDestinationCity(String destination) {
        if (destination == "izmir" || destination == "istanbul" || destination == "ankara") {
            System.out.printf("Your destination city is %s \n", destination);
            destinationCity = destination;
        } else {
            System.out.println("We only have service amongst izmir, istanbul and ankara, please choose accordingly.");
        }
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    //Choosing bus type, related to pricing and seating
    public String busType(String bus) {
        if (bus.equals("single")) {
            busType = bus;
        } else if (bus.equals("regular")) {
            busType = bus;
        } else System.out.println("Invalid input.");
        System.out.println("You choose ");
        return bus;
    }

    //Prints a unique ticket
    private static void printTicket(int seat, String busType, String currentCity, String destinationCity, int currentTicketPrice) {
        System.out.print("\nTicket INFO:  " + busType + " from " + currentCity + " to " + destinationCity + " Seat #" + seat + " Cost: " + currentTicketPrice + "\n\n");
    }

    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);

        int choice = 0;
        boolean system = true;
        int currentTicketPrice;
        String currentCity = " ";
        String destinationCity = " ";
        String busType = " ";
        String x = " ";

        Scanner scanner = new Scanner(System.in);
        ItemCreator itemCreator = new ItemCreator();
        boolean opening = true;

        while (opening) {
            System.out.println("1.\tLogin");
            System.out.println("2.\tRegister");
            System.out.println("3.\tExit");
            int openingInput = scanner.nextInt();

            switch (openingInput) {
                // User will try to login with their username
                case 1:
                    System.out.println("Username:");
                    String username = scanner.next();
                    User user = new User();
                    user.setUsername(username);
                    if (itemCreator.isUserExist(user)) {
                        boolean login = true;
                        while (login) {
                            System.out.println("1. \tBuy Ticket(s)");
                            System.out.println("2. \tLogout");

                            int loginInput = scanner.nextInt();
        
        if(loginInput == 2) {
        	system = false ;
        	}
        
        
        do  {
            System.out.println("Please enter your current city.");
            currentCity = input.next();
            System.out.println("Please enter the your city that would like to travel");
            destinationCity = input.next();

            if ((currentCity.equals("izmir")) && (destinationCity.equals("istanbul"))) {
                System.out.println("Please enter the type of your bus for your travel  ");
                System.out.println("Enter 1  for Single Seated bus\t  \t ");
                System.out.println("Enter 2  for Regular bus\t     ");
                System.out.println("Enter 3  to Exit from System   :");
                choice = input.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("Please enter the your seat number between 1 and 30 ");
                        int i = input.nextInt();
                        currentTicketPrice = singleSeatPriceIzmirToIstanbul;
                        busType = "Single";

                        if (i > 0 && i < 31) {
                            checkSingleSeatNumber(i);
                            printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);
                        }
                        else System.out.println("Invalid value");
                        
                        
                    case 2:
                        System.out.println("Please enter the your seat number between 1 and 40 ");
                        i = input.nextInt();
                        currentTicketPrice = regularPriceIzmirToIstanbul;
                        busType = "Regular";
                        if (i > 0 && i < 41) {
                            if (checkRegularSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);

                            }
                        } else {
                            System.out.println("invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 3:
                        system = false;
                        break;
                    default:
                        System.out.println("You have entered incorrect value.Please enter only a 1, 2, or 3.");
                }
            }

            if ((currentCity.equals("istanbul")) && (destinationCity.equals("izmir"))) {
                System.out.println("Please enter the type of your bus for your travel  ");
                System.out.println("Enter 1  for Single Seated bus\t  \t ");
                System.out.println("Enter 2  for Regular bus\t     ");
                System.out.println("Enter 3  to Exit from System   :");
                choice = input.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("Please enter the your seat number between 1 and 30 ");
                        int i = input.nextInt();
                        currentTicketPrice = singleSeatPriceIzmirToIstanbul;
                        busType = "Single";

                        if (i > 0 && i < 31) {
                            if (checkSingleSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);
                            }
                        } else {
                            System.out.println("Invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the your seat number between 1 and 40 ");
                        i = input.nextInt();
                        currentTicketPrice = regularPriceIzmirToIstanbul;
                        busType = "Regular";
                        if (i > 0 && i < 41) {
                            if (checkRegularSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);

                            }
                        } else {
                            System.out.println("invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 3:
                        system = false;
                        break;
                    default:
                        System.out.println("You have entered incorrect value.Please enter only a 1, 2, or 3.");
                }
            }

            if ((currentCity.equals("izmir")) && (destinationCity.equals("ankara"))) {
                System.out.println("Please enter the type of your bus for your travel  ");
                System.out.println("Enter 1  for Single Seated bus\t  \t ");
                System.out.println("Enter 2  for Regular bus\t     ");
                System.out.println("Enter 3  to Exit from System   :");
                choice = input.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("Please enter the your seat number between 1 and 30 ");
                        int i = input.nextInt();
                        currentTicketPrice = singleSeatPriceIzmirToAnkara;
                        busType = "Single";

                        if (i > 0 && i < 31) {
                            if (checkSingleSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);
                            }
                        } else {
                            System.out.println("Invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the your seat number between 1 and 40 ");
                        i = input.nextInt();
                        currentTicketPrice = regularPriceIzmirToAnkara;
                        busType = "Regular";
                        if (i > 0 && i < 41) {
                            if (checkRegularSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);

                            }
                        } else {
                            System.out.println("invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 3:
                        system = false;
                        break;
                    default:
                        System.out.println("You have entered incorrect value.Please enter only a 1, 2, or 3.");
                }
            }
            if ((currentCity.equals("ankara")) && (destinationCity.equals("izmir"))) {
                System.out.println("Please enter the type of your bus for your travel  ");
                System.out.println("Enter 1  for Single Seated bus\t  \t ");
                System.out.println("Enter 2  for Regular bus\t     ");
                System.out.println("Enter 3  to Exit from System   :");
                choice = input.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("Please enter the your seat number between 1 and 30 ");
                        int i = input.nextInt();
                        currentTicketPrice = singleSeatPriceIzmirToAnkara;
                        busType = "Single";

                        if (i > 0 && i < 31) {
                            if (checkSingleSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);
                            }
                        } else {
                            System.out.println("Invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the your seat number between 1 and 40 ");
                        i = input.nextInt();
                        currentTicketPrice = regularPriceIzmirToAnkara;
                        busType = "Regular";
                        if (i > 0 && i < 41) {
                            if (checkRegularSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);

                            }
                        } else {
                            System.out.println("invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 3:
                        system = false;
                        break;
                    default:
                        System.out.println("You have entered incorrect value.Please enter only a 1, 2, or 3.");
                }
            }
            if ((currentCity.equals("istanbul")) && (destinationCity.equals("ankara"))) {
                System.out.println("Please enter the type of your bus for your travel  ");
                System.out.println("Enter 1  for Single Seated bus\t  \t ");
                System.out.println("Enter 2  for Regular bus\t     ");
                System.out.println("Enter 3  to Exit from System   :");
                choice = input.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("Please enter the your seat number between 1 and 30 ");
                        int i = input.nextInt();
                        currentTicketPrice = singleSeatPriceAnkaraToIstanbul;
                        busType = "Single";

                        if (i > 0 && i < 31) {
                            if (checkSingleSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);
                            }
                        } else {
                            System.out.println("Invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the your seat number between 1 and 40 ");
                        i = input.nextInt();
                        currentTicketPrice = regularPriceAnkaraToIstanbul;
                        busType = "Regular";
                        if (i > 0 && i < 41) {
                            if (checkRegularSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);

                            }
                        } else {
                            System.out.println("invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 3:
                        system = false;
                        break;
                    default:
                        System.out.println("You have entered incorrect value.Please enter only a 1, 2, or 3.");
                }
            }
            if ((currentCity.equals("ankara")) && (destinationCity.equals("istanbul"))) {
                System.out.println("Please enter the type of your bus for your travel  ");
                System.out.println("Enter 1  for Single Seated bus\t  \t ");
                System.out.println("Enter 2  for Regular bus\t     ");
                System.out.println("Enter 3  to Exit from System   :");
                choice = input.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("Please enter the your seat number between 1 and 30 ");
                        int i = input.nextInt();
                        currentTicketPrice = singleSeatPriceAnkaraToIstanbul;
                        busType = "Single";

                        if (i > 0 && i < 31) {
                            if (checkSingleSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);
                            }
                        } else {
                            System.out.println("Invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the your seat number between 1 and 40 ");
                        i = input.nextInt();
                        currentTicketPrice = regularPriceAnkaraToIstanbul;
                        busType = "Regular";
                        if (i > 0 && i < 41) {
                            if (checkRegularSeatNumber(i)) {
                                printTicket(i, busType, currentCity, destinationCity, currentTicketPrice);

                            }
                        } else {
                            System.out.println("invalid value");
                        }
                        System.out.println("Would you like to purchase another ticket? Y/N");
                        
                        x = input.next();
                        if (x == "y" || x == "Y") {
                        	system = true;
                        }
                        else {
                        	system = false;
                        }
                        break;
                    case 3:
                        system = false;
                        break;
                    default:
                        System.out.println("You have entered incorrect value.Please enter only a 1, 2, or 3.");
                }
            }
        }
        while (system == true);
    input.close();
    }

                    }
                    //if user not found:
             else {
                System.out.println("User not found! Please register!");
            }

            break;
        // User will try to register with their 'unique' username
        case 2:
            System.out.println("Name of the passenger");
            String name = scanner.next();
            itemCreator.createUser(name);

            break;
        // User will list tickets
        case 3:
            System.out.println("See you");
            opening = false;

            break;
    }
        
        }
    }
}



