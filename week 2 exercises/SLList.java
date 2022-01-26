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
