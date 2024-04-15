package com.example.todoList.todoList_api.service;

import com.example.todoList.todoList_api.model.Comments;
import com.example.todoList.todoList_api.model.Task;
import com.example.todoList.todoList_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private TaskRepository taskRepository;

    public CommentService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Comments> getAllComments(int id){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new RuntimeException("Task not present");
        }
        return task.get().getComments();
    }

    public void addComment(int id, String description){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty()) {
            throw new RuntimeException("Task not present");
        }
        else{
            List<Comments> comments = task.get().getComments();
            LocalDate localDate = LocalDate.now(ZoneId.of("GMT+05:30"));
            Comments comment = new Comments(description, localDate);
            comments.add(comments.size()-2, comment);
            task.get().setComments(comments);
            taskRepository.save(task.get());
        }
    }
}
