package com.example.todoList.todoList_api.service;

import com.example.todoList.todoList_api.model.Comments;
import com.example.todoList.todoList_api.model.Task;
import com.example.todoList.todoList_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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

    public Task getTask(int id){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new RuntimeException("Task doesn't exist");
        }
        else{
            return task.get();
        }
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
        Optional<Task> tempTask = taskRepository.findById(id);
        if(tempTask.isPresent()){
            Task existingTask = tempTask.get();
            if (task.getId() == null || task.getId() == id) {
                task.setId(existingTask.getId());
                if (task.getComments() == null){
                    task.setComments(existingTask.getComments());
                }
                if (task.getDescription() == null){
                    task.setDescription(existingTask.getDescription());
                }
                if (task.getTitle() == null){
                    task.setTitle(existingTask.getDescription());
                }
                if(task.isTaskcompleted()){
                    List<Comments> comments = existingTask.getComments();
                    localDate = LocalDate.now(ZoneId.of("GMT+05:30"));
                    Comments comment = new Comments("Task Done", localDate);
                    comments.set(comments.size()-1, comment);
                }
                taskRepository.save(task);
            }
            else{
                throw new RuntimeException("Can't change the id of the object");
            }
        }
        else{
            throw new RuntimeException("Task doesn't exit");
        }
    }

    public void deleteTask(int id){
        if(taskRepository.findById(id).isPresent()){
            taskRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Task doesn't exit");
        }
    }

    public void deleteAllTasks(){
        if (taskRepository.count() != 0){
            taskRepository.deleteAll();
        }
        else{
            throw new RuntimeException("No Task exist");
        }
    }
}
