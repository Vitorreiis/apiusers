package com.vitorreis.apiusers.service;

import com.vitorreis.apiusers.dto.UserRequestDTO;
import com.vitorreis.apiusers.dto.UserResponseDTO;
import com.vitorreis.apiusers.model.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> bd = new ArrayList<>();

    public UserResponseDTO createUser(UserRequestDTO request){
        User newUser = new User();

        if (request.name() == null || request.password() == null || request.email() == null || request.age() == null) {
            throw new RuntimeException("Todos os campos são obrigatórios");
        }

        newUser.setId(UUID.randomUUID());
        newUser.setName(request.name());
        newUser.setPassword(request.password());
        newUser.setEmail(request.email());
        newUser.setAge(request.age());

        bd.add(newUser);

        return toResponseDTO(newUser);
    }

    public List<UserResponseDTO> findAll() {
        return bd.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public UserResponseDTO findById(UUID id) {
        User user = findEntityById(id);
        return toResponseDTO(user);
    }

    public UserResponseDTO updateUser(UUID id, UserRequestDTO request){
        User newUser = findEntityById(id);

        newUser.setName(request.name());
        newUser.setPassword(request.password());
        newUser.setEmail(request.email());
        newUser.setAge(request.age());

        return toResponseDTO(newUser);

    }

    public UUID removeUser(UUID id){

        User user = findEntityById(id);
        bd.remove(user);

        return id;
    }

    public UserResponseDTO toResponseDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge()
        );
    }

    public User findEntityById(UUID id) {
        return bd.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}
