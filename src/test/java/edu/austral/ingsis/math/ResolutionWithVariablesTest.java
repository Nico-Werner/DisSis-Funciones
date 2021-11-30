package edu.austral.ingsis.math;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Variable one = new Variable(1);
        Variable x = new Variable("x", 3);
        Function function = new FunctionBuilder(one, List.of(OperationType.SUM), x);
        final Double result = function.evaluate();

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Variable twelve = new Variable(12);
        Variable div = new Variable("div", 4);
        Function function = new FunctionBuilder(twelve, List.of(OperationType.DIVIDE), div);
        final Double result = function.evaluate();

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Variable nine = new Variable(9);
        Variable x = new Variable("x", 3);
        Variable y = new Variable("y", 4);
        Function function = new FunctionBuilder(new FunctionBuilder(nine, List.of(OperationType.DIVIDE), x), List.of(OperationType.MULTIPLY), y);
        final Double result = function.evaluate();

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Variable a = new Variable("a", 9);
        Variable b = new Variable("b", 3);
        Function function = new FunctionBuilder(new FunctionBuilder(new Variable(27), List.of(OperationType.DIVIDE), a), List.of(OperationType.POWER), b);
        final Double result = function.evaluate();

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Variable z = new Variable("z", 36);
        Variable one = new Variable(1);
        Variable two = new Variable(2);
        Function function = new FunctionBuilder(z, List.of(OperationType.POWER), new FunctionBuilder(one, List.of(OperationType.DIVIDE), two));
        final Double result = function.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Variable value = new Variable("value", 8, OperationType.MODULE);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(value, List.of(OperationType.SUBTRACT), eight);
        final Double result = function.evaluate();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Variable value = new Variable("value", 8, OperationType.MODULE);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(value, List.of(OperationType.SUBTRACT), eight);
        final Double result = function.evaluate();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Variable five = new Variable(5);
        Variable i = new Variable("i", 2);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(new FunctionBuilder(five, List.of(OperationType.SUBTRACT), i), List.of(OperationType.MULTIPLY), eight);
        final Double result = 24d;

        assertThat(result, equalTo(24d));
    }
}
