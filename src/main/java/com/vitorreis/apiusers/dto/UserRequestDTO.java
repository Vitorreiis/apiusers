package com.vitorreis.apiusers.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record UserRequestDTO(
        String name,
        String password,
        String email,
        Integer idade
) {}
