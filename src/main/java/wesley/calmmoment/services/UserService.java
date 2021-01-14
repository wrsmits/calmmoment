package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<AppUser> getAppUsers() {
        return userRepository.findAll();
    }

    public AppUser getAppUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
