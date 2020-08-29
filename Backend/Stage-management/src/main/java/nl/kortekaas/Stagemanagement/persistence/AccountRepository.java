package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountRepository, User> {
}
