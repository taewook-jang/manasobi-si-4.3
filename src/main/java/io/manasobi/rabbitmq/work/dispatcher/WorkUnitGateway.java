package io.manasobi.rabbitmq.work.dispatcher;

import io.manasobi.rabbitmq.work.dispatcher.domain.WorkUnit;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface WorkUnitGateway {

	@Gateway(requestChannel = "worksChannel")
	void generate(WorkUnit workUnit);
}
