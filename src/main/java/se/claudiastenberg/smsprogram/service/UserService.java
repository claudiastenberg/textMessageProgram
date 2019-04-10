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
    final String AUTH_TOKEN =

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
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                        "Din patient " + optionalUser.get().getFirstName() + " har kommit för att få hjälp med: " +
                                optionalUser.get().getAppoinment().iterator().next().getCause())
                .create();
            return optionalUser.get();
        }
        throw new NotFoundException();
    }

    public Iterable<User> getAllUsers(){

        return repository.findAll();
    }

    public User bookAppoinment(Long personalID, User user){
        User foundUser = repository.findById(personalID).get();
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setPersonald(user.getPersonald());
        return repository.save(foundUser);
    }
}
