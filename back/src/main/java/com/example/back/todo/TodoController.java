package com.example.back.todo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//We allow front to request data from backend
@CrossOrigin(origins = {"http://localhost:8080" })
@RestController
public class TodoController {
    
    @Autowired
    private TodoHardCodedService todoManagementService;

    @Autowired
    private TodoRepository todoRepo;

    @GetMapping("/list")
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @PostMapping("/add")
    public String getOneTodo(@RequestBody Todo todo) {
        todoRepo.save(todo);
        return "Added a new entry "+todo.getId()+" with title: "+todo.getTitle();
    }

    @PutMapping("/edit")
    public String editOneTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todoRepo.save(todo);
        return "Modified a new entry "+todo.getId()+" with title: "+todo.getTitle();
    }

}
