package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.payload.request.AccountRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import nl.kortekaas.Stagemanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/acc")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<MessageResponse> makeAccount(@RequestBody AccountRequest accountRequest) {
        return accountService.addRoleToAccount(accountRequest);
    }
}
