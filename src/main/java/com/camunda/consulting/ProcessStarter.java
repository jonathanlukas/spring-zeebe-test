package com.camunda.consulting;

import com.camunda.consulting.model.AllVariables;
import com.camunda.consulting.model.AllVariables.ComplexInner;
import io.camunda.zeebe.client.ZeebeClient;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ProcessStarter {
  private final ZeebeClient zeebeClient;

  public ProcessStarter(ZeebeClient zeebeClient) {
    this.zeebeClient = zeebeClient;
  }

  private static String random() {
    return RandomStringUtils.randomAlphabetic(10);
  }

  private static Integer randomInt() {
    return new Random().nextInt();
  }

  @Scheduled(fixedRate = 5000L)
  public void startProcessInstance() {
    zeebeClient
        .newCreateInstanceCommand()
        .bpmnProcessId("process")
        .latestVersion()
        .variables(createVariables())
        .send()
        .join();
  }

  private AllVariables createVariables() {
    return new AllVariables(
        random(),
        random(),
        random(),
        randomInt(),
        randomInt(),
        randomInt(),
        List.of(random(), random(), random()),
        new ComplexInner(random(), true));
  }
}
