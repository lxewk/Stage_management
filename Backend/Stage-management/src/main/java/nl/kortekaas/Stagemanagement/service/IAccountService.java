package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.User;

public interface IAccountService {

    User addAccountToUser(Account tempAccount);
}
