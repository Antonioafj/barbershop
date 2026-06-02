package dev.antonio.barbearia.projeto_barbearia.controllers;

import dev.antonio.barbearia.projeto_barbearia.dtos.AppointmentDto;
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
    public ResponseEntity<AppointmentDto> createAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
        AppointmentDto appointment = appointmentService.createAppointment(appointmentDto);

        return ResponseEntity.ok(appointment);
    }


    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointment() {

        List<AppointmentDto> appointmentDtoList = appointmentService.getAllAppointment();

        return ResponseEntity.ok(appointmentDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable(name = "id") Long id) {

        AppointmentDto appointmentDto = appointmentService.getAppointmentById(id);

        return ResponseEntity.ok(appointmentDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointmentById(@RequestBody AppointmentDto appointmentDto, @PathVariable(name = "id") Long id) {

        AppointmentDto appointmentUpdate = appointmentService.updateAppointmentById(appointmentDto,
                id);

        return  ResponseEntity.ok(appointmentUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable Long id){

        appointmentService.deleteAppointmentById(id);

        return ResponseEntity.ok().build();
    }
}
