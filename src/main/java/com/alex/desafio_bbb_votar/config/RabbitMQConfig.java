package com.alex.desafio_bbb_votar.config;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.voto-pendente.exchange}")
    private String exchangeVotoPendente;

    @Value("${rabbitmq.voto-concluido.exchange}")
    private String exchangeVotoConcluido;

    @Bean
    public Queue criarFilaVotoPendente() {
        return QueueBuilder.durable("voto-pendente").build();
    }

    @Bean
    public Queue criarFilaVotoConcluido() {
        return QueueBuilder.durable("voto-concluido").build();
    }

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange criarFanoutExchangeVotoPendente() {
        return ExchangeBuilder.fanoutExchange(exchangeVotoPendente).build();
    }

    @Bean
    public FanoutExchange criarFanoutExchangeVotoConcluido() {
        return ExchangeBuilder.fanoutExchange(exchangeVotoConcluido).build();
    }

    @Bean
    public Binding criarBindingVotoPendente() {
        return BindingBuilder.bind(criarFilaVotoPendente()).
                to(criarFanoutExchangeVotoPendente());
    }

    @Bean
    public Binding criarBindingVotoConcluido() {
        return BindingBuilder.bind(criarFilaVotoConcluido()).
                to(criarFanoutExchangeVotoConcluido());
    }


    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}