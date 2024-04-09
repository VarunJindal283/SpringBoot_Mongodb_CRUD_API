package com.example.todoList.todoList_api.service;

import com.example.todoList.todoList_api.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CrudService {

    List<Task> tasks = new ArrayList<>(Arrays.asList(
            new Task(1, "Make APIs", "APIs for TodoList", false),
            new Task(2, "Task creation date", "Show task creation date and also add comments section", false)
    ));

    public List<Task> getAllTasks(){
        return tasks;
    }
}
