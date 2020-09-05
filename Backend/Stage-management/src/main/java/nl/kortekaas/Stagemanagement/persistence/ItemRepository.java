package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.domain.EDepartment;
import nl.kortekaas.Stagemanagement.domain.EPreset;
import nl.kortekaas.Stagemanagement.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByDepartment(EDepartment department);
    Optional<Item> findByPreset(EPreset preset);
}
