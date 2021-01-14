package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/appusers")
    public AppUser getAppUser() {
        List<AppUser> appUsers = userService.getAppUsers();
        AppUser appUser = appUsers.get(0);
        return appUser;
    }

    @GetMapping("/appusers/{userId}")
    public AppUser getAppUser(@PathVariable Long userId) {
        return userService.getAppUser(userId);
    }

}
