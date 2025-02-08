package com.muhammet.jpa.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DoLoginRequestDto(
        @NotNull
        @NotEmpty
        @Size(min = 3, max = 64)
        String userName,
        @NotNull
        @NotEmpty
        @Size(min = 8, max = 64)
        @Pattern(
                message = "Şifreniz; En az bir küçük, bir büyük harf olmalı ve en az bir rakam içermeli ve en az bir özel karakter içermelidir.",
                regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,64}$")
        String password
) {
}
