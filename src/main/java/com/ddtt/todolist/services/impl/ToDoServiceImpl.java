package com.ddtt.todolist.services.impl;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ddtt.todolist.dto.ToDoRequest;
import com.ddtt.todolist.dto.ToDoResponse;
import com.ddtt.todolist.exceptions.ResourceNotFoundException;
import com.ddtt.todolist.model.ToDo;
import com.ddtt.todolist.repositories.ToDoRepository;
import com.ddtt.todolist.services.ToDoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    private ToDoResponse map(ToDo todo) {
        return ToDoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .completed(todo.isCompleted())
                .createdAt(todo.getCreatedAt())
                .build();
    }

    @Override
    public ToDoResponse createTodo(ToDoRequest todoRequest) {
        ToDo todo = ToDo.builder()
                .title(todoRequest.getTitle())
                .description(todoRequest.getDescription())
                .completed(false)
                .createdAt(LocalDateTime.now())
                .build();
        ToDo savedTodo = toDoRepository.save(todo);
        return map(savedTodo);
    }

    @Override
    public List<ToDoResponse> getAllTodos() {
        List<ToDo> todos = toDoRepository.findAll();
        return todos.stream().map(this::map).toList();
    }

    @Override
    public ToDoResponse getTodoById(Long id) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return map(todo);
    }

    @Override
    public ToDoResponse updateTodo(Long id, ToDoRequest todoRequest) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setTitle(todoRequest.getTitle());
        if (todoRequest.getDescription() != null) {
            todo.setDescription(todoRequest.getDescription());
        }
        ToDo updatedTodo = toDoRepository.save(todo);
        return map(updatedTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public List<ToDoResponse> getTodosByCompletionStatus(boolean completed) {
        List<ToDo> todos = toDoRepository.findByCompleted(completed);
        return todos.stream().map(this::map).toList();
    }

    @Override
    public List<ToDoResponse> searchTodosByTitle(String keyword) {
        List<ToDo> todos = toDoRepository.findByTitleContainingIgnoreCase(keyword);
        return todos.stream().map(this::map).toList();
    }

    @Override
    public ToDoResponse toggleTodoCompletionStatus(Long id) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setCompleted(!todo.isCompleted());
        ToDo updatedTodo = toDoRepository.save(todo);
        return map(updatedTodo);
    }

}
