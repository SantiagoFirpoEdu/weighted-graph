import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

public class WeightedGraph
{
    public WeightedGraph(int edgeAmount)
    {
        this.edgeAmount = edgeAmount;
        this.adjacencyList = new ArrayList[this.edgeAmount];
        for (int i = 0; i < this.edgeAmount; i++)
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

    public void addEdge(int v, int w, int weight)
    {
        Edge e1 = new Edge(v, w, weight);
        adjacencyList[v].add(e1);

        Edge e2 = new Edge(w, v, weight);
        adjacencyList[w].add(e2);
    }

    public String toDot()
    {
        StringBuilder builder = new StringBuilder("graph G { " + System.lineSeparator());
        for (int i = 0; i < edgeAmount; i++)
        {
            builder.append("\t")
                   .append(i)
                   .append(";")
                   .append(System.lineSeparator());
        }
        boolean[][] alreadyPrinted = new boolean[edgeAmount][edgeAmount];
        for (int i = 0; i < edgeAmount; i++)
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
        //implementar
    }

    public Optional<Integer> getDegree(int vertice)
    {
        //implementar
        return Optional.of(0);
    }

    public int getVerticesAmount()
    {
        //implementar
        return 0;
    }

    public int getEdgeAmount()
    {
        //implementar
        return 0;
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
    private final ArrayList<Edge>[] adjacencyList;
    private int edgeAmount;
}
