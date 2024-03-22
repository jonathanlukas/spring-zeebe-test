package com.camunda.consulting.model;

import com.camunda.consulting.model.AllVariables.ComplexInner;

import java.util.List;

public record SubVariables1(
    String aString,

    Integer aInt,

    List<String> listString
) {}
