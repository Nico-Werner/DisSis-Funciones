package edu.austral.ingsis.math;

public enum OperationType {
    SUM,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    POWER,
    SQRT,
    MODULE;

    public static OperationType getOperationType(String operation) {
        if (operation.equals("+")) {
            return OperationType.SUM;
        } else if (operation.equals("-")) {
            return OperationType.SUBTRACT;
        } else if (operation.equals("*")) {
            return OperationType.MULTIPLY;
        } else if (operation.equals("/")) {
            return OperationType.DIVIDE;
        } else if (operation.equals("^")) {
            return OperationType.POWER;
        } else if (operation.equals("sqrt")) {
            return OperationType.SQRT;
        } else if (operation.equals("%")) {
            return OperationType.MODULE;
        } else {
            return null;
        }
    }
}
