package bearmaps.proj2c;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AStarSolver<Vertex> implements ShortestPathsSolver<Vertex> {
    private SolverOutcome outcome;
    private double solutionWeight;
    private List<Vertex> solution;
    private double timeSpent;
    private Map<Vertex, Double> distTo;
    private Map<Vertex, Vertex> edgeTo;
    private double estimatedDistanceToGoal;
    private int numStatesExplored;

    public AStarSolver(AStarGraph<Vertex> input, Vertex start, Vertex end, double timeout) {

        this.solution = new ArrayList<>();
        this.distTo = new HashMap<>();
        this.edgeTo = new HashMap<>();
        this.numStatesExplored = 0;

        // Initialize fringe PQ
        DoubleMapPQ<Vertex> fringe = new DoubleMapPQ();

        // Add the start vertex to the fringe and set its distTo and edgeTo values to 0 and -1 respectively
        this.estimatedDistanceToGoal = input.estimatedDistanceToGoal(start, end);
        fringe.add(start, estimatedDistanceToGoal);
        distTo.put(start, 0.0);
        edgeTo.put(start, null);

        // Start timer
        Stopwatch sw = new Stopwatch();

        // Traverse graph and update fringe
        while (fringe.size() != 0) {

            // Goal is found
            if (fringe.getSmallest().equals(end)) {
                // Add last vertex to solution list
                Vertex v = fringe.getSmallest();
                solution.add(0, v);

                // Get priority of last vertex to goal (weight of whole path)
                while (!v.equals(start)) {
                    v = edgeTo.get(v);
                    solution.add(0, v);
                }
                this.solutionWeight = distTo.get(v);
                this.timeSpent = sw.elapsedTime();
                this.outcome = SolverOutcome.SOLVED;
                return;
            }

            // Check if time ran out
            if (sw.elapsedTime() > timeout) {
                this.outcome = SolverOutcome.TIMEOUT;
                this.timeSpent = sw.elapsedTime();
                solution.clear();
                solutionWeight = 0;
                return;
            }

            // Dequeue best vertex from PQ and update number of operations
            Vertex v = fringe.removeSmallest();
            this.numStatesExplored++;


            /**
             * TODO: there's a slight logical issue with setting the distTo values as inf, FIX IT!!
             */
            // Relax all edges from current vertex
            for (WeightedEdge<Vertex> e : input.neighbors(v)) {
                Vertex from = e.from();
                Vertex to = e.to();
                double weight = e.weight();
                estimatedDistanceToGoal = input.estimatedDistanceToGoal(to, end);

                if (!distTo.containsKey(to) || distTo.get(from) + weight < distTo.get(to)) {
                    edgeTo.put(to, from);
                    distTo.put(to, (distTo.get(from) + weight));
                    if (fringe.contains(to)) {
                        fringe.changePriority(to, distTo.get(to) + estimatedDistanceToGoal);
                    } else {
                        fringe.add(to, distTo.get(to) + estimatedDistanceToGoal);
                    }
                }

            }
        }

        this.timeSpent = sw.elapsedTime();
        outcome = SolverOutcome.UNSOLVABLE;
        solution.clear();
        solutionWeight = 0;
    }

    /**
     * Returns SolverOutcome enum value
     * @return
     */
    @Override
    public SolverOutcome outcome() {
        return outcome;
    }

    /**
     * Returns list of vertices corresponding to a solution. Empty if result is TIMEOUT or UNSOLVABLE.
     * @return
     */
    @Override
    public List<Vertex> solution() {
        return solution;
    }

    /**
     * Returns total weight of a given solution, taking into account edge weights. 0 if result is TIMEOUT or UNSOLVABLE.
     * @return
     */
    @Override
    public double solutionWeight() {
        return solutionWeight;
    }

    /**
     * Returns total number of PQ dequeue operations
     * @return
     */
    @Override
    public int numStatesExplored() {
        return numStatesExplored;
    }

    /**
     * Returns total time spent in seconds by the constructor.
     * @return
     */
    @Override
    public double explorationTime() {
        return 0.0;
    }
}
