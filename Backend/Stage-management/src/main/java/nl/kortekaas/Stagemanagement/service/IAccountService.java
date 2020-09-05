package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.payload.request.AccountRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public interface IAccountService {

    List<Account> getAccounts();
    ResponseEntity<MessageResponse> addRoleToAccount(@Valid AccountRequest accountRequest);
}
