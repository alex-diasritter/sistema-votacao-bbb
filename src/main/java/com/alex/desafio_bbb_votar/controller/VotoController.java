package com.alex.desafio_bbb_votar.controller;
import com.alex.desafio_bbb_votar.dto.VotoDto;
import com.alex.desafio_bbb_votar.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping("/votar")
    public ResponseEntity<Void> votar(@RequestBody VotoDto votoDto) {
            votoService.notificarRabbitMQService(votoDto);
        return ResponseEntity.accepted().build();
    }
}
