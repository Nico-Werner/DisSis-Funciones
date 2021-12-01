package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.PrintVisitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        Variable one = new Variable(1);
        Variable six = new Variable(6);
        Function function = new FunctionBuilder(one, OperationType.SUM, six);

        PrintVisitor printVisitor = new PrintVisitor();
        function.accept(printVisitor);

        final String result = printVisitor.getPrint(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        Variable twelve = new Variable(12);
        Variable two = new Variable(2);
        Function function = new FunctionBuilder(twelve, OperationType.DIVIDE, two);

        PrintVisitor printVisitor = new PrintVisitor();
        function.accept(printVisitor);

        final String result = printVisitor.getPrint(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        Variable nine = new Variable(9);
        Variable two = new Variable(2);
        Variable three = new Variable(3);
        Function function = new FunctionBuilder(new FunctionBuilder(nine, OperationType.DIVIDE, two), OperationType.MULTIPLY, three);

        PrintVisitor printVisitor = new PrintVisitor();
        function.accept(printVisitor);

        final String result = printVisitor.getPrint(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        Variable twentySeven = new Variable(27);
        Variable six = new Variable(6);
        Variable two = new Variable(2);
        Function function = new FunctionBuilder(new FunctionBuilder(twentySeven, OperationType.DIVIDE, six), OperationType.POWER, two);

        PrintVisitor printVisitor = new PrintVisitor();
        function.accept(printVisitor);

        final String result = printVisitor.getPrint(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        Variable value = new Variable("value", 10, OperationType.MODULE);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(value, OperationType.SUBTRACT, eight);

        PrintVisitor printVisitor = new PrintVisitor();
        function.accept(printVisitor);

        final String result = printVisitor.getPrint(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        Variable value = new Variable("value", 10, OperationType.MODULE);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(value, OperationType.SUBTRACT, eight);

        PrintVisitor printVisitor = new PrintVisitor();
        function.accept(printVisitor);

        final String result = printVisitor.getPrint(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        Variable five = new Variable(5);
        Variable i = new Variable("i", 1);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(new FunctionBuilder(five, OperationType.SUBTRACT, i), OperationType.MULTIPLY, eight);

        PrintVisitor printVisitor = new PrintVisitor();
        function.accept(printVisitor);

        final String result = printVisitor.getPrint(function);

        assertThat(result, equalTo(expected));
    }
}
