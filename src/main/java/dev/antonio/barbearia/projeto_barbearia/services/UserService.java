package dev.antonio.barbearia.projeto_barbearia.services;

import dev.antonio.barbearia.projeto_barbearia.dtos.UserDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.ServiceEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.UserEntity;
import dev.antonio.barbearia.projeto_barbearia.mapper.UserMapper;
import dev.antonio.barbearia.projeto_barbearia.repositories.BarberShopRepository;
import dev.antonio.barbearia.projeto_barbearia.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    private final BarberShopRepository barberShopRepository;

    private final UserMapper userMapper;

    public UserDto createUser(UserDto userDto){

        BarbershopEntity barbershop = barberShopRepository.findById(userDto.barbershopId()).orElse(null);

        if (barbershop == null){
            throw new RuntimeException("Barbershop not found");
        }

        UserEntity user = userMapper.toUserEntity(userDto);

        user.setBarbershop(barbershop);

        UserEntity savedService = userRepository.save(user);

        return userMapper.toUserDto(savedService);
    }

    public List<UserDto> getAllUser(){
        List<UserEntity> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (UserEntity user : userList) {

            UserDto serviceDto = userMapper.toUserDto(user);

            userDtoList.add(serviceDto);
        }
        return userDtoList;
    }

    public UserDto getUserById(Long userId){

        UserEntity user = userRepository.findById(userId).orElse(null);

        if (user == null){
            throw  new RuntimeException("Service not found");
        }

        UserDto userDto = userMapper.toUserDto(user);

        return userDto;
    }

    public UserDto updateUserById(UserDto userDto, Long userId){

        UserEntity user = userRepository.findById(userId).orElse(null);

        if (user == null){
            throw  new RuntimeException("Service not found");
        }

        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());

        userRepository.save(user);

        return userMapper.toUserDto(user);
    }


    public void deleteServiceById( Long serviceId ){

        UserEntity service = userRepository.findById(serviceId).orElse(null);

        if (service == null){

            throw  new RuntimeException("Barber not found");

        }

        userRepository.delete(service);
    }
}
