package uq.deco2800.ducktales.util;

import uq.deco2800.ducktales.world.WorldBeta;

import java.util.*;

/**
 * This is a path-finding algorithm for the game. This algorithm takes in a start point,
 * an end point and construct the shortest path to that point.
 *
 * This class is originally Leggy's but altered to work with the Beta version of
 * the game
 *
 * Created on 4/09/2016 by Khoi, based 90% on Leggy's AStar Class
 * @author Leggy
 */
public class AStarBeta {
    public static List<AStar.Tuple> aStar(Point startPoint, Point goalPoint, WorldBeta world) {

        AStar.Tuple start = new AStar.Tuple(startPoint);
        AStar.Tuple goal = new AStar.Tuple(goalPoint);
        // Set of points already evaluated

        Set<AStar.Tuple> closedSet = new HashSet<AStar.Tuple>();

        // Set of discovered nodes yet to be evaluated
        Set<AStar.Tuple> openSet = new HashSet<AStar.Tuple>();
        openSet.add(start);

        // Most efficient path to a node
        Map<AStar.Tuple, AStar.Tuple> cameFrom = new HashMap<AStar.Tuple, AStar.Tuple>();

        // Cost of getting to node
        Map<AStar.Tuple, Integer> gScore = new HashMap<AStar.Tuple, Integer>();

        gScore.put(start, 0);

		/*
		 * For each node, the total cost of getting from the start node to the
		 * goal by passing by that node. That value is partly known, partly
		 * heuristic.
		 */
        Map<AStar.Tuple, Double> fScore = new HashMap<AStar.Tuple, Double>();

        fScore.put(start, heuristicCostEstimate(start, goal));

        while (!openSet.isEmpty()) {
            AStar.Tuple current = getMinTuple(openSet, fScore);

            if (current.equals(goal)) {
                return reconstructPath(cameFrom, current);
            }
            openSet.remove(current);
            closedSet.add(current);

            for (AStar.Tuple tuple : getAdjacentNodes(current, world)) {
                if (closedSet.contains(tuple) || !world.getTile(tuple.x, tuple.y).isPassable()) {
                    continue;
                }

                // gScore default value is infinite, distance from current to
                // neighbour = 1
                int tentativeGScore = gScore.getOrDefault(current, Integer.MAX_VALUE / 2) + 1;

                if (!openSet.contains(tuple)) {
                    openSet.add(tuple);
                } else if (tentativeGScore >= gScore.getOrDefault(tuple, Integer.MAX_VALUE / 2)) {
                    continue;
                }

                // This path is the best so far
                cameFrom.put(tuple, current);
                gScore.put(tuple, tentativeGScore);
                fScore.put(tuple, gScore.get(tuple) + heuristicCostEstimate(tuple, goal));
            }
        }
        return null;
    }

    private static AStar.Tuple getMinTuple(Set<AStar.Tuple> tuples, Map<AStar.Tuple, Double> fScores) {
        double minF = Integer.MAX_VALUE;
        AStar.Tuple min = null;

        for (AStar.Tuple tuple : tuples) {
            double tupleFScore = fScores.getOrDefault(tuple, Double.MAX_VALUE / 2);
            if (tupleFScore < minF) {
                minF = tupleFScore;
                min = tuple;
            }
        }

        return min;
    }

    private static double heuristicCostEstimate(AStar.Tuple node, AStar.Tuple goal) {
        return Math.pow(node.x - goal.x, 2) + Math.pow(node.y - goal.y, 2);
    }

    private static List<AStar.Tuple> getAdjacentNodes(AStar.Tuple tuple, WorldBeta world) {
        List<AStar.Tuple> adjacencies = new ArrayList<AStar.Tuple>();

        // Up
        if (tuple.x >= 0 && tuple.x < world.getWidth() && tuple.y - 1 >= 0 && tuple.y - 1 < world.getHeight()) {
            adjacencies.add(new AStar.Tuple(tuple.x, tuple.y - 1));

        }

        // Down
        if (tuple.x >= 0 && tuple.x < world.getWidth() && tuple.y + 1 >= 0 && tuple.y + 1 < world.getHeight()) {
            adjacencies.add(new AStar.Tuple(tuple.x, tuple.y + 1));

        }

        // Left
        if (tuple.x - 1 >= 0 && tuple.x - 1 < world.getWidth() && tuple.y >= 0 && tuple.y < world.getHeight()) {
            adjacencies.add(new AStar.Tuple(tuple.x - 1, tuple.y));

        }

        // Right
        if (tuple.x + 1 >= 0 && tuple.x + 1 < world.getWidth() && tuple.y >= 0 && tuple.y < world.getHeight()) {
            adjacencies.add(new AStar.Tuple(tuple.x + 1, tuple.y));

        }

        return adjacencies;
    }

    private static List<AStar.Tuple> reconstructPath(Map<AStar.Tuple, AStar.Tuple> cameFrom, AStar.Tuple current) {
        List<AStar.Tuple> result = new ArrayList<AStar.Tuple>();

        while (cameFrom.containsKey(current)) {
            result.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(result);
        return result;

    }

    public static class Tuple {
        int x;
        int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Tuple(Point point) {
            this.x = (int) point.getX();
            this.y = (int) point.getY();
        }

        public boolean equals(Object object) {
            if (!(object instanceof AStar.Tuple)) {
                return false;
            }
            AStar.Tuple tuple = (AStar.Tuple) object;
            return tuple.x == this.x && tuple.y == this.y;
        }

        public int hashCode() {
            return (11 + 19 * x) * 23 + y;
        }

        public String toString() {
            return String.format("(%d, %d)", x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
