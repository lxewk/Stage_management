package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.Role;
import nl.kortekaas.Stagemanagement.persistence.AccountRepository;
import nl.kortekaas.Stagemanagement.persistence.RoleRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.text.RandomStringGenerator;

import javax.security.auth.login.AccountNotFoundException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Random;


@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Account addAccount(Account tempAccount) {
        Role userRole = tempAccount.getRole();
        String userName = tempAccount.getNameNewUser();

        Account newAccount = new Account(userRole, userName);

        return accountRepository.save(newAccount);
    }


    public String generateRandomSpecialCharacters(int length) {
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(33, 45)
                .build();
        return pwdGenerator.generate(length);
    }


    public String generateRandomNumbers(int length) {
        RandomStringGenerator nmbGenerator = new RandomStringGenerator().Builder().withinRange(48, 57)
                .build();
        return nmbGenerator.generate(length);
    }


    public String generateRandomAlphabet(int length, boolean lowCase) {

        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);

        RandomStringGenerator alpGenerator = new RandomStringGenerator().Builder().withinRange(65, 122)
                .build();
        // TODO

        return alpGenerator.generate(length);
    }


    public String generateRandomCharacters(int length) {
        RandomStringGenerator charGenerator = new RandomStringGenerator().Builder().withinRange(33,45)
                .build();
        return charGenerator.generate(length);
    }

    public String generateCommonTextPassword() {
        String pwString = generateRandomSpecialCharacters(2).concat(generateRandomNumbers(2))
                .concat(generateRandomAlphabet(2, true))
                .concat(generateRandomAlphabet(2, false))
                .concat(generateRandomCharacters(2));
        List<Character> pwChars = pwString.chars()
                .mapToObj(data -> (char) data)
                .collect(Collectors.toList());
        Collections.shuffle(pwChars);
        String password = pwChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }

}
