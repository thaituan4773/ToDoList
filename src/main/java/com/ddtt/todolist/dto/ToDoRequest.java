package com.ddtt.todolist.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class ToDoRequest {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;
}
