package io.manasobi.step04.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.handler.ServiceActivatingHandler;

/**
 * Spring bean configuration class is abstract to prevent instantiation.
 */
@Configuration
@ImportResource(value = {"rabbitmq-config.xml"})
@EnableIntegration
public class IntegrationTestConfig {

    /**
     * {@code TestService} is hidden behind {@code TestServiceGateway} in order to prevent
     * Spring Integration annotations (used by {@code IntegrationComponentScan}) from leaking
     * out of the configuration.
     */
    @MessagingGateway
    static interface TestServiceGateway extends TestService {
        @Override
        @Gateway(requestChannel = "testOutputChannel")
        String process(TestEntity testEntity);
    }

    /**
     * The {@code TestServiceImpl} bean is wrapped in a {@code ServiceActivatingHandler}
     * to enable auto-wiring by {@code IntegrationComponentScan}.
     */
    @Bean
    @ServiceActivator(inputChannel = "testInputChannel")
    ServiceActivatingHandler testServiceActivator() {
        return new ServiceActivatingHandler(new TestServiceImpl());
    }

}
