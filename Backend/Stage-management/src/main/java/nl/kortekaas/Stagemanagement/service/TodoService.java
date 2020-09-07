package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Todo;
import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {

    private static final String TODO_NOT_FOUND_ERROR = "Error: TODO is not found.";

    private TodoRepository todoRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;

    @Autowired
    public void setTodoRepository(TodoRepository todoRepository) { this.todoRepository = todoRepository; }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @PreAuthorize("hasRole('STAGEMANAGER') or hasRole('DEPUTY') or hasRole('ASSISTANT') or hasRole('PROPS') or hasRole('CREW')")
    @Override
    public List<Todo> getTodos() {
        List<Todo> todoList = todoRepository.findAll();
        return todoList;
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(
                () -> new RuntimeException(TODO_NOT_FOUND_ERROR));
    }

    @Override
    public Todo saveTodo(Todo newTodo) {
        return todoRepository.save(newTodo);
    }

    @Override
    public String deleteTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.deleteById(id);
            return "TODO with id " + todo.get().getId() + " is deleted.";
        }
        throw new RuntimeException(TODO_NOT_FOUND_ERROR);
    }

//    @Override
//    public Todo addTodoToUser(Long id, Todo newTodo) {
//        UserRepository userRepository = null;
//        Optional<User> _user =
//                userRepository.findById(id);
//
//
//
//        if(_user.isPresent()) {
//            newTodo.setUsers(user.get());
//            return todoRepository.save(newTodo);
//        }
//        return null;
//    }
}
