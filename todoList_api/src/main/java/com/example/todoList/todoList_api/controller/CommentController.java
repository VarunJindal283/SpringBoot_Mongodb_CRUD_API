package com.example.todoList.todoList_api.controller;

import com.example.todoList.todoList_api.model.Comments;
import com.example.todoList.todoList_api.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{taskId}/comments")
    public List<Comments> getAllComments(@PathVariable(value = "taskId") int id){
        return commentService.getAllComments(id);
    }
}
