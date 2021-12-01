package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.FunctionVisitor;


public interface Function {

    boolean isComposed();

    void accept(FunctionVisitor visitor);

}
