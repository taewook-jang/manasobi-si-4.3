package io.manasobi.step01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.PollableChannel;

/**
 * Created by tw.jang on 2017-03-14.
 */
@EnableIntegration
@Configuration
public class LoggerConfig {

    public static final LoggingHandler.Level INFO = LoggingHandler.Level.INFO;

    @Bean
    public IntegrationFlow loggerChain() {
        return IntegrationFlows.from(loggerChannel())
                               .handle(loggerHandler())
                               .get();
    }

    @Bean
    public MessageChannel loggerChannel() {
        return MessageChannels.direct().get();
    }

    public MessageHandler loggerHandler() {
        LoggingHandler loggingHandler = new LoggingHandler(INFO.name());
        return loggingHandler;
    }

}
