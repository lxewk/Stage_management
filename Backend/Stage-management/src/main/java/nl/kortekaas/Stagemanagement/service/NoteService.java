package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Note;
import nl.kortekaas.Stagemanagement.domain.Todo;
import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.persistence.ItemRepository;
import nl.kortekaas.Stagemanagement.persistence.NoteRepository;
import nl.kortekaas.Stagemanagement.persistence.TodoRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements INoteService {

    private static final String NOTE_NOT_FOUND_ERROR = "Error: Note is not found.";

    private NoteRepository noteRepository;;
    private UserRepository userRepository;

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository) { this.noteRepository = noteRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @PreAuthorize("hasRole('STAGEMANAGER') or hasRole('DEPUTY') or hasRole('ASSISTANT')")
    @Override
    public List<Note> getNotes() {
        List<Note> noteList = noteRepository.findAll();
        return noteList;
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(
                () -> new RuntimeException(NOTE_NOT_FOUND_ERROR));
    }

    @Override
    public Note saveNote(Note newNote) {
        return noteRepository.save(newNote);
    }

    @Override
    public String deleteNote(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            noteRepository.deleteById(id);
            return "Note with id " + note.get().getId() + " is deleted.";
        }
        throw new RuntimeException(NOTE_NOT_FOUND_ERROR);
    }

    @Override
    public Note addNoteToUser(Long id, Note newNote) {
        UserRepository userRepository = null;

        Optional<User> user =
                userRepository.findById(id);
        if(user.isPresent()) {
            newNote.setReceiver(user.get());
            return noteRepository.save(newNote);
        }
        return null;
    }
}
