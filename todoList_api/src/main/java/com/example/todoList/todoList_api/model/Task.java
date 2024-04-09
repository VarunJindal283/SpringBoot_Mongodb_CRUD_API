package com.example.todoList.todoList_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Integer id;
    private String title;
    private String description;
    private boolean isTaskcompleted;
}
