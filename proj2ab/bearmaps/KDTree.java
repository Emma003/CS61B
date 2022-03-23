package bearmaps;
import java.util.List;

public class KDTree implements PointSet {
    // Nested Node class
    private class Node implements Comparable<Node> {
        private Point p;
        private Node left;
        private Node right;
        private int depth;

        public Node (Point p, Node left, Node right) {
            this.p = p;
            this.left = left;
            this.right = right;
        }

        public int compareTo(Node other) {
            if (this.depth % 2 == 0) {
                return this.p.compareX(other.p);
            } else {
                 return this.p.compareY(other.p);
            }
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

    }

    private int size;
    private Node root;
    private int depth;

    public KDTree(List<Point> points) {
        // Create root node and set its depth to zero
        this.root = new Node(points.get(0), null, null);
        root.setDepth(0);

        // Add point nodes to the root
        this.depth = 0;
        for (int i = 1; i < points.size(); i++) {
            this.insert(points.get(i));
        }
    }

    private void insert(Point p) {
        // Create new node object with the new point
        Node newNode = new Node(p, null, null);
        traverse(root, newNode);

        // Update depth of current node then reset depth to zero
        newNode.setDepth(depth);
        depth = 0;
    }

    private Node traverse(Node curr, Node newNode) {
        // If the child is unoccupied, fill it
        if (curr == null) {
            return newNode;
        }

        // Compare and traverse left/right child depending on depth
        int cmp = curr.compareTo(newNode);
        if (cmp > 0) {
            depth += 1;
            curr.left = traverse(curr.left,newNode);
        } else if (cmp < 0) {
            depth += 1;
            curr.right = traverse(curr.right, newNode);
        } else {
            depth += 1;
            curr.right = traverse(curr.right, newNode);
        }

        return curr;
    }

    public int getSize() {
        return size;
    }

    public Point nearest(double x, double y) {
        return null;
    }

}
