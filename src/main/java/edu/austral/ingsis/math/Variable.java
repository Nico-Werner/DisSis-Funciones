package edu.austral.ingsis.math;

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

    private boolean isOperationNull(){
        return operationType == null;
    }

    @Override
    public double evaluate() {
        if(isOperationNull()){
            return value;
        }
        switch (operationType){
            case MODULE:
                return Math.abs(value);
            case SQRT:
                return Math.sqrt(value);
            default:
                return value;
        }
    }

    @Override
    public void addVariables(List<String> variables) {
        if(variable != null){
            variables.add(variable);
        }
    }

    @Override
    public List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        if(variable != null){
            variables.add(variable);
        }
        return variables;
    }

    @Override
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();

        if(!isOperationNull()) {
            if(operationType.equals(OperationType.MODULE)){
                if(variable != null) {
                    return stringBuilder.append("|").append(variable).append("|").toString();
                }else{
                    return stringBuilder.append("|").append((int) value).append("|").toString();
                }
            }else if(operationType.equals(OperationType.SQRT)){
                if(variable != null) {
                    return stringBuilder.append("√(").append(variable).append(")").toString();
                }else {
                    return stringBuilder.append("√(").append((int) value).append(")").toString();
                }
            }

        }else if(variable != null) {
            return stringBuilder.append(variable).toString();
        }
        return stringBuilder.append((int) value).toString();
    }

    @Override
    public boolean isComposed() {
        return false;
    }
}
