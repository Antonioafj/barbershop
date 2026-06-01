package dev.antonio.barbearia.projeto_barbearia.controllers;

import dev.antonio.barbearia.projeto_barbearia.dtos.BarberShopDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import dev.antonio.barbearia.projeto_barbearia.services.BarbershopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/barbershops"))
public class BarberShopController {

    private final BarbershopService barbershopService;


    @PostMapping
    public ResponseEntity<BarbershopEntity> createBarberShop(@Valid @RequestBody BarberShopDto barberShopDto) {
        BarbershopEntity barberShop = barbershopService.createBarberShop(barberShopDto);

        return ResponseEntity.ok(barberShop);
    }


    @GetMapping
    public ResponseEntity<List<BarberShopDto>> getAllBarberShop() {

        List<BarberShopDto> barberDtoList = barbershopService.listAllBarberShop();

        return ResponseEntity.ok(barberDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberShopDto> getBarberShopById(@PathVariable(name = "id") Long id) {

        BarberShopDto barberDto = barbershopService.getBarberShopById(id);

        return ResponseEntity.ok(barberDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BarberShopDto> updateBaberShop(@RequestBody BarberShopDto barberDto, @PathVariable(name = "id") Long id) {

        BarberShopDto barber = barbershopService.updateBarberShopById(barberDto,
                id);

        return  ResponseEntity.ok(barber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarBerShopById(@PathVariable Long id){

        barbershopService.deleteBarberShopById(id);

        return ResponseEntity.ok().build();
    }
}
