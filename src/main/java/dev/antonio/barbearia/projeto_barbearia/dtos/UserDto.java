package dev.antonio.barbearia.projeto_barbearia.dtos;

import dev.antonio.barbearia.projeto_barbearia.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @Email(message = "Insira o email válido")
        @NotBlank(message = "O email é obrigatório")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        String password,

        @NotNull(message = "Barbearia é obrigatória")
         Long barbershopId,

        @NotNull(message = "Perfil de usuário é obrigatório")
        UserRole userRole
) {
}
