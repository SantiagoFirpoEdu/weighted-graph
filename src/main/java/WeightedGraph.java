import java.util.ArrayList;
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
                    builder.append("\t").append(adjacencyList[i].get(j).v).append("--").append(adjacencyList[i].get(j).w).append("  [label=").append(adjacencyList[i].get(j).weight).append("]").append(";").append(System.lineSeparator());
                    alreadyPrinted[adjacencyList[i].get(j).v][adjacencyList[i].get(j).w] = true;
                    alreadyPrinted[adjacencyList[i].get(j).w][adjacencyList[i].get(j).v] = true;
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
        public int v;
        public int w;
        public int weight;

        public Edge(int v, int w, int weight)
        {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }
    private final ArrayList<Edge>[] adjacencyList;
    private int edgeAmount;
}
