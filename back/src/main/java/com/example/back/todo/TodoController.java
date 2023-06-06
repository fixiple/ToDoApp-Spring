package com.example.back.todo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//We allow localhost:port to request data from backend
@CrossOrigin(origins = {"http://localhost:8080" })
@RestController
public class TodoController {
    
    @Autowired
    private TodoHardCodedService todoManagementService;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoManagementService.findAll();
    }

}
