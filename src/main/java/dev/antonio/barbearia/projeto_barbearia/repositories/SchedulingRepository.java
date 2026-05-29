package dev.antonio.barbearia.projeto_barbearia.repositories;

import dev.antonio.barbearia.projeto_barbearia.entities.BarberEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.SchedulingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {
}
