package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.persistence.AccountRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.commons.text.TextRandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) { this.accountRepository = accountRepository; }

    public String generateRandomSpecialCharacters(int length) {
        SecureTextRandomProvider stp = new SecureTextRandomProvider();
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder()
                .withinRange(33, 45)
                .usingRandom(stp)
                .build();
        return pwdGenerator.generate(length);
    }
}
