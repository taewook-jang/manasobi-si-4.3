package io.manasobi.step02;

import io.manasobi.step01.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

/**
 * Created by tw.jang on 2017-03-14.
 */
@EnableIntegration
@Configuration
@Import(LoggerConfig.class)
public class AppConfig {

    @Autowired
    private MessageChannel loggerChannel;

    @Bean
    public MessageChannel inputChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public PollableChannel outputChannel() {
        return MessageChannels.queue(5).wireTap(loggerChannel).get();
    }

}
