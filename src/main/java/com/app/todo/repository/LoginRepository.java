package com.app.todo.repository;

import com.app.todo.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
