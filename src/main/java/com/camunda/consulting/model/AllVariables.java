package com.camunda.consulting.model;

import java.util.List;

public record AllVariables(
    String aString,
    String bString,
    String cString,
    Integer aInt,
    Integer bInt,
    Integer cInt,
    List<String> listString,
    ComplexInner complexInner) {
  public record ComplexInner(String foo, Boolean bar) {}
}
