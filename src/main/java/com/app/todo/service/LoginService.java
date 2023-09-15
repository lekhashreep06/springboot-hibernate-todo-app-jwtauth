package com.app.todo.service;

import com.app.todo.entity.Login;
import com.app.todo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LoginService {

    @Autowired
    LoginRepository loginRepository;
    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }

}
