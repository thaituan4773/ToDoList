package com.ddtt.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddtt.todolist.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    List<ToDo> findByCompleted(boolean completed);

    List<ToDo> findByTitleContainingIgnoreCase(String keyword);

}
