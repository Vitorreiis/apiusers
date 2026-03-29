package com.vitorreis.apiusers.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String name,

        @NotBlank(message = "Senha é obrigatória")
        String password,

        @NotBlank(message = "Email inválido")
        String email,

        @Min(value = 17, message = "Idade deve ser maior ou igual a 18 anos")
        Integer age
) {}
