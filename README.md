# Spring Zeebe Test

This project should work with some zeebe features and validate them.

## Covered features

### Variable Fetching

As variables should be fetched scoped, spring-zeebe offers a mechanism to fetch only the variables required by the `@JobWorker` function.

This can be inspected in the logs:

```logs
2024-03-22T07:18:44.097+01:00  INFO 39499 --- [           main] i.c.z.s.c.jobhandling.JobWorkerManager   : . Starting Zeebe worker: ZeebeWorkerValue{type='task1', name='zeebeController#task1', timeout=-1, maxJobsActive=-1, requestTimeout=-1, pollInterval=-1, autoComplete=true, fetchVariables=[aInt, aString, listString], enabled=true, methodInfo=io.camunda.zeebe.spring.client.bean.MethodInfo@430b2699, tenantIds=[], forceFetchAllVariables=false}
2024-03-22T07:18:44.097+01:00  INFO 39499 --- [           main] i.c.z.s.c.jobhandling.JobWorkerManager   : . Starting Zeebe worker: ZeebeWorkerValue{type='task2', name='zeebeController#task2', timeout=-1, maxJobsActive=-1, requestTimeout=-1, pollInterval=-1, autoComplete=true, fetchVariables=[bInt, complexInner, bString], enabled=true, methodInfo=io.camunda.zeebe.spring.client.bean.MethodInfo@40de8f93, tenantIds=[], forceFetchAllVariables=false}
2024-03-22T07:18:44.097+01:00  INFO 39499 --- [           main] i.c.z.s.c.jobhandling.JobWorkerManager   : . Starting Zeebe worker: ZeebeWorkerValue{type='task3', name='zeebeController#task3', timeout=-1, maxJobsActive=-1, requestTimeout=-1, pollInterval=-1, autoComplete=true, fetchVariables=[cInt, cString], enabled=true, methodInfo=io.camunda.zeebe.spring.client.bean.MethodInfo@6ff0b1cc, tenantIds=[], forceFetchAllVariables=false}
```

As you can see, only some variables are fetched although the `@JobWorker` annotation does not indicate it:

```java
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
```