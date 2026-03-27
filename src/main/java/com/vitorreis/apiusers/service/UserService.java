package com.vitorreis.apiusers.service;

import com.vitorreis.apiusers.model.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> bd = new ArrayList<>();

    public User createUser(String name, String password, String email, Integer age){
        User newUser = new User();

        if (name == null || password == null || email == null || age == null) {
            throw new RuntimeException("Todos os campos são obrigatórios");
        }

        newUser.setId(UUID.randomUUID());
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setAge(age);

        bd.add(newUser);

        return newUser;
    }

    public List<User> findAll() {

        return bd;
    }

    public User findById(UUID id) {
        return bd.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User updateUser(UUID id, String name, String password, String email, Integer age){
        User newUser = findById(id);

        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setAge(age);

        return newUser;

    }

    public UUID removeUser(UUID id){

        User user = findById(id);
        bd.remove(user);

        return id;
    }

}
