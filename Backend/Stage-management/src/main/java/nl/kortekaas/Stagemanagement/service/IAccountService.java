package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.User;

import java.util.List;

public interface IAccountService {

    List<Account> getAccounts();
    Account addRoleToAccount(Account tempAccount);
}
