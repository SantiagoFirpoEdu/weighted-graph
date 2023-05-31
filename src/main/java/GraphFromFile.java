import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GraphFromFile
{

    public static WeightedGraph readGraphFile(String filePath)
    {
        WeightedGraph graph = new WeightedGraph();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("%s.txt".formatted(filePath))))
        {
            reader.lines().forEach(line ->
            {
                Scanner lineScanner = new Scanner(line);
                if (!lineScanner.hasNext())
                {
                    return;
                }

                String nodeId = lineScanner.next();
                int parsedNodeId = Integer.parseInt(nodeId);
                graph.addNode(parsedNodeId);
                if (lineScanner.hasNext())
                {
                    lineScanner.next();
                    StringBuilder edgesBuilder = new StringBuilder(lineScanner.nextLine());
                    edgesBuilder.deleteCharAt(0);
                    String edges = edgesBuilder.toString();

                    var splitEdges = edges.split("\\|");
                    for (var splitEdge : splitEdges)
                    {
                        String[] s = splitEdge.split(" ");
                        var numbers = Arrays.stream(s).map(Integer::parseInt).toList();
                        int from = numbers.get(0);
                        int to = numbers.get(1);
                        int weight = numbers.get(2);
                        graph.addEdge(from, to, weight);
                    }
                }
            });
        }
        catch (IOException ioException)
        {
            throw new RuntimeException(ioException);
        }

        return graph;
    }

    public static boolean writeGraphToFile(WeightedGraph graph, String filePath)
    {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(("%s.txt".formatted(filePath)))))
        {
            for (int node : graph.getNodes())
            {
                List<WeightedGraph.Edge> edges = graph.getEdges(node);
                writer.write(String.valueOf(node));
                if (!edges.isEmpty())
                {
                    writer.write(" - ");
                }
                for (WeightedGraph.Edge edge : edges)
                {
                    writer.write(edge.from + " " + edge.to + " " + edge.weight + "|");
                }
                writer.write("\n");
            }
        }
        catch (IOException ioException)
        {
            return false;
        }

        return true;
    }

    private GraphFromFile()
    {
    }
}
