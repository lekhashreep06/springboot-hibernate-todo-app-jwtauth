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
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceLoginId")
    @SequenceGenerator(name = "SequenceLoginId", sequenceName = "LOGIN_SEQ")
    private int id;
    private String username;
    private String token;

}
