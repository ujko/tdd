package fibonacci;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FibonacciTest2 {

    Fibonacci fibonacci;

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @Test
    @Parameters({"0,0", "1,1", "2,1", "3,2", "4,3", "5,5", "6,8", "7,13", "8,21"})
    public void fibonacci_test(int income, int outcome) {
        assertEquals(outcome, fibonacci.doFibonacci(income));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentException() {
        fibonacci.doFibonacci(-10);
    }

}