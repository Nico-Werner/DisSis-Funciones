package edu.austral.ingsis.math;

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
        Function function = new FunctionBuilder(one, List.of(OperationType.SUM), six);
        final String result = function.print();

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
        Function function = new FunctionBuilder(twelve, List.of(OperationType.DIVIDE), two);
        final String result = function.print();

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
        Function function = new FunctionBuilder(new FunctionBuilder(nine, List.of(OperationType.DIVIDE), two), List.of(OperationType.MULTIPLY), three);
        final String result = function.print();

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
        Function function = new FunctionBuilder(new FunctionBuilder(twentySeven, List.of(OperationType.DIVIDE), six), List.of(OperationType.POWER), two);
        final String result = function.print();

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
        Function function = new FunctionBuilder(value, List.of(OperationType.SUBTRACT), eight);
        final String result = function.print();

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
        Function function = new FunctionBuilder(value, List.of(OperationType.SUBTRACT), eight);
        final String result = function.print();

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
        Function function = new FunctionBuilder(new FunctionBuilder(five, List.of(OperationType.SUBTRACT), i), List.of(OperationType.MULTIPLY), eight);
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }
}
