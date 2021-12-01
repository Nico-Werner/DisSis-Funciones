package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.FunctionVisitor;

import java.util.ArrayList;
import java.util.List;

public class Variable implements Function{

    private String variable;
    private double value;
    private OperationType operationType;

    public Variable(String variable, double value, OperationType operationType) {
        this.variable = variable;
        this.value = value;
        this.operationType = operationType;
    }

    public Variable(String variable, OperationType operationType) {
        this.variable = variable;
        this.operationType = operationType;
    }

    public Variable(double value, OperationType operationType) {
        this.value = value;
        this.operationType = operationType;
    }

    public Variable(String variable, double value) {
        this.variable = variable;
        this.value = value;
    }

    public Variable(String variable) {
        this.variable = variable;
    }

    public Variable(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getVariable() {
        return variable;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    private boolean isOperationNull(){
        return operationType == null;
    }

    @Override
    public boolean isComposed() {
        return false;
    }

    @Override
    public void accept(FunctionVisitor functionVisitor) {
        functionVisitor.visitVariable(this);
    }
}
