package calc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void shouldBeSumOfAAndB() {
        int res = calculator.add(3, 5);
        assertEquals(8, res);
    }

    @Test
    public void shouldBeArithmeticException() {
        try {
            calculator.add(Integer.MAX_VALUE, 5);
            fail("Should be ArithmeticException");
        } catch (ArithmeticException e) {
        }
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeArithmeticException1() {
        calculator.add(Integer.MAX_VALUE, 5);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeArithmeticException2() {
        calculator.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeArithmeticException3() {
        calculator.add(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Test
    public void shouldAddMinu() {
        int res = calculator.add(-6, -3);
        assertEquals(-9, res);
    }

    @Test
    public void shouldBeZero() {
        int res = calculator.add(0, 0);
        assertEquals(0, res);
    }

    @Test
    public void shouldBeZero_test1() {
        int res = calculator.add(-2, 2);
        assertEquals(0, res);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeZero_test2() {
        calculator.add(Integer.MIN_VALUE, -(Integer.MIN_VALUE));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testDivShouldBeIllegalArgumentException() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Nie dziel przez zero");
    calculator.div(4.6, 0.0);
}

    @Test
    public void testDivShouldBeDivided() {
        assertEquals(8.0, calculator.div(16.0,2.0), 0.0001);
    }
    @Test
    public void shoulBeZero() {
        assertEquals(0, calculator.add(Integer.MAX_VALUE, -Integer.MAX_VALUE));
    }
}