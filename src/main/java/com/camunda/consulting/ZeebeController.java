package com.camunda.consulting;

import com.camunda.consulting.model.SubVariables1;
import com.camunda.consulting.model.SubVariables2;
import com.camunda.consulting.model.SubVariables3;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ZeebeController {
  private static final Logger LOG = LoggerFactory.getLogger(ZeebeController.class);

  @JobWorker
  public void task1(@VariablesAsType SubVariables1 variables) {
    LOG.info("Received {}", variables);
  }

  @JobWorker
  public void task2(@VariablesAsType SubVariables2 variables) {
    LOG.info("Received {}", variables);
  }

  @JobWorker
  public void task3(@VariablesAsType SubVariables3 variables) {
    LOG.info("Received {}", variables);
  }
}
