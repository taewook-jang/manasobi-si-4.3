package io.manasobi.step04;

import io.manasobi.step02.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.channel.DirectChannel;
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

    @Bean
    public DirectChannel channel() {
        return MessageChannels.direct()
                              .datatype(MyData.class, String.class, Integer.class)
                              .messageConverter(messageConverter())
                              .get();
    }

    private OtherDataToEmptyMyData messageConverter() {
        return new OtherDataToEmptyMyData();
    }

}
