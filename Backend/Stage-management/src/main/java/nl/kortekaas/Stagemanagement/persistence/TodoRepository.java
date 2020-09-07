package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
