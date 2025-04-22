import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EveryPath {
    static class Edge {
        String to;
        int weight;

        Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    private static Map<String, List<Edge>> adjList = new HashMap<>();

    public static void addEdge(String from, String to, int weight) {
        if (!adjList.containsKey(from)) {
            adjList.put(from, new ArrayList<>());
        }
        adjList.get(from).add(new Edge(to, weight));
    }

    public static void findPaths(String u, String w, int targetWeight) {
        List<String> path = new ArrayList<>();
        findPathsUntil(u, w, targetWeight, 0, path);
    }

    private static void findPathsUntil(String current, String target, int targetWeight, int currentWeight, List<String> path) {
        path.add(current);
        if (current.equals(target) && currentWeight == targetWeight) {
            System.out.println(path);
        }

        if (adjList.containsKey(current)) {
            for (Edge edge : adjList.get(current)) {
                if (!path.contains(edge.to)) {
                    findPathsUntil(edge.to, target, targetWeight, currentWeight + edge.weight, path);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        addEdge("A", "B", 2);
        addEdge("B", "C", 3);
        addEdge("C", "D", 2);
        addEdge("D", "E", 1);
        addEdge("A", "E", 7);
        addEdge("A", "C", 5);
        addEdge("B", "D", 4);

        String u = "A";
        String w = "E";

        findPaths(u, w, 7);
    }
}
