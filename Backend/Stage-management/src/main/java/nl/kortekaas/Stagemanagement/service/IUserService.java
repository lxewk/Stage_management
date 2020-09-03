package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.User;

public interface IUserService {

    User addUserToAccount(Long id, Account tempAccount);
}
