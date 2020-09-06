package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.User;


import java.util.List;

public interface IUserService {

    List<User> getUsers();
    User addUserToAccount();
}
