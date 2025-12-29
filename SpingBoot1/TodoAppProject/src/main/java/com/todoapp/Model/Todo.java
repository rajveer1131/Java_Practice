package com.todoapp.Model;

public class Todo {
    private String id;
    private String task;
    private boolean isCompleted;

    Todo(String id,String task,boolean isCompleted){
        this.id=id;
        this.task=task;
        this.isCompleted=isCompleted;
    }

    public  String getId(){
        return id;
    }
    public String getTask(){
        return task;
    }
    public boolean getIsCompleted(){
        return isCompleted;
    }
}
