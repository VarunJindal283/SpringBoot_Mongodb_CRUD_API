package com.example.todoList.todoList_api.controller;

import com.example.todoList.todoList_api.model.Task;
import com.example.todoList.todoList_api.service.TaskService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tasks")
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }
}
