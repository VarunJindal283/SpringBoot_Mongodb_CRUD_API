package com.example.todoList.todoList_api.model;

import com.mongodb.annotations.Sealed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    private String description;
    private LocalDate createdAt;
}
