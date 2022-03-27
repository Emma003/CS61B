package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayHeapMinPQTest {

    public static void main(String[] args) {
        ArrayHeapMinPQ<String> heap = new ArrayHeapMinPQ();

        heap.add("w", 6);
        heap.add("a", 2);
        heap.add("i", 4);
        heap.add("v", 5);
        heap.add("e", 1);
        heap.add("r", 3);

        heap.changePriority("w", 1.5);
        System.out.println(heap.getSmallest());
        heap.removeSmallest();
        heap.getSmallest();
    }

    @Test
    public void getSmallestTest() {
        NaiveMinPQ<String> naive = new NaiveMinPQ();
        ArrayHeapMinPQ<String> heap = new ArrayHeapMinPQ();

        naive.add("w", 6);
        naive.add("a", 2);
        naive.add("i", 4);
        naive.add("v", 5);
        naive.add("e", 1);
        naive.add("r", 3);

        heap.add("w", 6);
        heap.add("a", 2);
        heap.add("i", 4);
        heap.add("v", 5);
        heap.add("e", 1);
        heap.add("r", 3);

        assertEquals(naive.getSmallest(), heap.getSmallest());
    }

    @Test
    public void removeSmallestTest() {
        NaiveMinPQ<String> naive = new NaiveMinPQ();
        ArrayHeapMinPQ<String> heap = new ArrayHeapMinPQ();

        naive.add("w", 6);
        naive.add("a", 2);
        naive.add("i", 4);
        naive.add("v", 5);
        naive.add("e", 1);
        naive.add("r", 3);

        heap.add("w", 6);
        heap.add("a", 2);
        heap.add("i", 4);
        heap.add("v", 5);
        heap.add("e", 1);
        heap.add("r", 3);

        assertEquals(naive.removeSmallest(), heap.removeSmallest());
        assertEquals(naive.removeSmallest(), heap.removeSmallest());
        assertEquals(naive.removeSmallest(), heap.removeSmallest());
        assertEquals(naive.removeSmallest(), heap.removeSmallest());
        assertEquals(naive.removeSmallest(), heap.removeSmallest());
        assertEquals(naive.removeSmallest(), heap.removeSmallest());
    }

    @Test
    public void containsTest() {
        NaiveMinPQ<String> naive = new NaiveMinPQ();
        ArrayHeapMinPQ<String> heap = new ArrayHeapMinPQ();

        naive.add("w", 6);
        naive.add("a", 2);
        naive.add("i", 4);
        naive.add("v", 5);
        naive.add("e", 1);
        naive.add("r", 3);

        heap.add("w", 6);
        heap.add("a", 2);
        heap.add("i", 4);
        heap.add("v", 5);
        heap.add("e", 1);
        heap.add("r", 3);

        assertEquals(naive.contains("v"), heap.contains("v"));
        assertEquals(naive.contains("2"), heap.contains("2"));
        assertEquals(naive.contains("e"), heap.contains("e"));
        naive.removeSmallest();
        heap.removeSmallest();
        assertEquals(naive.contains("e"), heap.contains("e"));
        assertEquals(naive.contains("i"), heap.contains("i"));
        assertEquals(naive.contains("a"), heap.contains("a"));
    }

    @Test
    public void changePriorityTest() {
        NaiveMinPQ<String> naive = new NaiveMinPQ();
        ArrayHeapMinPQ<String> heap = new ArrayHeapMinPQ();

        naive.add("w", 6);
        naive.add("a", 2);
        naive.add("i", 4);
        naive.add("v", 5);
        naive.add("e", 1);
        naive.add("r", 3);

        heap.add("w", 6);
        heap.add("a", 2);
        heap.add("i", 4);
        heap.add("v", 5);
        heap.add("e", 1);
        heap.add("r", 3);

        assertEquals(naive.getSmallest(), heap.getSmallest());
        naive.changePriority("w", 1.5);
        naive.changePriority("w", 1.5);
        assertEquals(naive.getSmallest(), heap.getSmallest());
        naive.removeSmallest();
        heap.removeSmallest();
        assertEquals(naive.contains("e"), heap.contains("e"));
        assertEquals(naive.getSmallest(), heap.getSmallest());
        naive.changePriority("w", 4.5);
        naive.changePriority("w", 4.5);
        assertEquals(naive.getSmallest(), heap.getSmallest());
    }
}
