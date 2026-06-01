package dev.antonio.barbearia.projeto_barbearia.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ServiceDto(

        Long id,

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @Positive(message = "O preço deve ser maior que zero")
        @NotNull(message = "O preço é obrigatório")
        Double price,

        @Positive(message = "A duração deve ser maior que zero")
        @NotNull(message = "A duração é obrigatória")
        Integer duration,

        @NotNull(message = "Barbearia é obrigatória")
        Long barbershopId

) {
}
