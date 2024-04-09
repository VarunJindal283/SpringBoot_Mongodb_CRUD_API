package com.example.todoList.todoList_api.service;

import com.example.todoList.todoList_api.model.Task;
import com.example.todoList.todoList_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

//    List<Task> tasks = new ArrayList<>(Arrays.asList(
//            new Task(1, "Make APIs", "APIs for TodoList", false),
//            new Task(2, "Task creation date", "Show task creation date and also add comments section", false)
//    ));

    public List<Task> getAllTasks(){
        return (List<Task>) taskRepository.findAll();
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }
}
