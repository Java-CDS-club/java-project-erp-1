import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SieveTest {
    private static Sieve sieve = new Sieve();

    @Test
    public void test1() {
        int[] y = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
        assertEquals(sieve.findPrime(100), y);
    }

    @Test
    public void test2() {
        fail("Test failed");

    }
}
