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
        sentinel = new IntNode(sentinel, 63, sentinel.p);
        size = 0;
    }
}