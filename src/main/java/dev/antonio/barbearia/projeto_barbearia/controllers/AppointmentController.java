package dev.antonio.barbearia.projeto_barbearia.controllers;

import dev.antonio.barbearia.projeto_barbearia.dtos.CustomerDto;
import dev.antonio.barbearia.projeto_barbearia.services.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/appointments"))
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<CustomerDto> createAppointment(@Valid @RequestBody CustomerDto barberDto) {
        CustomerDto customer = appointmentService.createCustomer(barberDto);

        return ResponseEntity.ok(customer);
    }


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {

        List<CustomerDto> barberDtoList = appointmentService.getAllCustomer();

        return ResponseEntity.ok(barberDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") Long id) {

        CustomerDto customerDto = appointmentService.getCustomerById(id);

        return ResponseEntity.ok(customerDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomerById(@RequestBody CustomerDto customerDto, @PathVariable(name = "id") Long id) {

        CustomerDto customerUpdate = appointmentService.updateCustomerById(customerDto,
                id);

        return  ResponseEntity.ok(customerUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarBerById(@PathVariable Long id){

        appointmentService.deleteCustomerById(id);

        return ResponseEntity.ok().build();
    }
}
