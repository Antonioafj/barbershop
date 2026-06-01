package dev.antonio.barbearia.projeto_barbearia.controllers;

import dev.antonio.barbearia.projeto_barbearia.dtos.BarberDto;
import dev.antonio.barbearia.projeto_barbearia.services.BarberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/barbers"))
public class BarberController {

    private final BarberService barberService;

    @PostMapping
    public ResponseEntity<BarberDto> createBarber(@Valid @RequestBody BarberDto barberDto) {
        BarberDto barber = barberService.createBarber(barberDto);

        return ResponseEntity.ok(barber);
    }


    @GetMapping
    public ResponseEntity<List<BarberDto>> getAllBarber() {

        List<BarberDto> barberDtoList = barberService.listAllBarber();

        return ResponseEntity.ok(barberDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberDto> getBarberById(@PathVariable(name = "id") Long id) {

        BarberDto barberDto = barberService.getBarberById(id);

        return ResponseEntity.ok(barberDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BarberDto> updateBaber(@RequestBody BarberDto barberDto, @PathVariable(name = "id") Long id) {

        BarberDto barber = barberService.updateBarberById(barberDto,
                id);

        return  ResponseEntity.ok(barber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarBerById(@PathVariable Long id){

         barberService.deleteBarberById(id);

        return ResponseEntity.ok().build();
    }
}
