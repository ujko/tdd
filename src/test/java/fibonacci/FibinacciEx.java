package fibonacci;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

public class FibinacciEx {

    Fibonacci fibonacci;

    @Before
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void schouldBeException() {
        try {
            fibonacci.doFibonacci(-5);
            fail("Should be Illegal Argument Exception");
        } catch(IllegalArgumentException e){
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeException2(){
        fibonacci.doFibonacci(-8);
    }
    @Rule
    public ExpectedException exepszon = ExpectedException.none();

    @Test
    public void shouldBeException3(){
        exepszon.expectMessage("LIczba powinna być dodatnia");
        exepszon.expect(IllegalArgumentException.class);
        fibonacci.doFibonacci(-10);
    }

}
