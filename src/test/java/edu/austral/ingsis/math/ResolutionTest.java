package edu.austral.ingsis.math;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Variable one = new Variable(1);
        Variable six = new Variable(6);
        Function function = new FunctionBuilder(one, List.of(OperationType.SUM), six);
        final Double result = function.evaluate();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Variable twelve = new Variable(12);
        Variable two = new Variable(2);
        Function function = new FunctionBuilder(twelve, List.of(OperationType.DIVIDE), two);
        final Double result = function.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Variable nine = new Variable(9);
        Variable two = new Variable(2);
        Variable three = new Variable(3);
        Function function = new FunctionBuilder(new FunctionBuilder(nine, List.of(OperationType.DIVIDE), two), List.of(OperationType.MULTIPLY), three);
        final Double result = function.evaluate();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Variable twentySeven = new Variable(27);
        Variable six = new Variable(6);
        Variable two = new Variable(2);
        Function function = new FunctionBuilder(new FunctionBuilder(twentySeven, List.of(OperationType.DIVIDE), six), List.of(OperationType.POWER), two);
        final Double result = function.evaluate();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Variable threeSix = new Variable(36);
        Variable one = new Variable(1);
        Variable two = new Variable(2);
        Function function = new FunctionBuilder(threeSix, List.of(OperationType.POWER), new FunctionBuilder(one, List.of(OperationType.DIVIDE), two));
        final Double result = function.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Variable oneThirtySix = new Variable("a", 136, OperationType.MODULE);
        Function function = oneThirtySix;
        final Double result = function.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Variable oneThirtySix = new Variable("a", -136, OperationType.MODULE);
        Function function = oneThirtySix;
        final Double result = function.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Variable five = new Variable(5);
        Variable eight = new Variable(8);
        Function function = new FunctionBuilder(new FunctionBuilder(five, List.of(OperationType.SUBTRACT), five), List.of(OperationType.MULTIPLY), eight);
        final Double result = function.evaluate();

        assertThat(result, equalTo(0d));
    }
}
