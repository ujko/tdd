package calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class CalcTestParametrized {

    Calculator calculator;

    @Parameter(0)
    public int a;
    @Parameter(1)
    public int b;
    @Parameter(2)
    public int expectedResult;

//    public CalcTestParametrized(int a, int b, int expectedResult) {
//        this.a = a;
//        this.b = b;
//        this.expectedResult = expectedResult;
//    }

    @Parameters(name = "{index}: {0} + {1} = {2}")
    public static Collection<? extends Object> parameters() {
        return Arrays.asList(new Object[][]{{2, 2, 4}, {7, 3, 10}, {100, 50, 150}, {99, 1, 100}});
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void add_test() {
        Assert.assertEquals(expectedResult, calculator.add(a, b));
    }
}
