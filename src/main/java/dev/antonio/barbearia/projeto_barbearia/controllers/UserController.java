package dev.antonio.barbearia.projeto_barbearia.controllers;

import dev.antonio.barbearia.projeto_barbearia.dtos.UserDto;
import dev.antonio.barbearia.projeto_barbearia.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/users"))
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createService(@Valid @RequestBody UserDto userDto) {
        UserDto userCreated = userService.createUser(userDto);

        return ResponseEntity.ok(userCreated);
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {

        List<UserDto> userDtoList = userService.getAllUser();

        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {

        UserDto userDto = userService.getUserById(id);

        return ResponseEntity.ok(userDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDto> deleteUserById(@RequestBody UserDto userDto, @PathVariable(name = "id") Long id) {

        UserDto userUpdate = userService.updateUserById(userDto,
                id);

        return  ResponseEntity.ok(userUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){

        userService.deleteServiceById(id);

        return ResponseEntity.ok().build();
    }
}
