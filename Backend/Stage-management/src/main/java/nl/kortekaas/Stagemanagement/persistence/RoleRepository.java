package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.domain.Account;
import nl.kortekaas.Stagemanagement.domain.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleRepository, Long> {

    Optional<Account> findByRole(ERole role);
}
