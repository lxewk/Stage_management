package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
