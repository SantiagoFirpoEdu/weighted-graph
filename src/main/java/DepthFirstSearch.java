import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DepthFirstSearch
{
    public int[] preOrder;
    public int[] postOrder;
    public DepthFirstSearch(WeightedGraph weightedGraph, int startingVertice)
    {
        int nodeAmount = weightedGraph.getNodeAmount();
        visited = new boolean[nodeAmount];
        predecessor = new int[nodeAmount];
        Deque<Integer> queue = new ArrayDeque<>();
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
                queue.add(neighbor);
            }
        }
    }

    public void debugPrintResult()
    {
        //TODO: implement this
        //imprimir os arrais de visitados, antecessor, preordem e posordem.
        //preordem e posordem devem mostrar o caminho percorrido em pre e pos ordem;
    }
    private boolean[] visited;
    private int[] predecessor;
}
