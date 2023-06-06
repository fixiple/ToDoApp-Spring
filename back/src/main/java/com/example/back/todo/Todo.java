package com.example.back.todo;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Timestamp created_at; 
    private boolean finished;

    private static Long counter = 0L;


    public Timestamp currentTime(){

        Timestamp time = new Timestamp(System.currentTimeMillis());

        // SimpleDateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //String current = currentTime.format(time);

        return time;
    }


    public Todo() {
        this.id=counter+=1L;
    }

    public Todo(String title, String description, boolean finished) {
        //increment id to 1 each time a new Todo is created
        this.id=counter+=1L; 
        this.title = title;
        this.description = description;
        this.created_at = currentTime();
        this.finished = finished;
    }
    


    public Long getId() {
        return this.id;
    }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated_at() {
        return this.created_at;
    }


    public boolean isFinished() {
        return this.finished;
    }

    public boolean getFinished() {
        return this.finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}

  
