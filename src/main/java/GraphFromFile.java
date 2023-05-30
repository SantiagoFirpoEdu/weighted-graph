import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GraphFromFile
{

    public static WeightedGraph readGraphFile(String filePath)
    {
        //TODO: implement this
        return null;
    }

    public static boolean writeGraphToFile(WeightedGraph graph, String filePath)
    {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of((filePath + ".txt"))))
        {
            writer.write(graph.getNodeAmount() + "\n");
            for (int node : graph.getNodes())
            {
                writer.write(node + " - ");
                List<WeightedGraph.Edge> edges = graph.getEdges(node);
                for (WeightedGraph.Edge edge : edges)
                {
                    writer.write(edge.from + " " + edge.to + " " + edge.weight + "|");
                }
                writer.write("\n");

            }
            writer.close();
        }
        catch (IOException e)
        {
            return false;
        }

        return true;
    }

    private GraphFromFile()
    {
    }
}
