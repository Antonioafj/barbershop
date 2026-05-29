package dev.antonio.barbearia.projeto_barbearia.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerDto(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O telefone é obrigatório")
        String telephone,

        @NotNull(message = "Barbearia é obrigatória")
        Long barbershopId

) {
}
