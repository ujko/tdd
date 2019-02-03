import org.junit.*;

public class TestJUnit {

    /**
     * Given
     * when
     * then
     */


    @BeforeClass
    public static void setUpAll() {
        System.out.println("Startuje najpierw");
    }

    @Before
    public void setUpMethod() {
        System.out.println("Startuje przed kazdym testem");
    }

    @AfterClass
    public static void closeAll() {
        System.out.println("Koncze testy");
    }

    @After
    public void closeMethod() {
        System.out.println("Uruchamiam po kazdym tescie");
    }

    @Test
    public void test1() {
        System.out.println("To jest pierwszy test");
    }

    @Test
    public void test2() {
        System.out.println("To jest drugi test");
    }
    @Test
    public void test3() {
        System.out.println("To jest trzeci test");
    }
}
