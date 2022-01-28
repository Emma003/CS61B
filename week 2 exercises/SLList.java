//import SLList.IntNode;

public class SLList {

    // Nested class
    private static class IntNode {
        public int item;
        public IntNode next;
    
        // Initializes IntNode
        public IntNode(int i, IntNode n) {
                this.item = i;
                this.next = n;
        }
    }

    // The first item that exists is at sentinel.next
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[]array) {
        sentinel = new IntNode(0, null);
        size = 0;
        for(int i = 0; i < array.length; i++) {
            addLast(array[i]);
        }
        
    }

    // If 2 numbers in a row are the  same, we add them together and make one large node
    public void addAdjacent() {
        IntNode pFlag = sentinel;
        IntNode p1 = sentinel.next;
        IntNode p2 = sentinel.next.next;

        while (p2 != null){
            if (p1.item == p2.item){
                p2.item += p1.item;
                pFlag.next = p2;
                size--;
            } else {
                pFlag = pFlag.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    }

    // Adds x to the front of the list
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    //Returns the first item in the list
    public int getFirst() {
        return sentinel.next.item;
    }

    // Adds an item to the end of the list
    public void addLast(int x) {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size++;

    }

    // Every time you add a value you “square” the IntList
    public void squareAddLast(int x) {
        if (size() <= 1) {
            sentinel.next.next = new IntNode(sentinel.next.item*sentinel.next.item, null);
        } else {
            IntNode p1 = sentinel.next;
            IntNode p2 = sentinel.next.next;

            while(p1 != null) {
                p1.next = new IntNode(p1.item*p1.item, p2);
                size++;
                p1 = p2;
                if (p1 == null) {
                    break;
                }
                p2 = p2.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public void deleteFirst() {
        if (sentinel.next.next != null) {
            IntNode p = sentinel.next.next;
            sentinel.next = p;
        } else {
            sentinel.next = null;
        }
        size--;
        
    }

    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3,4};
        SLList A = new SLList(nums);
        //A.addAdjacent();
        A.squareAddLast(5);
        System.out.println(A.size());

        /*
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst()); 
        L.deleteFirst();
        System.out.println(L.getFirst());
        */
    }

}






/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		/*
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
		*/
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		/*
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
		*/
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 
