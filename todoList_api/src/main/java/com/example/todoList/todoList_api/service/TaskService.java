package com.example.todoList.todoList_api.service;

import com.example.todoList.todoList_api.model.Comments;
import com.example.todoList.todoList_api.model.Task;
import com.example.todoList.todoList_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class TaskService {

    private LocalDate localDate;

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
        if(taskRepository.findById(task.getId()).isPresent()){
            throw new RuntimeException("Task Already exits with same Id");
        }
        else {
            List<Comments> comments = new ArrayList<>();
            localDate = LocalDate.now(ZoneId.of("GMT+05:30"));
            Comments taskCreation = new Comments("Task Created", localDate);
            comments.add(taskCreation);
            if(task.isTaskcompleted()){
                Comments taskCompletion = new Comments("Task done", localDate);
                comments.add(taskCompletion);
            }
            else{
                Comments taskCompletion = new Comments("Task Pending", localDate);
                comments.add(taskCompletion);
            }
            task.setComments(comments);
            taskRepository.save(task);
        }
    }

    public void updateTask(int id, Task task){
        if(taskRepository.findById(id).isPresent()){
            if(id==task.getId()){
                taskRepository.save(task);
            }
            else{
                throw new RuntimeException("Can't change the Id of the Task");
            }
        }
        else{
            throw new RuntimeException("Item not found");
        }
    }
}
