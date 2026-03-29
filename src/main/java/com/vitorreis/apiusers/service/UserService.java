package com.vitorreis.apiusers.service;

import com.vitorreis.apiusers.dto.UserRequestDTO;
import com.vitorreis.apiusers.dto.UserResponseDTO;
import com.vitorreis.apiusers.exceptions.UserNotFoundException;
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

            newUser.setId(UUID.randomUUID());
            newUser.setName(request.name());
            newUser.setPassword(request.password());
            newUser.setEmail(request.email());
            newUser.setAge(request.age());

            bd.add(newUser);

        return toDTO(newUser);
    }

    public List<UserResponseDTO> findAll() {
        return bd.stream()
                .map(this::toDTO)
                .toList();
    }

    public UserResponseDTO findById(UUID id) {
        User user = findEntityById(id);
        return toDTO(user);
    }

    public UserResponseDTO updateUser(UUID id, UserRequestDTO request){
        User user = findEntityById(id);

        user.setName(request.name());
        user.setPassword(request.password());
        user.setEmail(request.email());
        user.setAge(request.age());

        return toDTO(user);

    }

    public void removeUser(UUID id){

        User user = findEntityById(id);
        bd.remove(user);
    }

    public UserResponseDTO toDTO(User user){
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
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }

}
