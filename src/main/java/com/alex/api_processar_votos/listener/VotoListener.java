package com.alex.api_processar_votos.listener;
import com.alex.api_processar_votos.domain.dto.VotoDto;
import com.alex.api_processar_votos.service.VotoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VotoListener {

    @Autowired
    private VotoService service;

    @RabbitListener(queues = "${rabbitmq.queue.votacao}")
    public void processarVoto(VotoDto votoDto){
        service.processar(votoDto);
    }
}
