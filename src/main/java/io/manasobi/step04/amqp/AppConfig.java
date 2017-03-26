package io.manasobi.step04.amqp;

import io.manasobi.step02.LoggerConfig;
import io.manasobi.step04.MyData;
import io.manasobi.step04.OtherDataToEmptyMyData;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.SubscribableChannel;

import static org.springframework.integration.dsl.channel.MessageChannels.queue;

/**
 * Created by tw.jang on 2017-03-14.
 */
@EnableIntegration
@Configuration
@Import(LoggerConfig.class)
public class AppConfig {

    @Bean
    public ConnectionFactory connectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("localhost:5672,localhost:5673");

        return connectionFactory;
    }

    @Bean
    public Queue queue() {
        return new Queue("order.queue");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin admin=new RabbitAdmin(connectionFactory());
        admin.declareQueue(queue());
        return admin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory());
        rabbitTemplate.setRoutingKey("order.queue");
        rabbitTemplate.setQueue("order.queue");
        return rabbitTemplate;
    }

}
