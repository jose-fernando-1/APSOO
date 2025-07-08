package com.apsoo.br.verificador_metricas.Repository;

import java.util.HashMap;
import com.apsoo.br.verificador_metricas.Models.User;
import java.util.Optional;

import java.util.Map;

public class UserRepository {
    private static UserRepository userRepository;
    //TODO ADD MySQL database
    private Map<Long, User> users = new HashMap<>();
    private long idCounter = 1;

    private UserRepository (){}

    public static synchronized UserRepository getInstance(){
        if (userRepository == null) userRepository = new UserRepository();
        return userRepository;
    }
    public User save (User user){
        if (user.getId() == null) user.setId(idCounter++);
        users.put(user.getId(), user);
        return user;
    }

    public Optional<User> findByEmail(String email){
        return users.values()
                .stream().filter
                        (u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public User findById(Long id){
        return users.get(id);
    }

}
