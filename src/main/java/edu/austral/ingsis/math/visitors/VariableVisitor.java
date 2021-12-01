package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.FunctionBuilder;
import edu.austral.ingsis.math.Variable;

import java.util.ArrayList;
import java.util.List;

public class VariableVisitor implements FunctionVisitor{

    List<String> result = new ArrayList<>();

    @Override
    public void visitFunctionBuilder(FunctionBuilder functionBuilder) {
        functionBuilder.getFunction1().accept(this);
        functionBuilder.getFunction2().accept(this);
    }

    @Override
    public void visitVariable(Variable variable) {
        if (variable.getVariable() != null) {
            result.add(variable.getVariable());
        }
    }

    public List<String> getResult(){
        return result;
    }
}
