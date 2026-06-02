package dev.antonio.barbearia.projeto_barbearia.controllers;

import dev.antonio.barbearia.projeto_barbearia.dtos.ServiceDto;
import dev.antonio.barbearia.projeto_barbearia.services.ServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/services"))
public class ServiceController {

    private final ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ServiceDto> createService(@Valid @RequestBody ServiceDto serviceDto) {
        ServiceDto serviceCreated = serviceService.createService(serviceDto);

        return ResponseEntity.ok(serviceCreated);
    }


    @GetMapping
    public ResponseEntity<List<ServiceDto>> getAllService() {

        List<ServiceDto> serviceDtoList = serviceService.getAllService();

        return ResponseEntity.ok(serviceDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable(name = "id") Long id) {

        ServiceDto serviceDto = serviceService.getSeviceById(id);

        return ResponseEntity.ok(serviceDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ServiceDto> deleteServiceById(@RequestBody ServiceDto serviceDto, @PathVariable(name = "id") Long id) {

        ServiceDto serviceUpdate = serviceService.updateServiceById(serviceDto,
                id);

        return  ResponseEntity.ok(serviceUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceById(@PathVariable Long id){

        serviceService.deleteServiceById(id);

        return ResponseEntity.ok().build();
    }
}


