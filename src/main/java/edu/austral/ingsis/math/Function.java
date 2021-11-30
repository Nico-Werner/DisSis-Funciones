package edu.austral.ingsis.math;

import java.util.List;

public interface Function {
    double evaluate();

    String print();

    void addVariables(List<String> variables);

    List<String> getVariables();

    boolean isComposed();

}
