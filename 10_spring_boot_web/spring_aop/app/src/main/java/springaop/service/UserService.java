package springaop.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class User {
        private String name;
        private int age;
        private String address;
    }

    private User user;

    public UserService() {
        user = new User("sameer", 32, "India");
    }

    public void login() {
        System.out.println("Logging User In");
    }

    public void logOut() {
        System.out.println("Logging User Out");
    }
}
