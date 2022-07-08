package com.example.ffbank.orm.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

@Component
public class App1Worker {

    @ZeebeWorker(type = "callApp1", autoComplete = true)
    public void callApp1(final ActivatedJob job) {
        System.out.println("call app1");
    }
}
