package nl.kortekaas.Stagemanagement.controller;


import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Lisette Tates");
        userRepository.save(user);
    }
}
