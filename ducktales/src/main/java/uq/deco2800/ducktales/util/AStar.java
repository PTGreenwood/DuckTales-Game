package uq.deco2800.ducktales.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class AStar {

	public static List<Tuple> aStar(Point startPoint, Point goalPoint, World world) {
		Tuple start = new Tuple(startPoint);
		Tuple goal = new Tuple(goalPoint);
		// Set of points already evaluated

		Set<Tuple> closedSet = new HashSet<Tuple>();

		// Set of discovered nodes yet to be evaluated
		Set<Tuple> openSet = new HashSet<Tuple>();
		openSet.add(start);

		// Most efficient path to a node
		Map<Tuple, Tuple> cameFrom = new HashMap<Tuple, Tuple>();

		// Cost of getting to node
		Map<Tuple, Integer> gScore = new HashMap<Tuple, Integer>();

		gScore.put(start, 0);
		
		/*
		 * For each node, the total cost of getting from the start node to the
		 * goal by passing by that node. That value is partly known, partly
		 * heuristic.
		 */
		Map<Tuple, Integer> fScore = new HashMap<Tuple, Integer>();

		fScore.put(start, heuristicCostEstimate(start, goal));

		while (!openSet.isEmpty()) {
			Tuple current = getMinTuple(openSet, fScore);
			System.out.println(current);

			if (current.equals(goal)) {
				return reconstructPath(cameFrom, current);
			}
			openSet.remove(current);
			closedSet.add(current);

			for (Tuple tuple : getAdjacentNodes(current, world)) {
				if (closedSet.contains(tuple) || !world.isPassable(current.x, current.y)) {
					continue;
				}
				
				// gScore default value is infinite, distance from current to
				// neighbour = 1
				int tentativeGScore = gScore.getOrDefault(current, Integer.MAX_VALUE) + 1;

				if (!openSet.contains(tuple)) {
					openSet.add(tuple);
				} else if (tentativeGScore >= gScore.getOrDefault(tuple, Integer.MAX_VALUE)) {
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
	
	private static Tuple getMinTuple(Set<Tuple> tuples, Map<Tuple, Integer> fScores){
		int minF = Integer.MAX_VALUE;
		Tuple min = null;
		
		for(Tuple tuple : tuples){
			if(fScores.getOrDefault(tuple, Integer.MAX_VALUE) < minF){
				min = tuple;
			}
		}
		
		return min;
	}

	private static int heuristicCostEstimate(Tuple node, Tuple goal) {
		return Math.abs(node.x - goal.x) + Math.abs(node.y - goal.y);
	}

	private static List<Tuple> getAdjacentNodes(Tuple tuple, World world) {
		List<Tuple> adjacencies = new ArrayList<Tuple>();
		// Up
		if (tuple.x >= 0 && tuple.x <= world.getWidth() && tuple.y - 1 >= 0 && tuple.y - 1 <= world.getHeight()) {
			adjacencies.add(new Tuple(tuple.x, tuple.y - 1));

		}

		// Down
		if (tuple.x >= 0 && tuple.x <= world.getWidth() && tuple.y + 1 >= 0 && tuple.y + 1 <= world.getHeight()) {
			adjacencies.add(new Tuple(tuple.x, tuple.y + 1));

		}

		// Left
		if (tuple.x - 1 >= 0 && tuple.x - 1 <= world.getWidth() && tuple.y >= 0 && tuple.y <= world.getHeight()) {
			adjacencies.add(new Tuple(tuple.x - 1, tuple.y));

		}

		// Right
		if (tuple.x + 1 >= 0 && tuple.x + 1 <= world.getWidth() && tuple.y >= 0 && tuple.y <= world.getHeight()) {
			adjacencies.add(new Tuple(tuple.x + 1, tuple.y));

		}

		return adjacencies;
	}

	private static List<Tuple> reconstructPath(Map<Tuple, Tuple> cameFrom, Tuple current) {
		List<Tuple> result = new ArrayList<Tuple>();

		while (cameFrom.containsKey(current)) {
			result.add(current);
			current = cameFrom.get(current);
		}
		return result;

	}

	private static class Tuple {
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
			if (!(object instanceof Tuple)) {
				return false;
			}
			Tuple tuple = (Tuple) object;
			return tuple.x == this.x && tuple.y == this.y;
		}

		public int hashCode() {
			return (11 + 19 * x) * 23 + y;
		}
		
		public String toString(){
			return String.format("(%d, %d)", x, y);
		}
	}
	
	
	public static void main(String[] args){
		World world = new World();
		Point point1 = new Point(1, 1);

		Point point2 = new Point(3, 3);
		
		List<Tuple> list = aStar(point1, point2, world);
		
		System.out.println(list);
	}

}
