package dev.antonio.barbearia.projeto_barbearia.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BarberDto(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O telefone é obrigatório")
        String telephone,

        @NotBlank(message = "O Email é obrigatório")
        @Email(message = "Insira um email válido")
        String email,

        @NotNull(message = "Barbearia é obrigatória")
        Long barbershopId
) {
}
