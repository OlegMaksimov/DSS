package com.example.ffbank.orm.rest;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.spring.client.ZeebeClientLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/camunda")
public class CamundaStartController {

    @Autowired
    private ZeebeClientLifecycle zeebeClient;

    @GetMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public void start(){
        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("template-ticket-booking ").latestVersion()
                .send()
                .exceptionally( throwable -> { throw new RuntimeException("Could not create new instance", throwable); });
    }

}
