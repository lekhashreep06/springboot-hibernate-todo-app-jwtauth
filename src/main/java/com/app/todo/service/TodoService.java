package com.app.todo.service;

import com.app.todo.entity.Todo;
import com.app.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> saveTodos(List<Todo> todos) {
        return todoRepository.saveAll(todos);
    }

    public List<Todo> getTodos(Boolean isCompleted) {
        if(isCompleted != null)
            return todoRepository.findByIsCompleted(isCompleted);
        else
            return todoRepository.findAll();
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> getTodoByTask(String task) {
        return todoRepository.findByTask(task);
    }

    public Todo updateTodo(int id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        existingTodo.setIsCompleted(todo.getIsCompleted());
        existingTodo.setTask(todo.getTask());
        return todoRepository.save(existingTodo);
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }
}
