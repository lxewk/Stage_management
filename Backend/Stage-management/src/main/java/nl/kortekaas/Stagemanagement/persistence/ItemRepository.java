package nl.kortekaas.Stagemanagement.persistence;


import nl.kortekaas.Stagemanagement.model.enums.EDepartment;
import nl.kortekaas.Stagemanagement.model.Item;
import nl.kortekaas.Stagemanagement.model.enums.EPreset;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByDepartment(EDepartment department);
    Optional<Item> findByPreset(EPreset preset);
}
