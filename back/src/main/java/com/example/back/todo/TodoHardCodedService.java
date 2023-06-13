package com.example.back.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

// For testing purposes, Hardcoded data...
@Service
public class TodoHardCodedService {
    private static List<Todo> todosList = new ArrayList<>();

    
    static{
        todosList.add(new Todo("Eat Banana", "Eating a banana is healthy", false));
        todosList.add(new Todo("Watch Susume", "Watch Susume before noon", false));
        todosList.add(new Todo("Cutting", "Cutting my Nails", true));
        todosList.add(new Todo("HipHop", "Listen to HipHop", true));
        todosList.add(new Todo("TOTK", "Beating the boss in TOTK", false));
    }

    public List<Todo> findAll() {
      return todosList;
    }

    public void addOne(Todo todo){
        todosList.add(todo);
    }

    public Todo modifyOne(int index, Todo todo){
        Todo todoModify = todosList.get(index);
        todo = todoModify;
    }
}

