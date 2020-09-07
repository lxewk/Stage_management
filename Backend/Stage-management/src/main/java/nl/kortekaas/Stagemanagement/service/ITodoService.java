package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Todo;

import java.util.List;

public interface ITodoService {

    List<Todo> getTodos();
    Todo getTodoById(Long id);
    Todo saveTodo(Todo newTodo);
    String deleteTodo(Long id);

}
