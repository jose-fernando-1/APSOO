package com.apsoo.br.verificador_metricas.RestController;

import com.apsoo.br.verificador_metricas.Models.User;
import com.apsoo.br.verificador_metricas.Services.PlatformFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/users")
public class LoginController {

    private final PlatformFacade platformFacade = PlatformFacade.getInstance();

    private ArrayList<User> users = new ArrayList<>();


    public LoginController(){
        this.users = new ArrayList<>();
        User user1 = new User();
        user1.setName("User1");
        user1.setEmail("email1@duck.go");
        user1.setPassword("senha123456");

        User user2 = new User();
        user2.setName("User2");
        user2.setEmail("email2@duck.go");
        user2.setPassword("senha123456");

        users.add(user1);
        users.add(user2);
    }

    @GetMapping
    public ArrayList<User> getUsers(){
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        for(Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();

            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        long id = users.size() + 1;
        user.setId(id);
        users.add(user);
        return user;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login (@RequestParam String email,
                                         @RequestParam String password){
        boolean auth = platformFacade.login(email, password);
        if (auth) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.badRequest().body("Login failed");
    }

}
