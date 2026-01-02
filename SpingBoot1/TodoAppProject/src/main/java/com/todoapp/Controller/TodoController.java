package com.todoapp.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.todoapp.Model.Todo;
import com.todoapp.Service.TodoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoService todoService;
    
    @GetMapping("/todos")
    public List<Todo> geTodos(){
        return todoService.getAllTodos();
    }    
    @GetMapping("/todos/{id}")
    public Todo geTodosById(@PathVariable String id){
        return todoService.getSingleTodo(id);
    }    

    @GetMapping("/todos/search")
    public Todo geTodosByName(@RequestParam String search){
        return todoService.getSingleTodoByName(search);
    }    

    @PostMapping("/{userId}/todos")
    public Todo createTodo(@PathVariable String userId,@RequestBody Todo todo){
        return todoService.createTodo(userId,todo);
    }
    
    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable String id){
        return todoService.deleteTodo(id);
    }

    @PutMapping("/{userId}/todos/{id}")
    public String updateTodo(@PathVariable String userId,@PathVariable String id,@RequestBody Todo todo){
       
        return todoService.updateTodo(todo);
    }
    @GetMapping("/{userId}/todos")
        public ResponseEntity<List<Todo>> getAllTodosForUser(@PathVariable String userId){
            return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodosbyUser(userId));
        
    }

}

