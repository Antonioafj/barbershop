package dev.antonio.barbearia.projeto_barbearia.dtos;

import dev.antonio.barbearia.projeto_barbearia.enums.AppointmentStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentDto(

        Long id,

        @NotNull(message = "O cliente é obrigatório")
        Long customerId,

        @NotNull(message = "Barbearia é obrigatória")
        Long barbershopId,

        @NotNull(message = "Barbeiro é obrigatório")
        Long barberId,

        @NotNull(message = "O serviço é obrigatório")
        Long serviceId,

        AppointmentStatus status,

        @NotNull(message = "Horário de agendamento é obrigatório")
        LocalDateTime appointmentTime

) {
}
