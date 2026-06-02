package dev.antonio.barbearia.projeto_barbearia.repositories;

import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarberShopRepository extends JpaRepository<BarbershopEntity, Long> {

    List<BarbershopEntity> findAllByActiveTrue();
    Optional<BarbershopEntity> findByIdAndActiveTrue(Long id);
}
