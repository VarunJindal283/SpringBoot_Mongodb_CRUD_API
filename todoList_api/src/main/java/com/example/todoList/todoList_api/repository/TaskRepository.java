package com.example.todoList.todoList_api.repository;

import com.example.todoList.todoList_api.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
