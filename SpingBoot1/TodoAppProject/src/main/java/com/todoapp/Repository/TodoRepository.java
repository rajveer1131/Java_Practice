package com.todoapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.Model.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, String>{

    Todo findByTask(String task);
    Todo findByTaskIgnoreCase(String task);
    List<Todo> findByUser_UserId(String userId);
    
}
