package dev.antonio.barbearia.projeto_barbearia.repositories;

import dev.antonio.barbearia.projeto_barbearia.entities.BarberEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
