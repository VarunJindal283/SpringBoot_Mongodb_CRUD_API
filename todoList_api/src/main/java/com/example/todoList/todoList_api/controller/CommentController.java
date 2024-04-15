package com.example.todoList.todoList_api.controller;

import com.example.todoList.todoList_api.model.Comments;
import com.example.todoList.todoList_api.service.CommentService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/tasks/{taskId}/comments")
    public void addComment(@PathVariable(value = "taskId") int id, @RequestBody String description){
        commentService.addComment(id, description);
    }
}
