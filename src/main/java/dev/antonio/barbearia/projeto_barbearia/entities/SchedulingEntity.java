package dev.antonio.barbearia.projeto_barbearia.entities;


import dev.antonio.barbearia.projeto_barbearia.enums.SchedulingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "scheduling")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "O cliente é obrigatório")
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @NotNull(message = "Barbearia é obrigatória")
    @JoinColumn(name = "barbershop_id", nullable = false)
    private BarbershopEntity barbershop;

    @ManyToOne
    @NotNull(message = "Barbeiro é obrigatório")
    @JoinColumn(name = "barber_id", nullable = false)
    private BarberEntity barber;

    @ManyToOne
    @NotNull(message = "O serviço é obrigatório")
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity service;

    @NotNull(message = "Status é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SchedulingStatus status;

    @NotNull(message = "Horário de agendamento é obrigatório")
    @Column(name = "scheduling_time", nullable = false)
    private LocalDateTime schedulingTime;

}
