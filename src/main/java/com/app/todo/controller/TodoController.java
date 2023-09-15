package com.app.todo.controller;

import com.app.todo.entity.Todo;
import com.app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping(value = "/todos", consumes = "application/json", produces = "application/json")
    public List<Todo> saveTodos(@RequestBody ArrayList<Todo> todoList) {
        return todoService.saveTodos(todoList);
    }

    @PostMapping(value = "/todo", consumes = "application/json", produces = "application/json")
    public Todo saveTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(@RequestParam(value = "isCompleted", required = false) Boolean isCompleted) {
        return todoService.getTodos(isCompleted);
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    @GetMapping("/todo")
    public List<Todo> getTodoByTask(@RequestParam(value="task", required = true) String task) {
        return todoService.getTodoByTask(task);
    }

    @PatchMapping(path = "/todo/{id}", consumes = "application/json")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("todo/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }

}
