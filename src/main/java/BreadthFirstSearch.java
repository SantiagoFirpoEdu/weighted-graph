import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch
{
    public BreadthFirstSearch(WeightedGraph weightedGraph, int startingVertice)
    {
        int nodeAmount = weightedGraph.getNodeAmount();
        visited = new boolean[nodeAmount];
        predecessor = new int[nodeAmount];
        distance = new int[nodeAmount];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingVertice);

        while (!queue.isEmpty())
        {
            Integer toBeVisited = queue.poll();
            visited[toBeVisited] = true;

            var edges = weightedGraph.getEdges(toBeVisited);
            for (WeightedGraph.Edge edge : edges)
            {
                int neighbor = edge.to;
                if (visited[neighbor])
                {
                    continue;
                }

                visited[neighbor] = true;
                predecessor[neighbor] = toBeVisited;
                distance[neighbor] += edge.weight;
                queue.add(neighbor);
            }
        }
    }

    public void debugPrintResult()
    {
        //TODO: implement this
        //deve mostrar o caminho percorrido para achar todos os vertices e as distancias
        //exibir os arrays visitados, antecessor e distancia
    }
    private final boolean[] visited;
    private final int[] predecessor;
    private final int[] distance; //considering 1 for each edge
}
