package com.todoapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false,unique = true)
    private String id;
    @Column(nullable = false)
    private String task;
    @Column(nullable = false)
    private Boolean isCompleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // Empty Constructor
    public Todo() {}

    // Constructor for creating data
    public Todo(String id, String task, Boolean isCompleted) {
        this.id = id;
        this.task = task;
        this.isCompleted = isCompleted;
    }

    // // Manual Getters - These are the "keys" Jackson uses to make JSON
    // public String getId() { return id; }
    // public String getTask() { return task; }
    public Boolean isIsCompleted() { return isCompleted; }

    // Manual Setters
    public void setTask(String task) { this.task = task; }
    public void setIsCompleted(Boolean isCompleted) { this.isCompleted = isCompleted; }
}