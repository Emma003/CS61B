import static org.junit.Assert.*;
import org.junit.Test;

public class TestSort {

    // Tests the sort method of Sort.java
    @Test
    public void testSort() {
        String[]input = {"i", "am"};
        String[]expected = {"i", "am"};
        Sort.sort(input);
        assertArrayEquals(expected,input);
    }

}
