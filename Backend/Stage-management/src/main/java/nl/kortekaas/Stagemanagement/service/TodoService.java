package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Todo;
import nl.kortekaas.Stagemanagement.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {

    private TodoRepository todoRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private NoteRepository noteRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Autowired
    public void setTodoRepository(TodoRepository todoRepository) { this.todoRepository = todoRepository; }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository) { this.noteRepository = noteRepository; }

    @Bean
    public List<Todo> getTodo() {
        List<Todo> todoList = todoRepository.findAll();
        return todoList;
    }
}
