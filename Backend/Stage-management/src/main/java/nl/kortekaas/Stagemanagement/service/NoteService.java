package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Note;
import nl.kortekaas.Stagemanagement.domain.Todo;
import nl.kortekaas.Stagemanagement.persistence.ItemRepository;
import nl.kortekaas.Stagemanagement.persistence.NoteRepository;
import nl.kortekaas.Stagemanagement.persistence.TodoRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService {

    private NoteRepository noteRepository;
    private TodoRepository todoRepository;
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Autowired
    public void setTodoRepository(TodoRepository todoRepository) { this.todoRepository = todoRepository; }

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository) { this.noteRepository = noteRepository; }

    @Bean
    public List<Note> getNote() {
        List<Note> noteList = noteRepository.findAll();
        return noteList;
    }
}
