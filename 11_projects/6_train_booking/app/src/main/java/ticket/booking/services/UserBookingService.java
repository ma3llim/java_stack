package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.utils.UserServiceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserBookingService {
    private User user;
    private List<User> userList;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "app/src/main/resources/localDb/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        this.userList = loadUsers();
    }

    public UserBookingService() throws IOException {
        this.userList = loadUsers();
    }

    public List<User> loadUsers() throws IOException {
        File usersFile = new File(USERS_PATH);

        // If file doesn't exist, create it with empty list
        if (!usersFile.exists()) {
            usersFile.getParentFile().mkdirs();
            usersFile.createNewFile();
            objectMapper.readValue(usersFile, new TypeReference<List<User>>() {
            });
            return new ArrayList<>();
        }
        return objectMapper.readValue(usersFile, new TypeReference<List<User>>() {
        });
    }

    public Boolean loginUser() {
        if (userList == null || userList.isEmpty()) {
            System.out.println("No Users Registered Yet");
            return false;
        }

        Optional<User> foundUser = userList.stream().
                filter(user1 -> (
                        user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtils.checkPassword(user.getPassword(), user1.getHashPassword()))
                ).findFirst();

        if (foundUser.isPresent()) {
            this.user = foundUser.get();
            System.out.println("\n" + "=".repeat(50));
            System.out.println("Welcome back, " + user.getName() + "!");
            System.out.println("=".repeat(50) + "\n");
            return true;
        } else {
            System.out.println("Invalid Username Or Password.");
            return false;
        }
    }

    public Boolean signUp(User user1) {
        try {
            // Initialize userList if null
            if (userList == null) {
                userList = new ArrayList<>();
            }
            boolean userExists = userList.stream().anyMatch(user -> user.getName().equalsIgnoreCase(user1.getName()));
            if (userExists) {
                System.out.println("Username Already Existed");
                return false;
            }
            userList.add(user1);
            saveUserListToFile();
            System.out.println("User registered successfully!");
            return true;
        } catch (IOException ex) {
            System.out.println("Error saving user: " + ex.getMessage());
            return false;
        }
    }

    public void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        usersFile.getParentFile().mkdirs();
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBooking() {
        if (user == null) {
            System.out.println("No user logged in.");
            return;
        }
        user.printTickets();
    }

    public boolean cancelBooking(String ticketId) {
        if (user == null) {
            System.out.println("No user logged in.");
            return false;
        }
        List<Ticket> currentTickets = user.getTicketsBooked();
        int origianlSize = currentTickets.size();

        List<Ticket> updateTickets = currentTickets.stream()
                .filter(ticket -> !ticket.getTicketId().equalsIgnoreCase(ticketId))
                .collect(Collectors.toList());

        // check if any  ticket was actually removed or not
        if (origianlSize == updateTickets.size()) {
            System.out.println("Ticket with ID " + ticketId + " not found.");
            return false;
        }

        user.setTicketsBooked(updateTickets);
        // Update the user in the userList
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserId().equals(user.getUserId())) {
                userList.set(i, user);
                break;
            }
        }

        try {
            saveUserListToFile();
            System.out.println("Booking cancelled successfully!");
            return true;
        } catch (IOException ex) {
            System.out.println("Error saving: " + ex.getMessage());
            return false;
        }
    }

    public List<Train> getTrains(String source, String destination) {
        try {
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
