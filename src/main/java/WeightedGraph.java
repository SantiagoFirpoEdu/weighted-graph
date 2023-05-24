import java.util.*;
import java.util.stream.Collectors;

public class WeightedGraph
{
    public WeightedGraph(int nodeAmount)
    {
        this.nodeAmount = nodeAmount;
        this.adjacencyList = new ArrayList[this.nodeAmount];
        for (int i = 0; i < this.nodeAmount; i++)
        {
            this.adjacencyList[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args)
    {
        WeightedGraph g = new WeightedGraph(4);
        g.addEdge(0, 1, 33);
        g.addEdge(0, 2, 10);
        g.addEdge(1, 2, 99);
        g.addEdge(0, 3, 200);

        System.out.println(g.toDot());
    }

    public void addEdge(int from, int to, int weight)
    {
        Edge e1 = new Edge(from, to, weight);
        adjacencyList[from].add(e1);

        Edge e2 = new Edge(to, from, weight);
        adjacencyList[to].add(e2);

        nodes.add(from);
        nodes.add(to);
    }

    public String toDot()
    {
        StringBuilder builder = new StringBuilder("graph G { " + System.lineSeparator());
        for (int i = 0; i < nodeAmount; i++)
        {
            builder.append("\t")
                   .append(i)
                   .append(";")
                   .append(System.lineSeparator());
        }
        boolean[][] alreadyPrinted = new boolean[nodeAmount][nodeAmount];
        for (int i = 0; i < nodeAmount; i++)
        {
            for (int j = 0; j < adjacencyList[i].size(); j++)
            {
                if (!alreadyPrinted[i][j])
                {
                    builder.append("\t").append(adjacencyList[i].get(j).from).append("--").append(adjacencyList[i].get(j).to).append("  [label=").append(adjacencyList[i].get(j).weight).append("]").append(";").append(System.lineSeparator());
                    alreadyPrinted[adjacencyList[i].get(j).from][adjacencyList[i].get(j).to] = true;
                    alreadyPrinted[adjacencyList[i].get(j).to][adjacencyList[i].get(j).from] = true;
                }
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public void removeEdge(int v, int w)
    {
        adjacencyList[v] =
                adjacencyList[v]
                 .stream()
                 .filter(entry -> entry.from != v && entry.to != w)
                 .collect(Collectors.toList());
    }

    public int getDegree(int vertice)
    {
        return adjacencyList[vertice].size();
    }

    public int getEdgeAmount(int node)
    {
        return adjacencyList[node].size();
    }

    public int getNodeAmount()
    {
        return nodeAmount;
    }

    public List<Edge> getEdges(int node)
    {
        return adjacencyList[node];
    }

    public HashSet<Integer> getNodes()
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

    private final List<Edge>[] adjacencyList;
    private final HashSet<Integer> nodes = new HashSet<>();
    private int nodeAmount;
}
