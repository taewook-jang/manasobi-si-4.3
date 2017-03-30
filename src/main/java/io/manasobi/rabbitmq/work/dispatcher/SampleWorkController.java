package io.manasobi.rabbitmq.work.dispatcher;

import io.manasobi.rabbitmq.work.dispatcher.domain.WorkUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleWorkController {

    @Autowired
    private WorkUnitGateway workUnitGateway;

    @RequestMapping("/generateWork")
    @ResponseBody
    public WorkUnit generateWork(WorkUnit workUnit) {
        workUnitGateway.generate(workUnit);
        return workUnit;
    }
}
