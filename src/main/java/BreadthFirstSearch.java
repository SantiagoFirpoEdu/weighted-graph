import java.util.*;

public class BreadthFirstSearch
{
    public BreadthFirstSearch(WeightedGraph weightedGraph, int startingVertice)
    {
        visited = new HashSet<>();
        predecessors = new HashMap<>();
        distances = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingVertice);

        while (!queue.isEmpty())
        {
            Integer toBeVisited = queue.poll();
            visited.add(toBeVisited);

            var edges = weightedGraph.getEdges(toBeVisited);
            for (WeightedGraph.Edge edge : edges)
            {
                int neighbor = edge.to;
                if (visited.contains(neighbor))
                {
                    continue;
                }

                visited.add(neighbor);
                predecessors.put(neighbor, toBeVisited);

                if (distances.containsKey(neighbor))
                {
                    int currentDistance = distances.get(neighbor);
                    distances.put(neighbor, currentDistance + edge.weight);
                }
                queue.add(neighbor);
            }
        }
    }

    public void debugPrintResult()
    {
        //TODO: implement this
        //deve mostrar o caminho percorrido para achar todos os vertices e as distancias
        //exibir os arrays visitados, antecessor e distancia

        System.out.println("Breadth-first search results: ");

        System.out.println("Visited nodes:");
        for (int nodeId : visited)
        {
            System.out.printf("Visited node of number %d%n", nodeId);
        }

        System.out.println("Predecessors: ");
        Set<Map.Entry<Integer, Integer>> predecessorsEntries = predecessors.entrySet();
        for (var predecessorKeyValue : predecessorsEntries)
        {
            System.out.printf(" Predecessor of node %d is %d%n", predecessorKeyValue.getKey(), predecessorKeyValue.getValue());
        }

        System.out.println("Distances: ");
        Set<Map.Entry<Integer, Integer>> distancesEntries = distances.entrySet();
        for (var distanceKeyValue : distancesEntries)
        {
            System.out.printf(" Distance of node %d is %d%n", distanceKeyValue.getKey(), distanceKeyValue.getValue());
        }
    }
    private final HashSet<Integer> visited;
    private final HashMap<Integer, Integer> predecessors;
    private final HashMap<Integer, Integer> distances;
}
