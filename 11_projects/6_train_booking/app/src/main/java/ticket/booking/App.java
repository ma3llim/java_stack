package ticket.booking;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.services.UserBookingService;
import ticket.booking.utils.UserServiceUtils;

import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Running Train Booking System");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService;

        try {
            userBookingService = new UserBookingService();
        } catch (IOException ex) {
            System.out.println("There is something wrong: " + ex.getMessage());
            return;
        }

        while (option != 7) {
            System.out.println("Choose Option");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Bookings");
            System.out.println("4. Search Trains");
            System.out.println("5. Book a Seat");
            System.out.println("6. Cancel My Booking");
            System.out.println("7. Exit the App");

            option = scanner.nextInt();
            Train trainSelectedForBooking = new Train();

            switch (option) {
                case 1:
                    System.out.println("Enter the username to signup");
                    String nameSignUp = scanner.next();
                    System.out.println("Enter the password to signup");
                    String passwordSignUp = scanner.next();
                    User signUpUser = new User(
                            nameSignUp, passwordSignUp, UserServiceUtils.hashPassword(passwordSignUp), new ArrayList<>(), UUID.randomUUID().toString()
                    );
                    userBookingService.signUp(signUpUser);
                    break;


                case 2:
                    System.out.println("Enter the username to Login");
                    String nameLogin = scanner.next();
                    System.out.println("Enter the password to Login");
                    String passwordLogin = scanner.next();
                    User userToLogin = new User(nameLogin, passwordLogin, UserServiceUtils.hashPassword(passwordLogin), new ArrayList<>(), UUID.randomUUID().toString());
                    try {
                        userBookingService = new UserBookingService(userToLogin);
                        userBookingService.loginUser();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    userBookingService.fetchBooking();
                    break;

                case 4:
                    System.out.println("Type Your Source Station");
                    String source = scanner.next();
                    System.out.println("Type Your Destination Station");
                    String destination = scanner.next();
                    List<Train> trains = userBookingService.getTrains(source, destination);
                    int index = 1;
                    for (Train train : trains) {
                        System.out.println(index + " Train Id: " + train.getTrainId());
                        for (Map.Entry<String, String> entry : train.getStationTimes().entrySet()) {
                            System.out.println("Station " + entry.getKey() + " Time: " + entry.getValue());
                        }
                        index++;
                    }
                    System.out.println("Select a train by typing 1,2,3...");
                    trainSelectedForBooking = trains.get(scanner.nextInt() - 1);
                    break;

//                case 5:
//                case 6:
                case 7:
                    System.out.println("Thank you! Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
