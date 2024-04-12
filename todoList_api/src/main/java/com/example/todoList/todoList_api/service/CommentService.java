package com.example.todoList.todoList_api.service;

import com.example.todoList.todoList_api.controller.CommentController;
import com.example.todoList.todoList_api.model.Comments;
import com.example.todoList.todoList_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private TaskRepository taskRepository;

    public CommentService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Comments> getAllComments(int id){
        return taskRepository.findById(id).get().getComments();
    }
}
