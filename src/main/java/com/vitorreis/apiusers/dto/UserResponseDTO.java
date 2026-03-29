package com.vitorreis.apiusers.dto;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        Integer age
) {}
