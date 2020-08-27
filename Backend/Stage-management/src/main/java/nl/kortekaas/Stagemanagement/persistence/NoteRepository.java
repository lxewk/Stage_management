package nl.kortekaas.Stagemanagement.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteRepository, Long> {
}
