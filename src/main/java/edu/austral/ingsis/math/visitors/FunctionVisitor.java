package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.FunctionBuilder;
import edu.austral.ingsis.math.Variable;

public interface FunctionVisitor {
    void visitFunctionBuilder(FunctionBuilder functionBuilder);
    void visitVariable(Variable variable);
}
