package ticket.booking;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.services.TrainService;
import ticket.booking.services.UserBookingService;
import ticket.booking.utils.UserServiceUtils;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Train trainSelectedForBooking = new Train();

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
                    trainSelectedForBooking = trains.get(scanner.nextInt());
                    break;

                case 5:
                    if (trainSelectedForBooking == null) {
                        System.out.println("Please select a train first in option 4!");
                        break;
                    }
                    List<List<Integer>> seats = TrainService.getSeats(trainSelectedForBooking);
                    System.out.println("Select a seat out of these seats");
                    for (int r = 0; r < seats.size(); r++) {
                        System.out.print(r + "  ");
                        for (Integer val : seats.get(r)) {
                            System.out.print(val + " ");
                        }
                        System.out.println();
                    }

                    System.out.println("Select the seat by typing the row and column");

                    System.out.println("Enter the row");
                    int row = scanner.nextInt();

                    System.out.println("Enter the column");
                    int col = scanner.nextInt();

                    System.out.println("Booking your seat....");
                    Boolean booked = userBookingService.bookTrainSeat(trainSelectedForBooking, row, col);

                    if (booked.equals(Boolean.TRUE)) {
                        System.out.println("Booked! Enjoy your journey");
                    } else {
                        System.out.println("Can't book this seat");
                    }
                    break;

                case 6:
                    System.out.println("Enter the Ticket Id:");
                    String ticketId = scanner.next();
                    if (ticketId.isEmpty()) {
                        System.out.println("Ticket Id Is Required");
                        return;
                    }
                    userBookingService.cancelBooking(ticketId);
                    break;

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
