package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.persistence.AccountRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public User addUserToAccount(Long id, Account tempAccount) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User userFromDb = userOptional.get();

            if (tempAccount.getAccountUser() == null || tempAccount.getAccountUser().getId() != id) {
                tempAccount.setAccountUser(userFromDb);
            }

            return userRepository.save(userFromDb);
        }
        throw new RuntimeException(String.valueOf(id));
    }

}
