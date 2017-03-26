package io.manasobi.step04.rabbitmq;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public String process(TestEntity testEntity) {
        return testEntity.getValue();
    }

}
