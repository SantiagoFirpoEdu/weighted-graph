import java.util.*;
import java.util.stream.Collectors;

public class WeightedGraph
{
    public WeightedGraph()
    {
        this.adjacencyList = new HashMap<>();
        nodes = new HashSet<>();
    }

    public static void main(String[] args)
    {
        WeightedGraph g = new WeightedGraph();
        g.addEdge(0, 1, 33);
        g.addEdge(0, 2, 10);
        g.addEdge(1, 2, 99);
        g.addEdge(0, 3, 200);
    }

    public void addEdge(int from, int to, int weight)
    {
        Edge e1 = new Edge(from, to, weight);
        List<Edge> edges = findOrAddEdgeList(from);
        edges.add(e1);

        Edge e2 = new Edge(to, from, weight);
        findOrAddEdgeList(to).add(e2);

        nodes.add(from);
        nodes.add(to);
    }

    private List<Edge> findOrAddEdgeList(int from)
    {
        if (!adjacencyList.containsKey(from))
        {
            adjacencyList.put(from, new ArrayList<>());
        }
        List<Edge> edges = adjacencyList.get(from);
        return edges;
    }

    public void removeEdge(int from, int to)
    {
        List<Edge> neighbors = adjacencyList.get(from);
        List<Edge> otherNeighbors = adjacencyList.get(to);

        neighbors.removeIf(edge -> edge.to == to);
        otherNeighbors.removeIf(edge -> edge.to == from);
    }

    public int getDegree(int vertice)
    {
        return adjacencyList.get(vertice).size();
    }

    public int getEdgeAmount(int node)
    {
        return adjacencyList.get(node).size();
    }

    public int getNodeAmount()
    {
        return nodes.size();
    }

    public List<Edge> getEdges(int node)
    {
        List<Edge> edges = adjacencyList.get(node);
        return edges != null ? edges : new ArrayList<>();
    }

    public Set<Integer> getNodes()
    {
        return nodes;
    }

    public void addNode(int node)
    {
        nodes.add(node);
    }

    static class Edge
    {
        public int from;
        public int to;
        public int weight;

        @Override
        public int hashCode()
        {
            return Objects.hash(from, to, weight);
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (o instanceof Edge edge)
            {
                return from == edge.from
                    && to == edge.to
                    && weight == edge.weight;
            }
            return false;
        }

        public Edge(int from, int to, int weight)
        {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private final HashMap<Integer, List<Edge>> adjacencyList;
    private final HashSet<Integer> nodes;
}
