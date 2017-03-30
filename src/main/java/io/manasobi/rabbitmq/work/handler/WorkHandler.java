package io.manasobi.rabbitmq.work.handler;

import io.manasobi.rabbitmq.work.handler.domain.WorkUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WorkHandler {

    public void process(WorkUnit workUnit) {

        if (workUnit.isThrowException()) {
            log.info("Throwing a deliberate exception for work unit - id: {}, definition: {}",
                                workUnit.getId(), workUnit.getDefinition());
            throw new RuntimeException("Throwing a deliberate exception");
        }

        log.info("Handling work unit - id: {}, definition: {}", workUnit.getId(), workUnit.getDefinition());
    }
}
