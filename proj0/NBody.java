public class NBody {

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[]bodies = readBodies(filename);
        System.out.println(bodies[4].imgFileName);

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
