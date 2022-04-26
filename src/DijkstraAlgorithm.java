import java.util.*;

public class DijkstraAlgorithm {

    private Set<Town> settledNodes;
    private Set<Town> unsettledNodes;
    private Map<Town, Town> predecessors;
    private Map<Town, Integer> distance;
    private final Graph graph;

    public DijkstraAlgorithm(Graph graph){
        this.graph = graph;
    }

    public void execute(Town source) {
        settledNodes = new HashSet<Town>();
        unsettledNodes = new HashSet<Town>();
        distance = new HashMap<Town, Integer>();
        predecessors = new HashMap<Town, Town>();
        distance.put(source, 0);
        unsettledNodes.add(source);
        while (unsettledNodes.size() > 0) {
            Town node = getMinimum(unsettledNodes);
            settledNodes.add(node);
            unsettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Town node){
        Set<Town> adjacentNodes = graph.neighbours(node);
        for (Town target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unsettledNodes.add(target);
            }
        }
    }

    private Town getMinimum(Set<Town> vertexes){
        Town minimum = null;
        for (Town vertex : vertexes){
            if (minimum == null){
                minimum = vertex;
            }
            else{
                if (getShortestDistance(vertex) < getShortestDistance(minimum)){
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Town town){
        return settledNodes.contains(town);
    }

    private int getShortestDistance(Town destination){
        Integer d = distance.get(destination);
        if (d == null) {
        	return Integer.MAX_VALUE;
        }
        else {
        	return d;
        }
        
    }

    private int getDistance(Town node, Town target){
        Road road = graph.getEdge(node, target);
        return road.getWeight();
    }

    public LinkedList<Town> getPath(Town target) {
        LinkedList<Town> path = new LinkedList<Town>();
        Town step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}
