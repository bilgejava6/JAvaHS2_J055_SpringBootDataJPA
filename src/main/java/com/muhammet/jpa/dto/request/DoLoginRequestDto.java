package com.muhammet.jpa.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DoLoginRequestDto(
        @NotNull
        @NotEmpty
        @Size(min = 3, max = 64)
        String userName,
        @NotNull
        @NotEmpty
        @Size(min = 8, max = 64)
        String password
) {
}
