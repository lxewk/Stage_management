package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Role;
import nl.kortekaas.Stagemanagement.persistence.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;


    @PreAuthorize("hasRole('DEPUTY') or hasRole('STAGEMANAGER')")
    public List<Role> getRoles() {
        List<Role> roleList = roleRepository.findAll();
        return roleList;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

}




