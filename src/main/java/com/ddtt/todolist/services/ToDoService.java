package com.ddtt.todolist.services;

import java.util.List;

import com.ddtt.todolist.dto.ToDoResponse;
import com.ddtt.todolist.dto.ToDoRequest;

public interface ToDoService {
    ToDoResponse createTodo(ToDoRequest todoRequest);
    List<ToDoResponse> getAllTodos();
    ToDoResponse getTodoById(Long id);
    ToDoResponse updateTodo(Long id, ToDoRequest todoRequest);
    void deleteTodo(Long id);
    List<ToDoResponse> getTodosByCompletionStatus(boolean completed);
    List<ToDoResponse> searchTodosByTitle(String keyword);
    ToDoResponse markTodoAsCompleted(Long id);
}

