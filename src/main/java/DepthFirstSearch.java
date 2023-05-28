import java.util.*;

public class DepthFirstSearch
{
    public int[] preOrder;
    public int[] postOrder;
    public DepthFirstSearch(WeightedGraph weightedGraph, int startingVertice)
    {
        graph = weightedGraph;
        this.startingVertice = startingVertice;
        int nodeAmount = weightedGraph.getNodeAmount();
        preOrder = new int[nodeAmount];
        postOrder = new int[nodeAmount];
        Arrays.fill(preOrder, -1);
        Arrays.fill(postOrder, -1);
        ExecuteSearch();
    }

    private void ExecuteSearch()
    {
        visited = new HashSet<>();
        predecessors = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addFirst(startingVertice);

        while (!queue.isEmpty())
        {
            int toBeVisited = queue.removeFirst();
            visited.add(toBeVisited);

            var edges = graph.getEdges(toBeVisited);
            for (WeightedGraph.Edge edge : edges)
            {
                int neighbor = edge.to;
                if (visited.contains(neighbor))
                {
                    continue;
                }
                //TODO (Santiago Firpo) fix post order
                postOrder[postOrderIndex] = neighbor;
                ++postOrderIndex;

                visited.add(neighbor);
                predecessors.put(neighbor, toBeVisited);
                ++preorderIndex;
                preOrder[preorderIndex] = neighbor;

                queue.add(neighbor);
            }
        }
    }

    public void debugPrintResult()
    {
        //TODO: implement this
        //imprimir os arrais de visitados, antecessor, preordem e posordem.
        //preordem e posordem devem mostrar o caminho percorrido em pre e pos ordem;

        System.out.println("Depth-first search results: ");

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

        System.out.println("Preorder: ");

        for (int element : preOrder)
        {
            System.out.println(element);
        }

        System.out.println("Post order: ");

        for (int element : postOrder)
        {
            System.out.println(element);
        }
    }
    private final WeightedGraph graph;
    private HashSet<Integer> visited;
    private HashMap<Integer, Integer> predecessors;

    private final int startingVertice;
    private int preorderIndex;
    private int postOrderIndex;
}
