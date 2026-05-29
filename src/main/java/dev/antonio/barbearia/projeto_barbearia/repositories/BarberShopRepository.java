package dev.antonio.barbearia.projeto_barbearia.repositories;

import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberShopRepository extends JpaRepository<BarbershopEntity, Long> {
}
