package com.alex.desafio_bbb_votar.service;

import com.alex.desafio_bbb_votar.dto.VotoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    private String exchange;
    private NotificacaoService notificacaoService;

    public VotoService(NotificacaoService notificacaoService, @Value("${rabbitmq.voto-pendente.exchange}") String exchange) {
        this.exchange = exchange;
        this.notificacaoService = notificacaoService;
    }

    private void notificarRabbitMQ(VotoDto dto) {
        notificacaoService.notificar(dto, exchange);
    }

    public void notificarRabbitMQService(VotoDto dto){
        notificarRabbitMQ(dto);
    }
}
