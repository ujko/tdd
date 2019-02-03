package newTest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)

public class BinaryTest {
    Binary binary;

    @Test
    @Parameters({"0,0", "1,1", "5,101"})
    public void method(int a, String b) {
        assertEquals(b, binary.method(a));

    }

    @Before
    public void setUp() {
        binary = new Binary();

    }

    @Test(expected = IllegalArgumentException.class)
    public void method2() {
        binary.method(-1);
    }

    @Test
    @Parameters({"100, 0", "101, 1 ", "1001, 2", "000001000100, 3", "10110010000, 2"})
    public void binaryZero_test(String a, int result) {
        assertEquals(result, binary.binaryZero(a));
    }
    @Test
    @Parameters({"4, 0", "5, 1 ", "9, 2", "68, 3"})     // test integracyjny
    public void binaryZero_test1(int a, int result) {
        int res = binary.binaryZero(binary.method(a));
        Assert.assertEquals(result, res);
    }
}