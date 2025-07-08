package com.apsoo.br.verificador_metricas.Controller;

import com.apsoo.br.verificador_metricas.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    private ArrayList<User> users;

    public UserController(){
        this.users = new ArrayList<User>();
    }

    @GetMapping("/user")
    public ArrayList<User> getUsers(){
        return users;
    }


}
