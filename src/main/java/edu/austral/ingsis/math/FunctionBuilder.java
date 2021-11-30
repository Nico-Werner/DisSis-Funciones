package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;

public class FunctionBuilder implements Function {

    private List<OperationType> operationTypes;
    private Function function1;
    private Function function2;

    public FunctionBuilder(Function function1, List<OperationType> operationTypes,  Function function2) {
        this.operationTypes = operationTypes;
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double evaluate() {
        double result = 0;
        for (OperationType operationType : operationTypes) {
            switch (operationType) {
                case SUM:
                    result = function1.evaluate() + function2.evaluate();
                    break;
                case SUBTRACT:
                    result = function1.evaluate() - function2.evaluate();
                    break;
                case MULTIPLY:
                    result = function1.evaluate() * function2.evaluate();
                    break;
                case DIVIDE:
                    result = function1.evaluate() / function2.evaluate();
                    break;
                case POWER:
                    result = Math.pow(function1.evaluate(), function2.evaluate());
                    break;
                case SQRT:
                    result = Math.sqrt(result);
                    break;
                case MODULE:
                    result = Math.abs(result);
                    break;
            }
        }
        return result;
    }

    @Override
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        if(function1.isComposed()) {
            stringBuilder.append("(");
        }
        stringBuilder.append(function1.print());
        if(function1.isComposed()) {
            stringBuilder.append(")");
        }
        for (OperationType operationType : operationTypes) {
            switch (operationType) {
                case SUM:
                    stringBuilder.append(" + ");
                    break;
                case SUBTRACT:
                    stringBuilder.append(" - ");
                    break;
                case MULTIPLY:
                    stringBuilder.append(" * ");
                    break;
                case DIVIDE:
                    stringBuilder.append(" / ");
                    break;
                case POWER:
                    stringBuilder.append(" ^ ");
                    break;
                case SQRT:
                    stringBuilder.append(" sqrt ");
                    break;
                case MODULE:
                    stringBuilder.append(" abs ");
                    break;
            }
            if(function2.isComposed()) {
                stringBuilder.append("(");
            }
            stringBuilder.append(function2.print());
            if(function2.isComposed()) {
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void addVariables(List<String> variables){
        function1.addVariables(variables);
        function2.addVariables(variables);
    }

    @Override
    public List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        function1.addVariables(variables);
        function2.addVariables(variables);
        return variables;
    }

    @Override
    public boolean isComposed() {
        return true;
    }
}
