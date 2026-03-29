package com.vitorreis.apiusers.controller;

import com.vitorreis.apiusers.dto.UserRequestDTO;
import com.vitorreis.apiusers.dto.UserResponseDTO;
import com.vitorreis.apiusers.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<UserResponseDTO>> getUsers(){
        return ResponseEntity.ok(userService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserId(@PathVariable UUID id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> postUser(@RequestBody @Valid UserRequestDTO request){

        UserResponseDTO newUser = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> putUser(@PathVariable UUID id, @RequestBody @Valid UserRequestDTO request){

        UserResponseDTO user = userService.updateUser(id, request);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {

        userService.removeUser(id);
        return ResponseEntity.noContent().build();
    }

}
