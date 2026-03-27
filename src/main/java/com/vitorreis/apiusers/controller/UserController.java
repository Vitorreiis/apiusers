package com.vitorreis.apiusers.controller;

import com.vitorreis.apiusers.dto.UserRequestDTO;
import com.vitorreis.apiusers.dto.UserResponseDTO;
import com.vitorreis.apiusers.model.user.User;
import com.vitorreis.apiusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUser(){

        List<UserResponseDTO> response = userService.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getAge()
                ))
                .toList();

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserId(@PathVariable UUID id){

        User user = userService.findById(id);

        if(user == null){
            throw new RuntimeException("Usuário não encontrado");
        }

        UserResponseDTO userResponse = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge()
        );

        return ResponseEntity.ok(userResponse);
    }

    @PostMapping()
    public ResponseEntity<UserResponseDTO> postUser(@RequestBody UserRequestDTO request){

        User newUser = userService.createUser(
                request.name(),
                request.password(),
                request.email(),
                request.age()
        );

        UserResponseDTO userResponse = new UserResponseDTO(
                newUser.getId(),
                newUser.getName(),
                newUser.getEmail(),
                newUser.getAge()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> putUser(@PathVariable UUID id, @RequestBody UserRequestDTO request){

        User user = userService.updateUser(
                id,
                request.name(),
                request.password(),
                request.email(),
                request.age()
        );

        UserResponseDTO newUser = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge()
        );

        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("{id}")
    public Boolean deletUser(@PathVariable UUID id, @RequestBody UserRequestDTO request){

        UUID user = userService.removeUser(id);

        if(user == null){
            throw new RuntimeException("Usuário não encontrado");
        }

        return true;
    }


}
