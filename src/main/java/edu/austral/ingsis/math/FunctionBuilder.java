package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.FunctionVisitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionBuilder implements Function {

    private OperationType operationType;
    private Function function1;
    private Function function2;

    public FunctionBuilder(Function function1, OperationType operationType,  Function function2) {
        this.operationType = operationType;
        this.function1 = function1;
        this.function2 = function2;
    }

    public Function getFunction1() {
        return function1;
    }

    public Function getFunction2() {
        return function2;
    }

    public OperationType getOperationType() {
        return operationType;
    }
    @Override
    public boolean isComposed() {
        return true;
    }

    @Override
    public void accept(FunctionVisitor functionVisitor) {
        functionVisitor.visitFunctionBuilder(this);
    }
}
