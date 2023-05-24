import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch
{
    public BreadthFirstSearch(WeightedGraph weightedGraph, int startingVertice)
    {
        int edgeAmount = weightedGraph.getEdgeAmount();
        visited = new boolean[edgeAmount];
        predecessor = new int[edgeAmount];
        distance = new int[edgeAmount];
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
    private boolean[] visited;
    private int[] predecessor;
    private int[] distance; //considering 1 for each edge
}
