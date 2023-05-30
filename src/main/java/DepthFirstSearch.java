import java.util.*;

public class DepthFirstSearch
{
    public DepthFirstSearch(WeightedGraph weightedGraph, int startingVertice)
    {
        graph = weightedGraph;
        this.startingVertice = startingVertice;
        preOrder = new ArrayList<>();
        postOrder = new ArrayList<>();
        Collections.fill(preOrder, -1);
        Collections.fill(postOrder, -1);
        executeSearch();
    }

    private void executeSearch()
    {
        visited = new HashSet<>();
        predecessors = new HashMap<>();
        Deque<Integer> openList = new ArrayDeque<>();
        openList.push(startingVertice);

        while (!openList.isEmpty())
        {
            int toBeVisited = openList.pop();

            if (visited.contains(toBeVisited))
            {
                continue;
            }

            visited.add(toBeVisited);
            preOrder.add(toBeVisited);

            var edges = graph.getEdges(toBeVisited);
            boolean allNeighborsVisited = true;

            for (WeightedGraph.Edge edge : edges)
            {
                int neighbor = edge.to;
                if (!visited.contains(neighbor))
                {
                    predecessors.put(neighbor, toBeVisited);
                    openList.push(neighbor);
                    allNeighborsVisited = false;
                }
            }

            if (allNeighborsVisited)
            {
                postOrder.add(toBeVisited);
            }
        }

        // Reverse the post-order array
        int i = 0;
        int j = postOrderIndex - 1;
        while (i < j)
        {
            int temp = postOrder.get(i);
            postOrder.set(i, postOrder.get(j));
            postOrder.set(j, temp);
            i++;
            j--;
        }
    }



    public void debugPrintResult()
    {
        //TODO: implement this
        //imprimir os arrais de visitados, antecessor, preordem e posordem.
        //preordem e posordem devem mostrar o caminho percorrido em pre e pos ordem;

        System.out.println("\n   -------------------   \nDepth-first search results: ");

        System.out.println("\n- Visited nodes: \n");
        for (int nodeId : visited)
        {
            System.out.printf(" Visited node of number %d%n", nodeId);
        }

        System.out.println("\n- Predecessors: \n");
        Set<Map.Entry<Integer, Integer>> predecessorsEntries = predecessors.entrySet();
        for (var predecessorKeyValue : predecessorsEntries)
        {
            System.out.printf(" Predecessor of node %d is %d%n", predecessorKeyValue.getKey(), predecessorKeyValue.getValue());
        }

        System.out.println("\n- Preorder: \n");

        for (int element : preOrder)
        {
            System.out.println(element);
        }

        System.out.println("\n- Post order: \n");

        for (int element : postOrder)
        {
            System.out.println(element);
        }
    }

    private final WeightedGraph graph;
    private final int startingVertice;
    public List<Integer> preOrder;
    public List<Integer> postOrder;
    private HashSet<Integer> visited;
    private HashMap<Integer, Integer> predecessors;
    private int preorderIndex;
    private int postOrderIndex;

}
