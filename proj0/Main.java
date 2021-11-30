public class Main {
    public static void main(String[] args) {

        Body b1 = new Body(1.0, 0.0, -999, -999, 7e5, "samh.gif");
        Body b2 = new Body(3.0, 3.0, -999, -999, 8e5, "aegir.gif");
        Body b3 = new Body(5.0, -3.0, -999, -999, 9e6, "rocinante.gif");
        Body[] allBodys = {b1, b2, b3};

        System.out.println(b1.calcNetForceExertedByY(allBodys));
    }
}
