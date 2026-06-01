package dev.antonio.barbearia.projeto_barbearia.services;

import dev.antonio.barbearia.projeto_barbearia.dtos.BarberShopDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import dev.antonio.barbearia.projeto_barbearia.mapper.BarberShopMapper;
import dev.antonio.barbearia.projeto_barbearia.repositories.BarberShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BarbershopService {

    private final BarberShopRepository barberShopRepository;

    private final BarberShopMapper barberShopMapper;


    public BarbershopEntity createBarberShop(BarberShopDto barberShopDto){


        BarbershopEntity barberShop = barberShopMapper.toBarbershopEntity(barberShopDto);


        barberShopRepository.save(barberShop);

        return barberShop;
    }

    public List<BarberShopDto> listAllBarberShop(){
        List<BarbershopEntity> barberShopList = barberShopRepository.findAll();
        List<BarberShopDto> barberShopDtoList = new ArrayList<>();

        for (BarbershopEntity barber : barberShopList) {

            BarberShopDto barberDto= barberShopMapper.toBarberShopDto(barber);

            barberShopDtoList.add(barberDto);
        }
        return barberShopDtoList;
    }

    public BarberShopDto getBarberShopById(Long barberShopId){

        BarbershopEntity barberShop = barberShopRepository.findById(barberShopId).orElse(null);

        if (barberShop == null){
            throw  new RuntimeException("Barber not found");
        }

        BarberShopDto barberShopDto = barberShopMapper.toBarberShopDto(barberShop);

        return barberShopDto;
    }

    public BarberShopDto updateBarberShopById(BarberShopDto barberDto, Long barberShopId){

        BarbershopEntity barberShop = barberShopRepository.findById(barberShopId).orElse(null);

        if (barberShop == null){
            throw  new RuntimeException("Barber not found");
        }

        barberShop.setName(barberDto.name());
        barberShop.setTelephone(barberDto.telephone());
        barberShop.setEmail(barberDto.email());

        barberShopRepository.save(barberShop);

        return barberShopMapper.toBarberShopDto(barberShop);
    }


    public void deleteBarberShopById( Long barberId ){

        BarbershopEntity barberShop = barberShopRepository.findById(barberId).orElse(null);

        if (barberShop == null){

            throw  new RuntimeException("Barber not found");

        }

        barberShopRepository.delete(barberShop);
    }
}
