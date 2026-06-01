package dev.antonio.barbearia.projeto_barbearia.repositories;

import dev.antonio.barbearia.projeto_barbearia.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
