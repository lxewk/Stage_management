package nl.kortekaas.Stagemanagement.service;

import javassist.NotFoundException;
import nl.kortekaas.Stagemanagement.domain.ERole;
import nl.kortekaas.Stagemanagement.domain.Role;
import nl.kortekaas.Stagemanagement.persistence.AccountRepository;
import nl.kortekaas.Stagemanagement.persistence.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfoNotFoundException;
import javax.management.relation.RoleNotFoundException;
import javax.persistence.EntityNotFoundException;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

}




