package com.unrealord.controllers;

import com.unrealord.models.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @RequestMapping("/todos/{uuid}")
    public ResponseEntity<Todo> getTodo(@PathVariable("uuid") String uuid) {
        Todo todo = Todo.builder().uuid(uuid).build();
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

}
