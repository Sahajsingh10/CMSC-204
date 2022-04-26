import java.util.*;

public class Graph implements GraphInterface<Town, Road>{

    public Set<Road> edges;
    public Set<Town> vertices;
    public DijkstraAlgorithm algo;

    public Graph(){
        edges = new HashSet<>();
        vertices = new HashSet<>();
    }

    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        if(sourceVertex == null || destinationVertex == null){
            return null;
        }
        for(Road edge : edges){
            if ((edge.source == sourceVertex) && (edge.destination == destinationVertex)){
                return edge;
            }
            else if ((edge.destination == sourceVertex) && (edge.source == destinationVertex)){
                return edge;
            }
        }
        return null;
    }

    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

        if(sourceVertex == null || destinationVertex == null){
            throw new NullPointerException();
        }

        Road road = new Road(sourceVertex, destinationVertex, weight, description);

        if(!(vertices.contains(sourceVertex) && vertices.contains(destinationVertex))){
            throw new IllegalArgumentException();
        }

        edges.add(road);
        return road;
    }

    @Override
    public boolean addVertex(Town town) {
        if(town == null){
            throw new NullPointerException();
        }
        return vertices.add(town);
    }

    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        for(Road edge : edges){
            if ((edge.source == sourceVertex) && (edge.destination == destinationVertex)){
                return true;
            }
            if ((edge.destination == sourceVertex) && (edge.source == destinationVertex)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsVertex(Town town) {
        return vertices.contains(town);
    }

    @Override
    public Set<Road> edgeSet() {
        return edges;
    }

    @Override
    public Set<Road> edgesOf(Town vertex) {

        if(!vertices.contains(vertex)){
            throw new IllegalArgumentException();
        }

        if(vertex == null){
            throw new NullPointerException();
        }

        Set<Road> connEdges = new HashSet<>();
        for(Road edge : edges){
            if(edge.contains(vertex)){
                connEdges.add(edge);
            }
        }
        return connEdges;
    }

    public Set<Town> neighbours(Town vertex){
        Set<Road> connEdges = this.edgesOf(vertex);
        Set<Town> neighbours = new HashSet<>();
        for(Road road : connEdges){
            if(road.source != vertex){
                neighbours.add(road.source);
            }
            else{
                neighbours.add(road.destination);
            }
        }
        return neighbours;
    }

    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road r = new Road(sourceVertex, destinationVertex, weight, description);
        Road toRemove = null;
        for(Road edge : edges){
            if(edge.graphEquals(r)){
                toRemove = edge;
            }
        }
        if(toRemove != null){
            edges.remove(toRemove);
        }
        return toRemove;
    }

    @Override
    public boolean removeVertex(Town town) {
        return vertices.remove(town);
    }

    @Override
    public Set<Town> vertexSet() {
        return vertices;
    }

    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        this.dijkstraShortestPath(sourceVertex);
        LinkedList<Town> list = this.algo.getPath(destinationVertex);
        if (list == null){
            return new ArrayList<>();
        }
        ArrayList<String> shortest = new ArrayList<>();
        for (int i=0;i<list.size()-1;i++){
            Town town = list.get(i);
            Town dest = list.get(i+1);
            Road rd = this.getEdge(town, dest);
            shortest.add(town.name + " via " + rd.name + " to " + dest.name + " " + rd.weight + " mi");
        }
        return shortest;
    }

    @Override
    public void dijkstraShortestPath(Town sourceVertex) {
        algo = new DijkstraAlgorithm(this);
        algo.execute(sourceVertex);
    }
}
