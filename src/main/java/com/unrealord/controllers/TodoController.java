package com.unrealord.controllers;

import com.unrealord.models.Todo;
import com.unrealord.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        todo.setUuid(UUID.randomUUID().toString());
        Todo createdTodo = todoRepository.save(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todos/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<Todo> getTodo(@PathVariable("uuid") String uuid) {
        Todo todo = todoRepository.findByUuid(uuid);
        if(todo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

}
