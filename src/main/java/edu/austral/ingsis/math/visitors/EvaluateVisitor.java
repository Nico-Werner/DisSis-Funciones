package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionBuilder;
import edu.austral.ingsis.math.OperationType;
import edu.austral.ingsis.math.Variable;

import static edu.austral.ingsis.math.OperationType.MODULE;
import static edu.austral.ingsis.math.OperationType.SQRT;

public class EvaluateVisitor implements FunctionVisitor{

    private double result;

    @Override
    public void visitFunctionBuilder(FunctionBuilder functionBuilder) {
        OperationType operationType = functionBuilder.getOperationType();
        Function function1 = functionBuilder.getFunction1();
        Function function2 = functionBuilder.getFunction2();

        double functionResult = 0;

        switch (operationType) {
            case SUM:
                functionResult = getResult(function1) + getResult(function2);
                break;
            case SUBTRACT:
                functionResult = getResult(function1) - getResult(function2);
                break;
            case MULTIPLY:
                functionResult = getResult(function1) * getResult(function2);
                break;
            case DIVIDE:
                functionResult = getResult(function1) / getResult(function2);
                break;
            case POWER:
                functionResult = Math.pow(getResult(function1), getResult(function2));
                break;
            case SQRT:
                functionResult = Math.sqrt(functionResult);
                break;
            case MODULE:
                functionResult = Math.abs(functionResult);
                break;
        }
        result = functionResult;
    }

    @Override
    public void visitVariable(Variable variable) {
        double value = variable.getValue();
        OperationType operationType = variable.getOperationType();
        if(operationType == null){
            result = value;
            return;
        }
        switch (operationType){
            case MODULE:
                value = Math.abs(value);
                break;
            case SQRT:
                value = Math.sqrt(value);
                break;
        }
        result = value;
    }

    public double getResult(Function function){
        function.accept(this);
        return result;
    }
}
