package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountRepository, Long> {

}
