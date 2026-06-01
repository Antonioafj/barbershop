package dev.antonio.barbearia.projeto_barbearia.repositories;

import dev.antonio.barbearia.projeto_barbearia.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
