package com.app.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceTodoId")
    @SequenceGenerator(name = "SequenceTodoId", sequenceName = "TODO_SEQ")
    private int id;
    private String task;
    private Boolean isCompleted;

}
