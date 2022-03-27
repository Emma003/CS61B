
public class IntList {
    public int first;
    public IntList rest;

    // Initializes IntList
    public IntList(int f, IntList r) {
            this.first = f;
            this.rest = r;
    }

    // Returns size of list using recursion
    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    // Returns size of list using iteration
    public int iterativeSize() {
        IntList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.rest;
        }
        return size;
    }

    // Returns the element given the index using iteration
    public int iterativeGet(int index) {
        IntList p = this;
        for (int i = 0; i < index; i++) {
            p = p.rest;
        }
        return p.first;
    }

    // Returns IntList identical to L, but with values incremented by x, values in L cannot change
    public static IntList incrList(IntList L, int x) {
        IntList Q = new IntList(L.iterativeGet(L.size() -1) + x, null);

        for (int i = L.size() -2; i >= 0; i--) {
            Q = new IntList(L.get(i) + x, Q);
        }
        return Q;

    }
    
    // Returns IntList identical to L, but with values incremented by x, changes values of L
    public static IntList dincrList(IntList L, int x) {
        for (int i = 0; i < L.size(); i++) {
            L.first = L.first + x;
            L = L.rest;
        }
        return L;
    }

    // Returns the ith item using recursion
    public int get(int index) {
        if (index == 0) {
            return this.first;
        }
        return this.rest.get(index - 1);
    }

    public static void main(String[] args) {

        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        IntList Q = L.incrList(L, 3);
        System.out.println(Q.iterativeGet(0));
        System.out.println(L.iterativeGet(0));

    }
}