import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface{

    public Graph graph;

    public TownGraphManager(){
        graph = new Graph();
    }

    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        Town t = this.getTown(town1);
        Town u = this.getTown(town2);
        if (t == null || u == null){
            return false;
        }
        graph.addEdge(t, u, weight, roadName);
        return true;
    }

    @Override
    public String getRoad(String town1, String town2) {
        Town t = this.getTown(town1);
        Town u = this.getTown(town2);
        Road r = graph.getEdge(t, u);
        if (r == null){
            return null;
        }
        else{
            return r.name;
        }
    }

    @Override
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    @Override
    public Town getTown(String name) {
        for(Town t : graph.vertexSet()){
            if (t.name.equals(name)){
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean containsTown(String v) {
        return this.getTown(v) != null;
    }

    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return this.getRoad(town1, town2) != null;
    }

    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> roads = new ArrayList<>();
        for (Road r : graph.edgeSet()){
            roads.add(r.name);
        }
        Collections.sort(roads);
        return roads;
    }

    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Town t1 = this.getTown(town1);
        Town t2 = this.getTown(town2);
        Road r = graph.getEdge(t1, t2);
        if (r == null){
            return false;
        }
        if (r.name.equals(road)){
            graph.edges.remove(r);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTown(String v) {
        Town t1 = this.getTown(v);
        return graph.removeVertex(t1);
    }

    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> towns = new ArrayList<>();
        for (Town r : graph.vertexSet()){
            towns.add(r.name);
        }
        Collections.sort(towns);
        return towns;
    }

    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(this.getTown(town1), this.getTown(town2));
    }
}