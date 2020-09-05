package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.ERole;
import nl.kortekaas.Stagemanagement.domain.Role;
import nl.kortekaas.Stagemanagement.payload.request.AccountRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import nl.kortekaas.Stagemanagement.persistence.AccountRepository;
import nl.kortekaas.Stagemanagement.persistence.RoleRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.*;


@Service
public class AccountService implements IAccountService {

    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";

    private AccountRepository accountRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) { this.accountRepository = accountRepository; }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) { this.roleRepository = roleRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<Account> getAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList;
    }


    public ResponseEntity<MessageResponse> addRoleToAccount(@Valid AccountRequest accountRequest) {

        Account account = new Account(accountRequest.getUsername(),
                accountRequest.getRoleName());

        Set<String> strRoles = accountRequest.getRoleName();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "stagemanager":
                    Role stagemanagerRole = roleRepository.findByName(ERole.STAGEMANAGER)
                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                    roles.add(stagemanagerRole);

                    break;
                case "deputy":
                    Role deputyRole = roleRepository.findByName(ERole.DEPUTY)
                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                    roles.add(deputyRole);

                    break;
                case "assistant":
                    Role assistantRole = roleRepository.findByName(ERole.ASSISTANT)
                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                    roles.add(assistantRole);

                    break;
                case "crew":
                    Role crewRole = roleRepository.findByName(ERole.CREW)
                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                    roles.add(crewRole);

                    break;
                case "props":
                    Role propsRole = roleRepository.findByName(ERole.PROPS)
                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                    roles.add(propsRole);

                    break;
                case "creative":
                    Role creativeRole = roleRepository.findByName(ERole.CREATIVE)
                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                    roles.add(creativeRole);

                    break;
                case "production":
                    Role productionRole = roleRepository.findByName(ERole.PRODUCTION)
                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                    roles.add(productionRole);
            }
        });

        account.setRoles(roles);
        accountRepository.save(account);

        return ResponseEntity.ok(new MessageResponse("Account is created"));

    }


//    public String generateRandomSpecialCharacters(int length) {
//        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(33, 45)
//                .build();
//        return pwdGenerator.generate(length);
//    }
//
//
//    public String generateRandomNumbers(int length) {
//        RandomStringGenerator nmbGenerator = new RandomStringGenerator().Builder().withinRange(48, 57)
//                .build();
//        return nmbGenerator.generate(length);
//    }
//
//
//    public String generateRandomAlphabet(int length, boolean lowCase) {
//
//        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
//        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
//
//        RandomStringGenerator alpGenerator = new RandomStringGenerator().Builder().withinRange(65, 122)
//                .build();
//        // TODO
//
//        return alpGenerator.generate(length);
//    }
//
//
//    public String generateRandomCharacters(int length) {
//        RandomStringGenerator charGenerator = new RandomStringGenerator().Builder().withinRange(33,45)
//                .build();
//        return charGenerator.generate(length);
//    }
//
//    public String generateCommonTextPassword() {
//        String pwString = generateRandomSpecialCharacters(2).concat(generateRandomNumbers(2))
//                .concat(generateRandomAlphabet(2, true))
//                .concat(generateRandomAlphabet(2, false))
//                .concat(generateRandomCharacters(2));
//        List<Character> pwChars = pwString.chars()
//                .mapToObj(data -> (char) data)
//                .collect(Collectors.toList());
//        Collections.shuffle(pwChars);
//        String password = pwChars.stream()
//                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//                .toString();
//        return password;
//    }

}
