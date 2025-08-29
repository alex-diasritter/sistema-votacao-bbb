package com.alex.desafio_bbb_votar.service;
import com.alex.desafio_bbb_votar.dto.VotoDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notificar(VotoDto votoDto, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", votoDto);
    }

}
