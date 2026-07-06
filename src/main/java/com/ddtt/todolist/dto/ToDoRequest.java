package com.ddtt.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ToDoRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
}
