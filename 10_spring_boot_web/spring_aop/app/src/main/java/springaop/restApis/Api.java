package springaop.restApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springaop.service.UserService;

@RestController
public class Api {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userLogin() {
        userService.login();
        return "User Login Endpoint Called Successfully";
    }
}
