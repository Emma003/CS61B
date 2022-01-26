public class LinkedListDeque {
    public static class IntNode {
        private int item;
        private IntNode previous;
        private IntNode next;

        public IntNode(IntNode p, int i, IntNode n) {
            this.item = i;
            this.previous = p;
            this.next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(sentinel, 63, sentinel.previous);
        size = 0;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        //LinkedListDeque L = new LinkedListDeque();
        System.out.println("hello");
    }
}