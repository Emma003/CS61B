
public class NBody {

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Body[]bodies = readBodies(filename);

        StdDraw.setXscale(-3e11, 3e11);
        StdDraw.setYscale(-3e11, 3e11);

        StdDraw.enableDoubleBuffering();
        double time = 0.0;

        while(time <= T) {
            double[]xForces = new double[bodies.length];
            double[]yForces = new double[bodies.length];

            for(int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for(int i = 0; i < bodies.length; i++) {
                bodies[i].update(time, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(Body body: bodies) {
                body.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        } 

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                        bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }

        // This block would do the same printing without the right sig figs
        /*System.out.println(bodies.length);
        System.out.println(radius);
        for(Body body: bodies) {
            System.out.print(body.xxPos + " ");
            System.out.print(body.yyPos + " ");
            System.out.print(body.xxVel + " ");
            System.out.print(body.yyVel + " ");
            System.out.print(body.mass + " ");
            System.out.print(body.imgFileName); 
            System.out.println("");
        }*/
    }
    
    public static double readRadius(String file) {
        In in = new In(file);

        int numberOfPlanets = in.readInt();
        double radiusOfUniverse = in.readDouble();

        return radiusOfUniverse;
    }

    public static Body[] readBodies(String file) {
        In in = new In(file);

        int numberOfPlanets = in.readInt();
        double radiusOfUniverse = in.readDouble();

        Body[]allBodies = new Body[numberOfPlanets];

        for(int i = 0; i < numberOfPlanets; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();

            Body newBody = new Body(xP, yP, xV, yV, m, img);
            allBodies[i] = newBody;
        }

        return allBodies;
    }

}
