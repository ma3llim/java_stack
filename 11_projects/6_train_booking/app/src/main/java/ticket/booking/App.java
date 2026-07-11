package ticket.booking;

import ticket.booking.entities.User;
import ticket.booking.services.UserBookingService;
import ticket.booking.utils.UserServiceUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

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

                case 3:
                    userBookingService.fetchBooking();
            }
        }
    }
}
