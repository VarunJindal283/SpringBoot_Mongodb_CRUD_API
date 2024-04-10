package com.example.todoList.todoList_api.controller;

import com.example.todoList.todoList_api.model.Task;
import com.example.todoList.todoList_api.service.TaskService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task task){
        taskService.updateTask(id, task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks")
    public void deleteAllTasks(){
        taskService.deleteAllTasks();
    }
}
