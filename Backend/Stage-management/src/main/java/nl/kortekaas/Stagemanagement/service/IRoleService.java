package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Role;

import javax.management.relation.RoleNotFoundException;

public interface IRoleService {

    Role getRoleById(Long id);

}
