package com.example.back.todo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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


    @GetMapping("/{id}/edit")
    public Todo editOneTodo(@PathVariable Long id) {
        //we find the TodoItem by id, and if we dont find something, we return a message to the user....
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo ID:"+id));
        System.out.println("Checked todo number: "+ todo.getId());
        return todo;
    }

    @PutMapping("/{id}/edit")
    public String editOneTodo(@PathVariable Long id, @RequestBody Todo todo) {
        //we find the TodoItem by id, and if we dont find something, we return a message to the user....
        Todo todo2 = todoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Todo ID:"+id));
        

        todo2.setTitle(todo.getTitle());
        todo2.setDescription(todo.getDescription());
        todo2.setFinished(todo.getFinished());
        todoRepo.save(todo2);
        return "Modified a new entry "+todo2.getId()+" with title: "+todo2.getTitle();
    }

    @DeleteMapping("/{id}/delete")
    public String deleteOneTodo(@PathVariable Long id) {
        //we find the TodoItem by id, and if we dont find something, we return a message to the user....
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid TODO ID:"+id));
        Long id2 = todo.getId();
        String title = todo.getTitle();

        System.out.println("Deleted todo number: "+ todo.getId());
        todoRepo.delete(todo);
        return "Deleted Todo number: "+id2+" with title: "+title;
    }



}
