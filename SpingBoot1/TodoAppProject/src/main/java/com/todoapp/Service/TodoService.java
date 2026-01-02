package com.todoapp.Service;

import java.util.List;
import java.util.Optional;
import com.todoapp.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.Model.Todo;
import com.todoapp.Model.User;
import com.todoapp.Repository.TodoRepository;

@Service
public class TodoService {


    @Autowired
   UserRepository userRepository;

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAllTodos() {

        return todoRepository.findAll();
    }

    public Todo getSingleTodo(String id) {

        return todoRepository.findById(id).orElse(null);
    }

    public Todo createTodo(String userId, Todo todo) {
        User user = userRepository.findById(userId).orElseThrow();
        todo.setUser(user);
        user.getTodo().add(todo);
        return todoRepository.save(todo);
    }

    public String deleteTodo(String id) {

        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return "Todo with ID " + id + " was deleted successfully.";
        } else {
            return "Error: Todo with ID " + id + " not found.";
        }
    }

    public Todo getSingleTodoByName(String task) {

        return todoRepository.findByTask(task);
    }

    public String updateTodo(Todo todoData) {
        Optional<Todo> todoRes = todoRepository.findById(todoData.getId());

        if (todoRes.isPresent()) {

            Todo existingTodo = todoRes.get();
            if (todoData.getTask() != null) {
                existingTodo.setTask(todoData.getTask());
            }
            if (todoData.isIsCompleted() != null) {
                existingTodo.setIsCompleted(todoData.isIsCompleted());
            }
            todoRepository.save(existingTodo);
            return "Todo Updated";
        } else {

            throw new RuntimeException("Todo not found");
        }
    }

    public List<Todo> getAllTodosbyUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow();

        return user.getTodo();
    }

    

}
