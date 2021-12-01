package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionBuilder;
import edu.austral.ingsis.math.OperationType;
import edu.austral.ingsis.math.Variable;

public class PrintVisitor implements FunctionVisitor{

    String print;

    @Override
    public void visitFunctionBuilder(FunctionBuilder functionBuilder) {
        Function function1 = functionBuilder.getFunction1();
        Function function2 = functionBuilder.getFunction2();
        OperationType operationType = functionBuilder.getOperationType();
        StringBuilder stringBuilder = new StringBuilder();
        if (function1.isComposed()) {
            stringBuilder.append("(");
        }
        stringBuilder.append(getPrint(function1));
        if (function1.isComposed()) {
            stringBuilder.append(")");
        }
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
        if (function2.isComposed()) {
            stringBuilder.append("(");
        }
        stringBuilder.append(getPrint(function2));
        if (function2.isComposed()) {
            stringBuilder.append(")");
        }
        print = stringBuilder.toString();
    }

    @Override
    public void visitVariable(Variable variable) {
        double value = variable.getValue();
        OperationType operationType = variable.getOperationType();
        StringBuilder stringBuilder = new StringBuilder();
        String variableName = variable.getVariable();

        if(operationType != null){
            if(operationType.equals(OperationType.MODULE)){
                if(variableName != null) {
                    print = stringBuilder.append("|").append(variableName).append("|").toString();
                    return;
                }else{
                    print = stringBuilder.append("|").append((int) value).append("|").toString();
                    return;
                }
            }else if(operationType.equals(OperationType.SQRT)){
                if(variableName != null) {
                    print = stringBuilder.append("√(").append(variableName).append(")").toString();
                    return;
                }else {
                    print = stringBuilder.append("√(").append((int) value).append(")").toString();
                    return;
                }
            }

        }else if(variableName != null) {
            print = stringBuilder.append(variableName).toString();
            return;
        }
        print = stringBuilder.append((int) value).toString();
    }

    public String getPrint(Function function){
        function.accept(this);
        return print;
    }
}
