package io.manasobi.step02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

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
    public DirectChannel loggerChannel() {
        return MessageChannels.direct().get();
    }

    public MessageHandler loggerHandler() {
        LoggingHandler loggingHandler = new LoggingHandler(INFO.name());
        loggingHandler.setShouldLogFullMessage(true);
        return loggingHandler;
    }

}
