package com.ddtt.todolist.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddtt.todolist.dto.ToDoRequest;
import com.ddtt.todolist.dto.ToDoResponse;
import com.ddtt.todolist.services.ToDoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping
    public ToDoResponse createTodo(@Valid @RequestBody ToDoRequest todoRequest) {
        return toDoService.createTodo(todoRequest);
    }

    @GetMapping
    public List<ToDoResponse> getAllTodos() {
        return toDoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ToDoResponse getTodoById(@PathVariable Long id) {
        return toDoService.getTodoById(id);
    }

    @PatchMapping("/{id}")
    public ToDoResponse updateTodo(@PathVariable Long id, @Valid @RequestBody ToDoRequest todoRequest) {
        return toDoService.updateTodo(id, todoRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        toDoService.deleteTodo(id);
    }
    @GetMapping("/completed")
    public List<ToDoResponse> getTodosByCompletionStatus(@RequestParam boolean completed) {
        return toDoService.getTodosByCompletionStatus(completed);
    }
    
    @GetMapping("/search")
    public List<ToDoResponse> searchTodosByTitle(@RequestParam String keyword) {
        return toDoService.searchTodosByTitle(keyword);
    }

    @PostMapping("/{id}/complete")
    public ToDoResponse toggleTodoCompletionStatus(@PathVariable Long id) {
        return toDoService.toggleTodoCompletionStatus(id);
    }
}
