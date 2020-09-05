package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IUserService {

    List<User> getUsers();
    User addUserToAccount(Long id, Account tempAccount);
}
