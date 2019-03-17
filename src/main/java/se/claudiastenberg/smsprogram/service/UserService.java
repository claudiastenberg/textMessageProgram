package se.claudiastenberg.smsprogram.service;


import com.twilio.Twilio;
import org.springframework.stereotype.Service;
import se.claudiastenberg.smsprogram.model.User;
import se.claudiastenberg.smsprogram.repository.UserRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

@Service
public final  class UserService {

    final String ACCOUNT_SID =
            "ACa9e800edc1e2d4b20b6ac00aba3be72b";
    final String AUTH_TOKEN =
            "5b22e55ae27b548c31261c469807377a";

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User getUsers(int findByPersonald){
        Optional<User> optionalUser = repository.findByPersonald(findByPersonald);

        if (optionalUser.isPresent()){
        // Find your Account Sid and Auth Token at twilio.com/console
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new PhoneNumber("+46769424727"), // to
                        new PhoneNumber("+46769446997"), // from
                        "Din patient " + optionalUser.get().getFirstName() + " har kommit")
                .create();
            return optionalUser.get();
        }
        throw new NotFoundException();
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }
    public Iterable<User> getAllUsers(){
        return repository.findAll();
    }

    public User bookAppoinment(int personalID, User user){
        User foundUser = repository.findByPersonald(personalID).get();
        foundUser.setAppoinment(user.getAppoinment());
        return repository.save(foundUser);
    }
}
