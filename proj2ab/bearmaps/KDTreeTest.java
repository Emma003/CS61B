package bearmaps;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class KDTreeTest {
    public static void main(String[] args) {
        Point A = new Point(2, 3); // constructs a Point with x = 2, y = 3
        Point B = new Point(4, 2);
        Point C = new Point(4, 5);
        Point D = new Point(3,3);
        Point E = new Point(1,5);
        Point F = new Point(4,4);

        KDTree nn = new KDTree(List.of(A, B, C, D, E, F));
//        Point ret = nn.nearest(3.0, 4.0); // returns p2
//        ret.getX(); // evaluates to 3.3
//        ret.getY(); // evaluates to 4.4
//        System.out.println(ret.toString());
    }
}
