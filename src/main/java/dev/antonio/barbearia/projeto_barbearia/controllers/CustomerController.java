package dev.antonio.barbearia.projeto_barbearia.controllers;

import dev.antonio.barbearia.projeto_barbearia.dtos.CustomerDto;
import dev.antonio.barbearia.projeto_barbearia.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/customers"))
public class CustomerController {


    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCostumer(@Valid @RequestBody CustomerDto barberDto) {
        CustomerDto customer = customerService.createCustomer(barberDto);

        return ResponseEntity.ok(customer);
    }


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {

        List<CustomerDto> barberDtoList = customerService.getAllCustomer();

        return ResponseEntity.ok(barberDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") Long id) {

        CustomerDto customerDto = customerService.getCustomerById(id);

        return ResponseEntity.ok(customerDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomerById(@RequestBody CustomerDto customerDto, @PathVariable(name = "id") Long id) {

        CustomerDto customerUpdate = customerService.updateCustomerById(customerDto,
                id);

        return  ResponseEntity.ok(customerUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarBerById(@PathVariable Long id){

        customerService.deleteCustomerById(id);

        return ResponseEntity.ok().build();
    }
}


