package dev.antonio.barbearia.projeto_barbearia.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record BarberShopDto(

        Long id,

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O telefone é obrigatório")
        String telephone,

        @NotBlank(message = "O Email é obrigatório")
        @Email(message = "Insira um email válido")
        String email,

        @NotBlank(message = "O endereço é obrigatório")
        String address
) {
}
