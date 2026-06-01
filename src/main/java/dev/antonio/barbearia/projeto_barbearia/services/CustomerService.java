package dev.antonio.barbearia.projeto_barbearia.services;

import dev.antonio.barbearia.projeto_barbearia.dtos.CustomerDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.CustomerEntity;
import dev.antonio.barbearia.projeto_barbearia.mapper.CustumerMapper;
import dev.antonio.barbearia.projeto_barbearia.repositories.BarberShopRepository;
import dev.antonio.barbearia.projeto_barbearia.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final BarberShopRepository barberShopRepository;

    private final CustumerMapper custumerMapper;

    public CustomerDto createCustomer(CustomerDto customerDto){

        BarbershopEntity barbershop = barberShopRepository.findById(customerDto.barbershopId()).orElse(null);

        if (barbershop == null){
            throw new RuntimeException("Barbershop not found");
        }

        CustomerEntity customer = custumerMapper.toCustomerEntity(customerDto);

        customer.setBarbershop(barbershop);

        CustomerEntity savedCustomer = customerRepository.save(customer);

        return custumerMapper.toCustomerDto(savedCustomer);
    }

    public List<CustomerDto> getAllCustomer(){
        List<CustomerEntity> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (CustomerEntity customer : customerList) {

            CustomerDto customerDto= custumerMapper.toCustomerDto(customer);

            customerDtoList.add(customerDto);
        }
        return customerDtoList;
    }

    public CustomerDto getCustomerById(Long customerId){

        CustomerEntity customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null){
            throw  new RuntimeException("Customer not found");
        }

        CustomerDto customerDto = custumerMapper.toCustomerDto(customer);

        return customerDto;
    }

    public CustomerDto updateCustomerById(CustomerDto customerDto, Long customerId){

        CustomerEntity customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null){
            throw  new RuntimeException("Customer not found");
        }

        customer.setName(customerDto.name());
        customer.setTelephone(customerDto.telephone());

        customerRepository.save(customer);

        return custumerMapper.toCustomerDto(customer);
    }


    public void deleteCustomerById( Long barberId ){

        CustomerEntity customer = customerRepository.findById(barberId).orElse(null);

        if (customer == null){

            throw  new RuntimeException("Barber not found");

        }

        customerRepository.delete(customer);
    }
}
