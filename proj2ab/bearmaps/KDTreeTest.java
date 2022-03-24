package bearmaps;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KDTreeTest {
    public static void main (String[] args) {
        Point A = new Point(2, 3); // constructs a Point with x = 2, y = 3
        Point B = new Point(4, 2);
        Point C = new Point(4, 5);
        Point D = new Point(3,3);
        Point E = new Point(1,5);
        Point F = new Point(4,4);

        KDTree kd = new KDTree(List.of(A,B,C,D,E,F));
        NaivePointSet ns = new NaivePointSet(List.of(A,B,C,D,E,F));
        Point naiveFind = ns.nearest(0, 7); // returns p2
        Point kdFind = kd.nearest(0,7);
        System.out.println(naiveFind.toString());
        System.out.println(kdFind.toString());
    }




    @Test
    public void randomizedNearestTest() {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            int randomX = StdRandom.uniform(-1000, 1000);
            int randomY = StdRandom.uniform(-1000, 1000);
            Point p = new Point(randomX, randomY);
            points.add(p);
        }

        KDTree kd = new KDTree(points);
        NaivePointSet ns = new NaivePointSet(points);

        for (int i = 0; i < 300; i++) {
            int randomX = StdRandom.uniform(-1000, 1000);
            int randomY = StdRandom.uniform(-1000, 1000);
            Point nsNearest = ns.nearest(randomX,randomY);
            Point kdNearest = kd.nearest(randomX,randomY);
            String error = "NaivePointSet found " + nsNearest.toString() + " to be the nearest point whereas KDTree found " + kdNearest.toString();
            assertEquals(error, nsNearest, kdNearest);

        }
    }
}
