import java.util.*;

public class AirlineRouteMap {

    static class Airport {
        String name;
        List<Edge> edges;

        Airport(String name) {
            this.name = name;
            this.edges = new ArrayList<>();
        }
    }

    static class Edge {
        Airport destination;
        double weight; //e.g., distance, flight time

        Edge(Airport destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // Create airports
        Airport JFK = new Airport("JFK");
        Airport LAX = new Airport("LAX");
        Airport LHR = new Airport("LHR");
        Airport HND = new Airport("HND");

        // Create edges (flights) -  distances are examples
        JFK.edges.add(new Edge(LAX, 4142)); //Distance in km, for example
        JFK.edges.add(new Edge(LHR, 5570));
        LAX.edges.add(new Edge(JFK, 4142));
        LAX.edges.add(new Edge(HND, 8040));
        LHR.edges.add(new Edge(JFK, 5570));
        LHR.edges.add(new Edge(HND, 9600));
        HND.edges.add(new Edge(LAX, 8040));
        HND.edges.add(new Edge(LHR, 9600));


        // Print the route map
        System.out.println("Airline Route Map:");
        printRouteMap(JFK, LAX, LHR, HND);
    }


    static void printRouteMap(Airport... airports) {
        for (Airport airport : airports) {
            System.out.print(airport.name + ":");
            for (Edge edge : airport.edges) {
                System.out.print(" -> " + edge.destination.name + " (" + edge.weight + "km)");
            }
            System.out.println();
        }
    }
}