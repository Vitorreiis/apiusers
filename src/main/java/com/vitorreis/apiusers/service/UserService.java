package com.vitorreis.apiusers.service;

import com.vitorreis.apiusers.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> bd = new ArrayList<>();

    public User createUser(String name, String password, String email, Integer age){
        User newUser = new User();

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

    public User findById(Integer id) {
        return bd.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User updateUser(Integer id, String name, String password, String email, Integer age){
        User newUser = findById(id);

        if (newUser == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setAge(age);

        return newUser;

    }

    public void removeUser(Integer id){

        User user = findById(id);
        bd.remove(user);
    }

}
