package edu.austral.ingsis.math;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Variable one = new Variable(1);
        Variable six = new Variable(6);
        Function function = new FunctionBuilder(one, List.of(OperationType.SUM), six);
        final List<String> result = function.getVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Variable twelve = new Variable(12);
        Variable div = new Variable("div", 3);
        Function function = new FunctionBuilder(twelve, List.of(OperationType.DIVIDE), div);
        final List<String> result = function.getVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Variable nine = new Variable(9);
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Function function = new FunctionBuilder(new FunctionBuilder(nine, List.of(OperationType.DIVIDE), x), List.of(OperationType.MULTIPLY), y);
        final List<String> result = function.getVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Variable a = new Variable("a", 3);
        Variable b = new Variable("b", 2);
        Variable twentySeven = new Variable(27);
        Function function = new FunctionBuilder(new FunctionBuilder(twentySeven, List.of(OperationType.DIVIDE), a), List.of(OperationType.POWER), b);
        final List<String> result = function.getVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Variable z = new Variable("z", 4);
        Function function = new FunctionBuilder(z, List.of(OperationType.POWER), new FunctionBuilder(new Variable(1), List.of(OperationType.DIVIDE), new Variable(2)));
        final List<String> result = function.getVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Variable value = new Variable("value", 7, OperationType.MODULE);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(value, List.of(OperationType.SUBTRACT), eight);
        final List<String> result = function.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Variable value = new Variable("value", 7, OperationType.MODULE);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(value, List.of(OperationType.SUBTRACT), eight);
        final List<String> result = function.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Variable i = new Variable("i", 1);
        Variable five = new Variable(5);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(new FunctionBuilder(five, List.of(OperationType.SUBTRACT), i), List.of(OperationType.MULTIPLY), eight);
        final List<String> result = function.getVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
