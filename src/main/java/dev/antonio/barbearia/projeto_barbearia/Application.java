package dev.antonio.barbearia.projeto_barbearia;

import dev.antonio.barbearia.projeto_barbearia.entities.*;
import dev.antonio.barbearia.projeto_barbearia.enums.SchedulingStatus;
import dev.antonio.barbearia.projeto_barbearia.enums.UserRole;
import dev.antonio.barbearia.projeto_barbearia.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BarberShopRepository barberShopRepository;

	@Autowired
	private BarberRepository barberRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SchedulingRepository schedulingRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	private UserRole userRole;

	private SchedulingStatus status;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BarbershopEntity barbershop = new BarbershopEntity();
		barbershop.setName("BarberViking");
		barbershop.setTelephone("6599336654");
		barbershop.setEmail("barberviking@gmail.com");
		barbershop.setAddress("rua 1, quadra 1, bairro La longe");

		barberShopRepository.save(barbershop);

		BarberEntity barber = new BarberEntity();
		barber.setName("fulaninho");
		barber.setTelephone("6599866454");
		barber.setEmail("fulaninho@gmail.com");
		barber.setBarbershop(barbershop);

		barberRepository.save(barber);

		CustomerEntity customer = new CustomerEntity();
		customer.setName("outroloco");
		customer.setTelephone("659897631");
		customer.setBarbershop(barbershop);

		customerRepository.save(customer);

		ServiceEntity serviceEntity = new ServiceEntity();
		serviceEntity.setName("unhas");
		serviceEntity.setDuration(2);
		serviceEntity.setPrice(45.0);
		serviceEntity.setBarbershop(barbershop);

		serviceRepository.save(serviceEntity);

		UserEntity user = new UserEntity();
		user.setName("Antonio fodao");
		user.setEmail("john@gmail.com");
		user.setPassword("jhon123");
		user.setBarbershop(barbershop);
		user.setUserRole(userRole.EMPLOYEE);

		userRepository.save(user);

		SchedulingEntity scheduling = new SchedulingEntity();
		scheduling.setCustomer(customer);
		scheduling.setBarber(barber);
		scheduling.setBarbershop(barbershop);
		scheduling.setService(serviceEntity);
		scheduling.setStatus(status.SCHEDULED);
		scheduling.setSchedulingTime(LocalDateTime.now());

		schedulingRepository.save(scheduling);
	}
}
