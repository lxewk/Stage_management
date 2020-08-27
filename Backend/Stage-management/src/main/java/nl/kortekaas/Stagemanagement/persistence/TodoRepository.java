package nl.kortekaas.Stagemanagement.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoRepository, Long> {
}
