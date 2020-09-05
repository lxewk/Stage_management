package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.persistence.AccountRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

//    @Override
//    public List<User> getUsers() {
//        List<User> userList = userRepository.findAll();
//        return userList;
//    }

    @Override
    public User addUserToAccount(Long id, Account tempAccount) {
        Optional<User> _user = userRepository.findById(id);

        if (_user.isPresent()) {
            User userFromDb = _user.get();

            if (tempAccount.getAccountUser() == null || tempAccount.getAccountUser().getUserId() != id) {
                tempAccount.setAccountUser(userFromDb);
            }

            return userRepository.save(userFromDb);
        }
        throw new RuntimeException(String.valueOf(id));
    }

}
