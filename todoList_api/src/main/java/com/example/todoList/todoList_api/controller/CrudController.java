package com.example.todoList.todoList_api.controller;

import com.example.todoList.todoList_api.model.Task;
import com.example.todoList.todoList_api.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrudController {

    private final CrudService crudService;

    public CrudController(CrudService crudService){
        this.crudService = crudService;
    }

    @RequestMapping("/tasks")
    public List<Task> getAllTasks(){
        return crudService.getAllTasks();
    }
}
